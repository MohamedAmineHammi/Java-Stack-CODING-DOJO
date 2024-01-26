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
<title>Driver's License</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-4 p-4 border border-3 bg-secondary text-light">
		<div class="d-flex justify-content-end">
			<a href="/allPersons" class="btn btn-success">Details</a>
			<a href="/" class="btn btn-warning mx-3">Home</a>
		</div>
		
		<h1 class="mb-4">New Person</h1>
		<div>
			<form:form action="/create/person" methods="post" modelAttribute="person">
				<p><form:errors path="firstName" class="text-danger mx-2"></form:errors></p>
				<form:label path="firstName">First Name :</form:label>
				<form:input path="firstName" placeholder="enter your First Name" class="form-control mb-2"/>
			
				<p><form:errors path="lastName" class="text-danger mx-2"></form:errors></p>
				<form:label path="lastName">Last Name :</form:label>
				<form:input path="lastName" placeholder="enter your last Name" class="form-control mb-4"/>
			
				<input type="submit" value="Submit" class="btn btn-primary btn-lg"/>
			</form:form>
		</div>
		
		
	</div>

</body>
</html>