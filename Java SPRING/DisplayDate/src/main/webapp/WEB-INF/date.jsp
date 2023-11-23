<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%
    // Create a SimpleDateFormat object with the desired date format
    SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM d, ''yy");

    // Get the current date
    Date currentDate = new Date();
    
    // Format the date as a string
    String formattedDate = dateFormat.format(currentDate);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Current Date</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
<p> <%= formattedDate %></p>
</html>