<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<title>Course Details</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

<!-- YOUR own local CSS -->
<link rel="stylesheet" type="text/css" href="/css/style.css">

<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript" src="/js/clearErrors.js"></script>


</head>
<body>

	<div
		class="container-fluid vh-100 mt-5 custom-width  align-items-center">

		<h1>${course.name} &#128214;</h1>
		<p>
			<a href="/home" class="btn btn-secondary">Dashboard</a>
		</p>
		<br>

		<p>Day: ${course.day}</p>
		<p>Cost: $${course.price}</p>
		<p style="color: #CC00CC;">Time: ${course.time}</p>
		<br>
		<p>${course.description}</p>
		<br>

		<c:set var="studentsExist" value="${course.studentsCount > 0 }" />
		<c:choose>
			<c:when test="${studentsExist}">
				<h3 style="color: #CC00CC;">Students :</h3>
				<c:forEach var="oneStudent" items="${students}">

					<ul style="color: #CC00CC;">&#128114;
						${oneStudent.studentName} - ${oneStudent.studentEmail }
					</ul>

				</c:forEach>
			</c:when>
		</c:choose>

		<c:set var="isUser" value="${course.user.id == user.id}" />

		<c:choose>
			<c:when test="${isUser}">
				<hr class="my-4">

				<h5 style="color: #CC00CC;">Add Students To Course :</h5>
				<br>
				<form:form action="/new/student" method="POST"
					modelAttribute="student">

					<input type="hidden" name="courseId" value="${course.id}">

					<form:errors id="studentStudentNameErrors" path="studentName"
						class="text-danger" />
					<div class="form-group d-flex align-items-center">
						<form:label class="col-md-3" path="studentName"
							style="color: #CC00CC;">Student Name </form:label>
						<form:input type="text" class="form-control" id="studentName"
							path="studentName" />
					</div>
					<br>
					<form:errors id="emailErrors" path="studentEmail"
						class="text-danger" />
					<div class="form-group d-flex align-items-center">
						<form:label class="col-md-3" path="studentEmail"
							style="color: #CC00CC;">Email: </form:label>
						<form:input type="email" class="form-control" id="studentEmail"
							path="studentEmail" />
					</div>
					<br>
					<button type="submit"
						class="col-md-12 btn btn-outline-danger btn-block">Add
						Student</button>
				</form:form>
			</c:when>

		</c:choose>
	</div>


</body>
</html>