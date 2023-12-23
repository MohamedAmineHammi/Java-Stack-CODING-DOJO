<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Add Book</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/main.css"/>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="d-flex justify-content-around">
		<h1>Add book to your shelf</h1>
		<a href="/books">
			<button type="submit" class="btn btn-success">Back to shelves</button>
		</a>
	</div>
    <div class="container col-4 shadow p-3 mb-5 bg-black rounded text-center border border-secondary">
        <form:form action="/newBook" method="post" modelAttribute="book">
		<form:input type="hidden" path="user" value="${user.id}"/>
            <div class="form-group">
                <form:label path="title">Title</form:label>
                <form:errors path="title" class="text-danger"/>
                <form:input path="title" type="text" class="form-control" id="exampleFormControlInput1" placeholder="example: Harry Potter"/>
            </div>
            <div class="form-group">
                <form:label path="author">Author</form:label>
                <form:errors path="author" class="text-danger"/>
                <form:input path="author" type="text" class="form-control" id="exampleFormControlInput1" placeholder="example: William Sheks Ibn Beer"/>
            </div>
            <div class="form-group">
                <form:label path="thought">My Thoughts</form:label>
                <form:errors path="thought" class="text-danger"/>
                <form:textarea path="thought" class="form-control" id="exampleFormControlInput1" cols="30" rows="10" placeholder="example: this book is stolen"></form:textarea>
            </div>
                <input type="submit" value="Add" class="btn btn-success"/>
        </form:form>
    </div>
</body>
</html>