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
<title>Books</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
   <!-- 		Display Create Book Form -->
		
		<h1>Edit Book</h1>
		<form:form action="/books/${book.id}" method="post" modelAttribute="book">
		<input type="hidden" name="_method" value="put">
		
			<div class="container">
				<form:errors style="color: red" path="*" />
			</div>
			<p>
				<form:label path="title">Title</form:label>
				<form:input path="title" />
			</p>
			<p>
				<form:label path="author">author</form:label>
				<form:input path="author" />
			</p>
			<p>
				<form:label path="pages">Pages</form:label>
				<form:input type="number" path="pages" />
			</p>
			<input type="submit" value="Edit" />
		</form:form>
</body>
</html>