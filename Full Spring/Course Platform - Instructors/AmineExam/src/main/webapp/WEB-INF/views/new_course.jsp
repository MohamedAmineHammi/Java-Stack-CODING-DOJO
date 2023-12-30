<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<title>Create a Course </title>

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
		<h1>Create a Course &#128215;</h1>
		<p>
			<a href="/home" class="btn btn-secondary">Dashboard</a>
		</p>

		<br>
		<form:form action="/new/course" method="POST" modelAttribute="course">
			<input type="hidden" name="user" value="${user.id}">


			<form:errors id="courseNameErrors" path="name" class="text-danger" />
			<div class="form-group d-flex align-items-center">
				<form:label class="col-md-3" path="name">Name</form:label>
				<form:input type="text" class="form-control" id="courseName"
					path="name" />
			</div>
			<br>
			<form:errors id="dayErrors" path="day" class="text-danger" />
			<div class="form-group d-flex align-items-center">
				<form:label class="col-md-3" path="day">Day of Week</form:label>
				<form:select path="day">
					<form:option value="Sunday">Sunday</form:option>
					<form:option value="Monday">Monday</form:option>
					<form:option value="Tuesday">Tuesday</form:option>
					<form:option value="Wednesday">Wednesday</form:option>
					<form:option value="Thursday">Thursday</form:option>
					<form:option value="Friday">Friday</form:option>
					<form:option value="Saturday">Saturday</form:option>
				</form:select>
			</div>
			<br>
			<form:errors id="priceErrors" path="price" class="text-danger" />
			<div class="form-group d-flex align-items-center">
				<form:label class="col-md-3" path="price">Drop-in Price</form:label>
				<form:input type="number" class="form-control" id="price"
					path="price" min="0" />
			</div>
			<br>
			<div>
				<form:errors id="timeErrors" path="time" class="text-danger" />
				<div class="form-group d-flex align-items-center">
					<form:label class="col-md-3" path="time" style="color: red;">Time</form:label>
					<div class="input-group">
						<input type="text" id="time" name="time"
							class="form-control timepicker" placeholder="hh:mm AM/PM"
							required pattern="^(0?[1-9]|1[0-2]):[0-5][0-9] (AM|PM)$"
							value="08:30 PM" style="color: red;">
						<div class="input-group-append">
							<span class="input-group-text"><i class="fa fa-clock-o"></i></span>
						</div>
					</div>
					<small class="form-text text-muted">Format: hh:mm AM/PM</small>
				</div>
			</div>
			<br>
			<div>
				<form:errors id="descriptionErrors" path="description"
					class="text-danger" />
				<div class="form-group d-flex align-items-center">
					<form:label class="col-md-3" path="description">Description</form:label>
					<form:input type="text" class="form-control" id="description"
						path="description" />
				</div>
			</div>
			<br>
			<div class="d-flex mt-2 justify-content-around">
				<p>
					<a href="/home" class="btn btn-danger">Cancel</a>
				</p>
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</form:form>
	</div>

	<script>
$(document).ready(function() {
	$('.timepicker').timepicker({
		timeFormat: 'HH:mm',
		interval: 15,
		minTime: '00:00',
		maxTime: '23:59',
		dropdown: true,
		scrollbar: true
		
	var timeValue = "10:45"; 
	});
});
</script>

</body>
</html>