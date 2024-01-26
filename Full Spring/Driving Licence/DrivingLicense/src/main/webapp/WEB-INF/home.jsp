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
	<div class="container mt-4 p-4 border border-3 bg-warning">
		<h1>Welcome</h1>
		<h4>if you need a license :</h4>
		<h5 class="mb-4">* Create account than Create your license</h5>

		<div class="d-flex justify-content-between mt-2 p-2">
			<a class="btn btn-success mx-3" href="/person/new">Create Account</a>
			<a class="btn btn-primary" href="/licenses/new">Create license</a>
		</div>
	</div>

</body>
</html>