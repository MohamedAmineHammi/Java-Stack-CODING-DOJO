<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OMIKUJI</title>
<link rel="stylesheet" type="text/css" href="/styleIndex.css">
</head>
<body>
<h4>Send an OMIKUJI</h4>
<div>
<form action="processOm" method="POST">
Pick any number from 5 To 25: <br />
<input type="number" name="number" /> <br />
<br />
Enter the name of any city: <br />
<input name="cityName" /> <br />
<br />
Enter the name of any Real Person: <br />
<input name="personName" /> <br />
<br />
Enter professional endeavor or Hobby: <br />
<input name="hobby" /> <br />
<br />
Enter any type of living thing : <br />
<input name="livingThing" /> <br />
<br />
Say something nice to someone : <br />
<input name="someThing" /> <br />
<br />
Send And Show a Friend
<br />

<button>Send</button>
</form>


</div>
</body>
</html>