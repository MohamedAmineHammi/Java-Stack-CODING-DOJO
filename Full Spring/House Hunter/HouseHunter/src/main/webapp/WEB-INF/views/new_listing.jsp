<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<title>Create a Listing</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

<!-- YOUR own local CSS -->
<link rel="stylesheet" type="text/css" href="/css/style.css">

<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script type="text/javascript" src="/js/clearErrors.js"></script>

<!-- jQuery Timepicker CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-timepicker/1.13.18/jquery.timepicker.min.css" />

<!-- jQuery Timepicker JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-timepicker/1.13.18/jquery.timepicker.min.js"></script>

</head>
<body>

	<div class="container custom-width mt-2 p-3 border border-secondary">
		<h1>Create a Listing</h1>
		<p>
			<a href="/home" class="btn btn-secondary">Dashboard</a>
		</p>

		<br>
		<form:form action="/new/listing" method="POST"
			modelAttribute="listing">
			<input type="hidden" name="user" value="${user.id}">


			<form:errors id="listingAdressErrors" path="adress"
				class="text-danger" />
			<div class="form-group d-flex align-items-center">
				<form:label class="col-md-3" path="adress">Adress</form:label>
				<form:input type="text" class="form-control" id="listingAdress"
					path="adress" />
			</div>

			<br>
			<form:errors id="priceErrors" path="price" class="text-danger" />
			<div class="form-group d-flex align-items-center">
				<form:label class="col-md-3" path="price">Drop-in Price</form:label>
				<form:input type="number" class="form-control" id="price"
					path="price" min="0" />
			</div>
			<br>
			<form:errors id="dateErrors" path="due_date" class="text-danger" />
			<div class="form-group d-flex align-items-center">
				<form:label class="col-md-3" path="due_date">Due Date</form:label>
				<form:input type="date" class="form-control" id="date"
					path="due_date" />
			</div>
	
			<br>
			<div class="d-flex mt-2 justify-content-around">

				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</form:form>
	</div>



</body>
</html>