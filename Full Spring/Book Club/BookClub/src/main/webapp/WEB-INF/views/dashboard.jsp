<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<title>Read Share</title>

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

		<h1>Welcome, ${user.userName} !</h1>
		<p>
			<a href="/logout">log out</a>
		</p>
		<h3>Books from everyone's shelves:</h3>

		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Author Name</th>
					<th>Posted By</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="oneBook" items="${books}">
					<tr>
						<td><c:out value="${oneBook.id}"></c:out></td>
						<td><a href="/books/${oneBook.id}"><c:out
									value="${oneBook.title}"></c:out></a></td>
						<td><c:out value="${oneBook.author}"></c:out></td>
						<td><c:out value="${oneBook.user.userName}"></c:out></td>


					</tr>
				</c:forEach>
			</tbody>
		</table>

		<a href="/books/new" class="col-md-12 btn btn-primary btn-block">+
			ADD a to my shelf!</a>

	</div>

</body>
</html>