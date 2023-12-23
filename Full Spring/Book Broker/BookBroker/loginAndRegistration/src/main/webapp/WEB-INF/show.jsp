<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Show Page</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/index_style.css"/>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="d-flex justify-content-around">
		<h1><c:out value="${book.title}"></c:out></h1>
		<a href="/books">
			<button type="submit" class="btn btn-success">Back to shelves</button>
		</a>
	</div>
	<h5><span class="text-danger"><c:out value="${book.user.userName}"></c:out></span>
		 read <span class="text-success"><c:out value="${book.title}"></c:out></span>
		by <span class="text-primary"><c:out value="${book.author}"></c:out></span>.
	</h5>
	<h5>Thoughts on this book:</h5>
	<p><c:out value="${book.thought}"></c:out></p>
	<c:choose>
    <c:when test="${user.id == book.user.id}">
		<div class="d-flex">
			<form action="/deleteBook/${book.id}" method="post">
				<input type="hidden" name="_method" value="delete">
				<input type="submit" value="Delete" class="btn btn-danger">
			</form>
			<a href="http:/editBook/${book.id}">
				<button type="submit" class="btn btn-warning">Edit</button>
			</a>
		</div>
    </c:when>    
	</c:choose>
</body>
</html>