<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<title>House Hunter - Dashboard</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

<!-- YOUR own local CSS -->
<link rel="stylesheet" type="text/css" href="/css/style.css">

<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>



</head>
<body>

	<div
		class="container-fluid vh-100 mt-5 custom-width align-items-center">

		<h1>Welcome, ${user.userName}.</h1>
		<p>
			<a href="/logout" class="btn btn-outline-secondary">Log Out</a>
		</p>

		<br />

		<table class="table">
			<thead>
				<tr>
					<th>Adress</th>
					<th>Listed On</th>
					<th>Added By</th>
					<th>Price</th>


				</tr>
			</thead>
			<tbody>
				<c:forEach var="oneListing" items="${listings}">
					<tr>
						<td><a href="/listings/${oneListing.id}"><c:out
									value="${oneListing.adress}"></c:out></a></td>


						<td><fmt:formatDate type="date"
								value="${oneListing.due_date}" /></td>



						<td><c:out value="${oneListing.user.userName}"></c:out></td>
						<td>$<c:out value="${oneListing.price}"></c:out></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>

		<a href="/listings/new"
			class="col-md-12 btn btn-outline-primary btn-block">+ New Listing</a>

	</div>

</body>
</html>