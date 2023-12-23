<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Edit book</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/main.css"/>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="d-flex justify-content-around">
    	<h3>Change your Entry</h3>
		<a href="/books">
			<button type="submit" class="btn btn-success">Back to shelves</button>
		</a>
	</div>
    <div class="container col-4 shadow p-3 mb-5 bg-black rounded text-center">
        <form:form action="/updateBook/${book.id}" method="post" modelAttribute="book">
            <input type="hidden" name="_method" value="put">
            <div class="form-group">
                <form:errors path="title" class="text-danger"/>
                <form:input path="title" type="text" class="form-control" id="exampleFormControlInput1" placeholder="${book.title}"/>
            </div>
            <div class="form-group">
                <form:errors path="author" class="text-danger"/>
                <form:input path="author" type="text" class="form-control" id="exampleFormControlInput1" placeholder="${book.author}"/>
            </div>
            <div class="form-group">
                <form:errors path="thought" class="text-danger"/>
                <form:input path="thought" type="text" class="form-control" id="exampleFormControlInput1" placeholder="${book.thought}"/>
            </div>
                <input type="submit" value="Update" class="btn btn-success"/>
        </form:form>
    </div>
	<form action="/deleteBook/${book.id}" method="post">
		<input type="hidden" name="_method" value="delete">
		<input type="submit" value="Delete" class="btn btn-danger">
	</form>
</body>
</html>