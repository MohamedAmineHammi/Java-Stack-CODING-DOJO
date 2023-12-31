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
<title>New Student</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<!-- 		Display Create Student Form -->

	<h1>New Student</h1>
	<br />

	<a href="/dorms">Dashboard</a>
	<br />
	<br />
	<form:form action="/students/new" method="post"
		modelAttribute="student">
		<div class="container">
			<form:errors style="color: red" path="*" />
		</div>
		<p>
			<form:label path="studName">Name: </form:label>
			<form:input path="studName" />
		<div>
			<form:select path="dorm">
				<c:forEach items="${all_dorms }" var="one_dorm">
					<form:option value="${one_dorm.id }">
			${one_dorm.name }
			</form:option>
				</c:forEach>
			</form:select>

		</div>
		<br />
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>