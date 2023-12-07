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
<title>Lookify</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<a href="/songs/new">Add New</a>
	<a href="/songs/top-ten">Top Songs</a>
	<form action="/songs/search" method="get">
    <input type="text" name="artist" placeholder="Search">
    <button type="submit">Search</button>
</form>
	<div class="container">
		<!-- Display Table of Songs -->

		${allDaSongs }

		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th>Name</th>
					<th>Rating</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${songs }" var="b">

					<tr>
						<td><a href="/songs/${b.getId() }"> ${b.getTitle() } </a></td>
						<td>${b.rating }</td>
						<td>
							<form action="/songs/${b.id}" method="post">
								<input type="hidden" name="_method" value="delete"> <input
									type="submit" value="Delete">
							</form>
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
</body>
</html>