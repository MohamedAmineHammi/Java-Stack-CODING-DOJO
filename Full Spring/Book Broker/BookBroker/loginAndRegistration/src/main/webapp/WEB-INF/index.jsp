<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Home Page</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/main.css"/>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<h1>Welcome!</h1>
		<p>Join our growing community.</p>
	</div>
	<div class="d-flex">
	    <div class="container col-4 shadow p-3 mb-5 bg-black rounded text-center border border-secondary">
	    	<h3>Register</h3>
	        <form:form action="/register" method="post" modelAttribute="newUser">
	            <div class="form-group">
	                <form:label path="userName">User Name</form:label>
	                <form:errors path="userName" class="text-danger"/>
	                <form:input path="userName" type="text" class="form-control" id="exampleFormControlInput1" placeholder="ahmad22"/>
	            </div>
	            <div class="form-group">
	                <form:label path="email">Email</form:label>
	                <form:errors path="email" class="text-danger"/>
	                <form:input path="email" type="email" class="form-control" id="exampleFormControlInput1" placeholder="@gmail.com"/>
	            </div>
	            <div class="form-group">
	                <form:label path="password">Password</form:label>
	                <form:errors path="password" class="text-danger"/>
	                <form:input path="password" type="password" class="form-control" id="exampleFormControlInput1" placeholder="Password word must be at least 8 characters"/>
	            </div>
	            <div class="form-group">
	                <form:label path="confirm">Confirm Password</form:label>
	                <form:errors path="confirm" class="text-danger"/>
	                <form:input path="confirm" type="password" class="form-control" id="exampleFormControlInput1" placeholder="repeat same password"/>
	            </div>
                <input type="submit" value="Register" class="btn btn-success"/>
	        </form:form>
	    </div>
	    <div class="container col-4 shadow p-3 mb-5 bg-black rounded text-center border border-secondary">
	    	<h3>Login</h3>
	        <form:form action="/login" method="post" modelAttribute="newLogin">
	            <div class="form-group">
	                <form:label path="email">Email</form:label>
	                <form:errors path="email" class="text-danger"/>
	                <form:input path="email" type="email" class="form-control" id="exampleFormControlInput1" placeholder="@gmail.com"/>
	            </div>
	            <div class="form-group">
	                <form:label path="password">Password</form:label>
	                <form:errors path="password" class="text-danger"/>
	                <form:input path="password" type="password" class="form-control" id="exampleFormControlInput1" placeholder="Enter your password"/>
	            </div>
                <input type="submit" value="Login" class="btn btn-success"/>
	        </form:form>
	    </div>
	</div>
</body>
</html>