<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<title>Create New Celebrity</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

<!-- YOUR own local CSS -->
<link rel="stylesheet" type="text/css" href="/css/style.css">

<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script type="text/javascript" src="/js/clearErrors.js"></script>


</head>
<body>


	<div class="container custom-width mt-2 p-3 border border-secondary">


		<h1>New Celebrity Page</h1>
		<p>
			<a href="/home">Home</a>
		</p>

		<br>
		<form:form action="/new/celebrity" method="POST"
			modelAttribute="celebrity">
			<input type="hidden" name="user" value="${user.id}">

			<form:errors id="celebrityNameErrors" path="name" class="text-danger" />
			<div class="form-group d-flex align-items-center">
				<form:label class="col-md-3" path="name">Name :</form:label>
				<form:input type="text" class="form-control" id="celebrityName"
					path="name" />
			</div>
			<br>
			<form:errors id="celebrityDetailsErrors" path="name"
				class="text-danger" />
			<div class="form-group d-flex align-items-center">
				<form:label class="col-md-3" path="details">Details :</form:label>
				<form:input type="textarea"  class="form-control"  id="celebrityDetails"
					path="details" />
			</div>
			<br>


			<button type="submit" class="col-md-12 btn btn-primary btn-block">Submit</button>



		</form:form>

	</div>


</body>
</html>