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
    <title>Props Page</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row d-flex justify-content-between">
			<div class="col">
				<h1>Project:${proj.title}</h1>
				<p>Team Lead: ${proj.teamLeader.firstName}</p>
			</div>
		</div>
		
		<form:form action="/newtask/${proj.id}" method="post" modelAttribute="task">
		        <div class="form-group">
		            <label>Add a task ticket for this team:</label>
		            <form:textarea path="description" rows="4" cols="50" class="form-control" />
		            <form:errors path="description" class="text-danger" />
		        </div>
		        <div class="form-group">
		            <form:input type="hidden" path="user" class="form-control" value="${user_id}" />
		        </div>
		        <div class="form-group">
		            <form:input type="hidden" path="project" class="form-control" value="${proj.id}" />
		        </div>
		        <input type="submit" value="Submit" class="btn btn-success"/>
		    </form:form>
		    <button class="btn btn-outline-warning" type="submit"><a href="/dashboard">cancel</a></button>
	</div>
	<c:forEach items="${proj.tasks}" var="task">
    <p>Added by ${task.user.firstName} at ${task.createdAt} :</p>
    <p> ${task.description}</p>
    </c:forEach>
</body>
</html>

