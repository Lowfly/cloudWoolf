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



<form action="<%= blobstoreService.createUploadUrl("/upload") %>" method="post"
      enctype="multipart/form-data">
    <input type="file" name="file" accept="application/pdf"/>
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



