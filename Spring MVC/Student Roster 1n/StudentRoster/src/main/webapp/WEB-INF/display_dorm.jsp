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
<title>DORMS</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<!-- Display Table of Dorms -->
	<h1>Dorms</h1>
	<hr />
	${allDaDorms }


	<a href="/dorms/new">Add A New Dorm</a>
	<br />
	<br />
	<a href="/students/new">Add A New Student</a>
	<br />
	<br />

	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th>Dorm Name</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${dorms }" var="d">

				<tr>
					<td>${d.getName()}</td>
					<td><a href="/dorms/${d.getId() }"> See Students </a></td>

				</tr>
			</c:forEach>

		</tbody>
	</table>
</body>
</html>