<%-- //[START all]--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>

<%-- //[START imports]--%>
<%@ page import="com.googlecode.objectify.Key" %>
<%@ page import="com.googlecode.objectify.ObjectifyService" %>
<%-- //[END imports]--%>

<%@ page import="java.util.List" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <link type="text/css" rel="stylesheet" href="/stylesheets/main.css"/>
</head>

<body>

<h1>CLOUD COMPUTING</h1>



<!--- TODO : Upadte servlet ----->

<h3>File Upload:</h3>
Select a file to upload: <br />

<!--<form action="/upload" method="post">
    <div><input type="submit" value="Upload file"/></div>
    <input type="hidden" name="guestbookName" value="${fn:escapeXml(guestbookName)}"/>
</form>-->



<form action="/upload" method="post"
      enctype="multipart/form-data">
    <input type="file" name="file" size="50" accept="application/pdf"/>
    <br />
    <input type="submit" value="Upload File" />
</form>

<%-- //[END datastore]
<form action="/upload.jsp" method="get">
    <div><input type="text" name="guestbookName" value="${fn:escapeXml(guestbookName)}"/></div>
    <div><input type="submit" value="Switch Guestbook"/></div>
</form>--%>

</body>
</html>
<%-- //[END all]--%>



