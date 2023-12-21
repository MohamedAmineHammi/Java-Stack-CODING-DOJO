<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login and Registration</title>
<!-- Add Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6">
            <h2>Registration</h2>
            <form:form action="/register" method="post" modelAttribute="newUser">
<div class="form-group">
		            <label>First Name:</label>
		            <form:input path="firstName" class="form-control" />
		            <form:errors path="firstName" class="text-danger" />
		        </div>
		        <div class="form-group">
		            <label>Last Name:</label>
		            <form:input path="lastName" class="form-control" />
		            <form:errors path="lastName" class="text-danger" />
		        </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <form:input path="email" id="email" class="form-control" />
                    <form:errors path="email" class="text-danger" />
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <form:password path="password" id="password" class="form-control" />
                    <form:errors path="password" class="text-danger" />
                </div>
                <div class="form-group">
                    <label for="confirm">Confirm Password:</label>
                    <form:password path="confirm" id="confirm" class="form-control" />
                    <form:errors path="confirm" class="text-danger" />
                </div>
                <button type="submit" class="btn btn-outline-danger">Register</button>
            </form:form>
        </div>
        <div class="col-md-6">
            <h2>Login</h2>
            <form:form action="/login" method="post" modelAttribute="newLogin">
                <div class="form-group">
                    <label for="loginEmail">Email:</label>
                    <form:input path="email" id="loginEmail" class="form-control" />
                    <form:errors path="email" class="text-danger" />
                </div>
                <div class="form-group">
                    <label for="loginPassword">Password:</label>
                    <form:password path="password" id="loginPassword" class="form-control" />
                    <form:errors path="password" class="text-danger" />
                </div>
                <button type="submit" class="btn btn-outline-danger">Login</button>
            </form:form>
        </div>
    </div>
</div>

