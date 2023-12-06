<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Burger Tracker</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>
<body>
	<div class="container">
		<!-- Display Table of Burgers -->
		<h1>Burger Tracker</h1>
		<hr />
		${allDaBurgers }

		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th>Burger Name</th>
					<th>Restaurant Name</th>
					<th>Rating</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${burgers }" var="b">

					<tr>
						<td>${b.getName() }</td>
						<td>${b.restaurant }</td>
						<td>${b.rating }</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>

		<!-- 		Display Create Burger Form -->

		<h1>Add a Burger</h1>
		<form:form action="/burgers" method="post" modelAttribute="burger">
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

			<input type="submit" value="Submit" />
		</form:form>
</body>
</html>