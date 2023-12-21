<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New Project</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row d-flex justify-content-between">
			<div class="col">
				<h1>Edit Project </h1>
			</div>
		</div>
		
		<form:form action="/handle/${project.id}" method="put" modelAttribute="project">
		        <div class="form-group">
		            <label>Title:</label>
		            <form:input path="title" class="form-control" />
		            <form:errors path="title" class="text-danger" />
		        </div>
		        <div class="form-group">
		            <label>Description:</label>
		            <form:textarea path="description" rows="4" cols="50" class="form-control" />
		            <form:errors path="description" class="text-danger" />
		        </div>
		        <div class="form-group">
		            <label>Due Date:</label>
		            <form:input type="date" path="dueDate" class="form-control" />
		            <form:errors path="dueDate" class="text-danger" />
		        </div>
		        <div class="form-group">
		            <form:input type="hidden" path="teamLeader"  value="${user_id}"  class="form-control" />
		        </div>
		        <input type="submit" value="Submit" class="btn btn-success"/>
		    </form:form>
		    <button class="btn btn-outline-warning" type="submit"><a href="/dashboard">cancel</a></button>
	</div>
</body>
</html>

