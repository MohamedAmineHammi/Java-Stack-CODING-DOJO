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
    <title>Project Manager Dashboard</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container-fluid">
		<div class="row d-flex justify-content-between">
			<div class="col">
				<h1>Welcome, ${thisUser.firstName} ! </h1>
				
			</div>
			<div class="col">
				<p><a href="/logout">Logout</a></p>
				<p><a href="/projects/new">New Project</a></p>
			</div>
		</div>
		<p>All Projects</p>
		<table class="table">
  <thead>
    <tr>
      <th scope="col">Project</th>
      <th scope="col">Team Lead</th>
      <th scope="col">Due Date</th>
      <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${notActiveProjects}" var="proj">
    <tr>
      <td><a href="/projects/${proj.id}">${proj.title}</a></td>
      <td>${proj.teamLeader.firstName}</td>
      <td>${proj.dueDate}</td>
      <td><a href="/join/${proj.id}">Join team</a> 
    </tr>
    </c:forEach>
  </tbody>
</table>
<p>Your Projects</p>
<table class="table">
  <thead>
    <tr>
      <th scope="col">Project</th>
      <th scope="col">Team Lead</th>
      <th scope="col">Due Date</th>
      <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${thisUser.leaderProjects}" var="proj">
    <tr>
      <td><a href="/projects/${proj.id}">${proj.title}</a></td>
      <td>${proj.teamLeader.firstName}</td>
      <td>${proj.dueDate}</td>
	  <td><a href="/edit/${proj.id}">edit</a></td>
    </tr>
    </c:forEach>
    <c:forEach items="${thisUser.memberProjects}" var="proj">
    <tr>
      <td><a href="/projects/${proj.id}">${proj.title}</a></td>
      <td>${proj.teamLeader.firstName}</td>
      <td>${proj.dueDate}</td>
	  <td><a href="/leave/${proj.id}">leave team</a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
	</div>
</body>
</html>











	