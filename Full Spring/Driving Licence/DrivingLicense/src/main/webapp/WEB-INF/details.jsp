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
<title>Driver's License</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-4 p-4 border border-3 ">
		<div class="d-flex justify-content-end m-2 p-2">
			<a class="btn btn-success mx-3" href="/person/new">Create Account</a>
			<a class="btn btn-primary" href="/licenses/new">Create license</a>
		</div>
		<h1 class="mb-3">Persons Details:</h1>
		<table class="table table-border table-striped">
			<tr >
				<th>full Name</th>
				<th>License Number</th>
				<th>State</th>
				<th>Exp date</th>
			</tr>
			<c:forEach var="person" items="${persons}">
			
				<tr>
					<td><a href="/person/${person.id} "><c:out value="${person.firstName }"/> <c:out value="${person.lastName }" /></a></td>
					<td><c:out value="${person.license.licenseNumber }" /></td>
					<td><c:out value="${person.license.state }" /></td>
					<td><c:out value="${person.license.expirationDate }" /></td>
				</tr>
			
			</c:forEach>
		
		</table>

		
	</div>

</body>
</html>