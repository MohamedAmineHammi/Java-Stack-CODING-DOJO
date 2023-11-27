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
<link rel="stylesheet" type="text/css" href="/styleShow.css">

</head>
<body>

<h4>Here's your OMIKUJI !</h4>
<div>
<p>In ${number } years, you will live in ${cityName } with ${personName } as your roommate, ${hobby } 
for a living. The next time you see a ${livingThing }, you will have good luck. Also, ${someThing }</p>
</div>
<a href="http://localhost:8080/omikuji">Go Back</a>
</body>
</html>