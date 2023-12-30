<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<title>Course Platform - Dashboard</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

<!-- YOUR own local CSS -->
<link rel="stylesheet" type="text/css" href="/css/style.css">

<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>



</head>
<body>

	<div
		class="container-fluid vh-100 mt-5 custom-width align-items-center">

		<h1>INSTRUCTOR, Sir ${user.userName}.</h1>
		<p>
			<a href="/logout" class="btn btn-outline-secondary">Log Out</a>
		</p>

		<h4>Course Schedule &#128183;&#128467;</h4>
		<br />

		<table class="table">
			<thead>
				<tr>
					<th>Class Name</th>
					<th>Instructor</th>
					<th>WeekDay</th>
					<th>Price</th>
					<th style="color: #CC00CC;">Time</th>
					<th>&#128271</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="oneCourse" items="${courses}">
					<tr>
						<td><a href="/courses/${oneCourse.id}"><c:out
									value="${oneCourse.name}"></c:out></a></td>


						<td><c:out value="${oneCourse.user.userName}"></c:out></td>
						<td><c:out value="${oneCourse.day}"></c:out></td>
						<td>$<c:out value="${oneCourse.price}"></c:out></td>
						<td style="color: #CC00CC;"><c:out value="${oneCourse.time}"></c:out></td>
						<td><c:set var="isUser"
								value="${oneCourse.user.id == user.id}" /> <c:choose>
								<c:when test="${isUser}">
									<p>
										<a href="/courses/${oneCourse.id}/edit"
											class="btn btn-outline-warning">Edit</a>
									</p>
								</c:when>
							</c:choose></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<a href="/courses/new"
			class="col-md-12 btn btn-outline-primary btn-block">+ New Course</a>

	</div>

</body>
</html>