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
	<div class="container mt-4 p-4 border border-3">
		<div class="d-flex justify-content-end">
			<a href="/allPersons" class="btn btn-success ">Details</a>
			<a href="/" class="btn btn-warning mx-3">Home</a>
		</div>

		<h1 class="mb-4">New License</h1>
		<div>
			<form:form action="/create/license" methods="post" modelAttribute="license">

				<form:select path="person">
					<c:forEach var="onePerson" items="${allPersons}">
					<c:if test="${onePerson.getLicense() == null}">
						<form:option value="${onePerson.id }">
							<c:out value="${onePerson.firstName}" />
							<c:out value="${onePerson.lastName}" />
					    </form:option>
					  </c:if>
					</c:forEach>	
				</form:select>
				
				<p><form:errors path="state" class="text-danger mx-2"></form:errors></p>
				<form:label path="state">State :</form:label>
				<form:input path="state" placeholder="enter your state" class="form-control mb-2"/>
			
				
				<p><form:errors path="licenseNumber" class="text-danger mx-2"></form:errors></p>
				<form:label path="licenseNumber" type="number">license number :</form:label>
				<form:input path="licenseNumber" placeholder="enter your state" class="form-control mb-2"/>
			
				<p><form:errors path="expirationDate" class="text-danger mx-2"></form:errors></p>
				<form:label path="expirationDate" >Expiration date :</form:label>
				<form:input path="expirationDate" type="date" class="form-control mb-4"/>
			
				<input type="submit" value="Submit" class="btn btn-primary btn-lg"/>
			</form:form>
		</div>

	</div>

</body>
</html>