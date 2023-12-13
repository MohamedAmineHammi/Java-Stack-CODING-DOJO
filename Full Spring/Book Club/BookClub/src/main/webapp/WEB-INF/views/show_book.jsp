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

<script type="text/javascript" src="/js/clearErrors.js"></script>


</head>
<body>

	<div
		class="container-fluid vh-100 mt-5 custom-width  align-items-center">

		<h1>${book.title}</h1>
		<p>
			<a href="/home">Back To The Shelves</a>
		</p>
		<br>
		<c:set var="isUser" value="${book.user.id == user.id}" />
		<c:choose>
			<c:when test="${isUser}">
				<p>You read ${book.title } By ${book.author }.</p>
				<p>Here Are YOUR Thoughts:</p>
				<br />
				<hr />
				<p>${book.thought }</p>
				<br>
				<hr />
				<p>
					<a href="/books/${book.id}/edit">Edit</a>
				</p>
				<p>
					<a href="/delete/${book.id}">Delete</a>
				</p>
			</c:when>
			<c:when test ="${!isUser}">
				<p>${book.user.userName } read ${book.title } By ${book.author }.</p>
				<p>Here Are ${book.user.userName }'s Thoughts:</p>
				<br />
				<hr />
				<p>${book.thought }</p>
				<br>
				<hr />
			</c:when>
		</c:choose>
	</div>


</body>
</html>