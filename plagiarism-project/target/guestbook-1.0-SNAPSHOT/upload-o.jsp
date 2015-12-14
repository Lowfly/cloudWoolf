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

<%
    BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
%>

<html lang="en">
<head>
    <title>CO846 CLOUD COMPUTING</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="/stylesheets/main.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js"></script>
    <style>
        .info {
            text-align: center;
        }
        nav {

        }
        footer {

        }
    </style>
</head>

<!--- TODO : Update servlet ----->


<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">CO846</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
                <li><a href="#">Link</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Link</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<div class="container">
    <hr>
    <%--${debug}--%>
    <div>Choose the file to upload</div>

    <form action="<%= blobstoreService.createUploadUrl("/upload") %>" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <input type="file" name="file"/>
            <%--accept="application/pdf"--%>
        </div>
        <br />
        Encoding:
        <select name="encoding">
            <option value="UTF-8">Default</option>
            <option value="US-ASCII">US-ASCII</option>
            <option value="ISO-8859-1">ISO-8859-1</option>
            <option value="UTF-8">UTF-8</option>
            <option value="UTF-16BE">UTF-16BE</option>
            <option value="UTF-16LE">UTF-16LE</option>
            <option value="UTF-16">UTF-16</option>
        </select>
        <br />
        <div class="checkbox">
            <label>
                <input type="checkbox">
                I accept that my document will be saved for future checks
                </input>
            </label>
        </div>
        <div class="form-group">
            <button class="btn btn-primary" type="submit">VERIFY</button>
        </div>
    </form>
</div>
<div class="container">
    <textarea class="form-control">${fulltext}</textarea>
    ${list}
</div>
<div class="container">
    <h1>${result}</h1>
</div>
<footer>
    <div class="info">
        <h3>University of Kent</h3>
        <h3>CO846 Cloud Computing</h3>
        <h1>Document Similarity Analyser</h1>
    </div>
</footer>
</body>
</html>


<%-- //[END all]--%>