<!DOCTYPE html>

<%-- //[START all]--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- //[START imports]--%>
<%@ page import="com.googlecode.objectify.Key" %>
<%@ page import="com.googlecode.objectify.ObjectifyService" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%-- //[END imports]--%>

<%@ page import="java.util.List" %>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreService" %>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%-- //[END imports]--%>

<%
    BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
%>

<html lang="en">
<head>
    <title>CO846 CLOUD COMPUTING</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <!--<link type="text/css" rel="stylesheet" href="/stylesheets/main.css"/>-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js"></script>
    <script type="text/javascript" src="bootstrap-filestyle.min.js"> </script>
    <style>
        html, body{
            margin: 0px;
            padding: 0px;
        }
        #mainbar {
            background-color: #0086B2;
        }
        #mainbar li.active a {
            background-color: #399EBF;
        }
        #mainbar a:hover {
            background-color: #3996BF;
        }
        #mainbar a {
            color: white;
        }
        #mainbar .navbar-brand {
            color: #FF8E19;
        }
        #mainform .buttonarea{
            text-align: center;
        }
        #errorbox {
            background-color: #FF8100;
            color: white;
        }
        .btn-primary {
            background-color: #0086B2 !important;
        }
        #resbox {
            margin-top: 60px;
            margin-bottom: 60px;
            text-align: center;
            display: none;
        }
        #resbox.visible {
            display: block !important;
        }
        #resprae, #respost {
            font-size: 1.2em;
        }
        #resprae {
            margin-bottom: 40px;
        }
        #respost {
            background-color: #0086B2;
            color: white;
            padding: 30px;
            margin-top: 20px;
        }
        #res.circle {
            padding: 30px;
            background-color: #FF8100;
            color: white;
            border-radius: 50%;
            display: inline-block;
            width: 180px;
            height: 180px;
            line-height: 110px;
            font-size: 50px;
        }
        #footer {
            background-color: #0086B2;/*#399EBF;*/
            color: white;
            margin-top: 100px;
            padding: 50px;
            text-align: center;
        }
        #footer .t2 {
            font-size: 1.7em;
        }
        #footer .t3 {
            font-size: 1.2em;
        }
        #footer .t4 {
            font-size: 1em;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-default" id="mainbar">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#mainbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">CO846</a>
        </div>
        <div class="collapse navbar-collapse" id="mainbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Analyser</a></li>
                <li><a href="#about">About</a></li>
            </ul>
        </div>
    </div>
</nav>
<div id="errorbox">
    ${error}
</div>
<div id="resbox" class="${resvis}">
    <div class="container">
        <div id="resprae">Non-original content in your document:</div>
        <span class="circle" id="res">${result}</span>
    </div>
    <div id="respost">
        <div class="container">
            <p>Your original content has been added to our database.</p>
            <p>Future checks will recognise attempts to use your original content.</p>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-sm-offset-3 col-sx-12 col-sx-offset-0">
            <form action="<%= blobstoreService.createUploadUrl("/upload") %>" method="post" enctype="multipart/form-data" id="mainform">
                <div class="form-group">
                    <label>Choose the file to upload:</label>
                    <input class="filestyle" type="file" name="file">
                </div>
                <div class="form-group">
                    <label>Encoding:</label>
                    <select class="form-control" name="encoding">
                        <option value="UTF-8">Default</option>
                        <option value="US-ASCII">US-ASCII</option>
                        <option value="ISO-8859-1">ISO-8859-1</option>
                        <option value="UTF-8">UTF-8</option>
                        <option value="UTF-16BE">UTF-16BE</option>
                        <option value="UTF-16LE">UTF-16LE</option>
                        <option value="UTF-16">UTF-16</option>
                    </select>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" unchecked required>
                        I accept that my document contents will be stored and used for future similarity checks
                    </label>
                </div>
                <div class="form-group buttonarea">
                    <button class="btn btn-primary" type="submit">VERIFY</button>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="container-fluid" id="footer">
    <div class="info container" id="about">
        <div class="t3">University of Kent</div>
        <div class="t3">CO846 Cloud Computing</div>
        <hr>
        <div class="t2">Document Similarity Analyser</div>
        <hr>
        <div class="t4">Aikaterini Kalfoudi</div>
        <div class="t4">Antoine Guittet</div>
        <div class="t4">Antoine Roy</div>
        <div class="t4">Nicola Talin</div>
        <hr>
        <div class="t4">December 2015</div>
    </div>
</div>
</body>
</html>


<%-- //[END all]--%>
