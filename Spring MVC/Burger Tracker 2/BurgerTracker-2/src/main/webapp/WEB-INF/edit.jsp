<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Burger Track</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<!-- 		Display Create Burger Form -->

	<h1>Edit Burger</h1>
	<form:form action="/burgers/${burger.id}" method="post"
		modelAttribute="burger">
		<input type="hidden" name="_method" value="put">

		<div class="container">
			<form:errors style="color: red" path="*" />
		</div>
		<p>
			<form:label path="name">Burger Name</form:label>
			<form:input path="name" />
		</p>
		<p>
			<form:label path="restaurant">Restaurant Name</form:label>
			<form:input path="restaurant" />
		</p>
		<p>
			<form:label path="rating">Rating</form:label>
			<form:input type="number" path="rating" />
		</p>

		<p>
			<form:label path="notes">Notes</form:label>
			<form:input path="notes" />
		</p>
		<input type="submit" value="Edit" />
	</form:form>

	<a href="/">Go Back</a>
</body>
</html>