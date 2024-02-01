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
<title>Create a task</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/mains.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light"
		style="background-image: url('https://raw.githubusercontent.com/MohamedAmineHammi/Java-Stack-CODING-DOJO/main/Full%20Spring/TvPrograms/NavBar.png'); height: 40vh; background-repeat: no-repeat; background-size: cover;">


	</nav>
	<section class="vh-100"
		style="background-image: url('https://raw.githubusercontent.com/MohamedAmineHammi/Java-Stack-CODING-DOJO/main/Full%20Spring/TvPrograms/Background.jpg'); height: 100vh; background-repeat: no-repeat; background-size: cover;">
	<div class="container">
		<h1>Create a New Tv show</h1>
		<form:form action="/shows/new" method="post" modelAttribute="show">

			<table>
				<thead>
					<tr>
						<td class="float-left">Title:</td>
						<td class="float-left">
							<form:errors path="title" class="text-danger" /> <br> <form:input
								class="input" path="title" /></td>
					</tr>
					<tr>
						<td class="float-left">Network:</td>
						<td class="float-left"><form:errors path="network"
								class="text-danger" /> <br> <form:input path="network"
								type="network" /></td>
					</tr>
					<tr>
						<td class="float-left">Description:</td>
						<td class="float-left"><form:errors path="description"
								class="text-danger" /> <br> <form:textarea rows="4"
								class="input" path="description" /></td>
					</tr>

					<form:errors path="owner" class="error" />
					<br>
					<form:input type="hidden" path="owner" value="${userId}"
						class="form-control" />

					<tr>
						<td><a class="btn btn-primary" href="/shows">Cancel</a></td>
						<td><input class="btn btn-success" type="submit"
							value="Submit" /></td>
					</tr>
				</thead>
			</table>
		</form:form>
	</div>
	</section>
</body>
</html>