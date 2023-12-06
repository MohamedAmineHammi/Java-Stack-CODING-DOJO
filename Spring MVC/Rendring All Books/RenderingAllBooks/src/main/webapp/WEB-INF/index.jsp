<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books App</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<h1>Books</h1>

	<table class="table">
		<thead>
			<th>ID</th>
			<th>Title</th>
			<th>Number of pages</th>
			<th>Language</th>
			<th>Description</th>
		</thead>
		<tbody>
			<c:forEach items="${books }" var="one_book">
				<tr>
					<td>${one_book.id }</td>
					<td><a href="/books/${one_book.id }">${one_book.title }</a></td>
					<td>${one_book.numberOfPages }</td>
					<td>${one_book.language }</td>
					<td>${one_book.description }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>