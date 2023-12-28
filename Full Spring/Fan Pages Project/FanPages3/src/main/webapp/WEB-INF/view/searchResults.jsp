<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<title>Search Celebrity</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

<!-- YOUR own local CSS -->
<link rel="stylesheet" type="text/css" href="/css/style.css">

<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>



</head>
<body>

	<div
		class="container-fluid vh-100 mt-5 custom-width  align-items-center">

<h2>Search For: ${name}</h2>

<table class="table">
		<thead class="thead-dark">
			<tr>
				<th>Name</th>
				<th>Page Manager</th>
				<th>Contact</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${celebrities }" var="b">

				<tr>
					<td><a href="/celebrities/${b.getId() }"> ${b.getName() } </a></td>
					<td>${b.user.userName }</td>
					<td>
					${b.user.email }
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</div>
		
</body>
</html>