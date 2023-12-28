<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<title>View Celebrity</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

<!-- YOUR own local CSS -->
<link rel="stylesheet" type="text/css" href="/css/style.css">

<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>

	<div
		class="container-fluid vh-100 mt-5 custom-width  align-items-center">

		<h1>${celebrity.name}</h1>
		<br />
		<p>
			<a href="/home">Home</a>
		</p>
		<p></p>
		<br>

		<p>Page Manager: ${celebrity.user.userName}</p>
		<p>Contact: ${celebrity.user.email}</p>
		<p>Details: ${celebrity.details}</p>

		<br />
		<c:set var="isUser" value="${celebrity.user.id == user.id}" />
		<c:choose>
			<c:when test="${isUser}">
				<p>
					<a href="/celebrities/${celebrity.id}/edit">Edit</a>
				</p>
			</c:when>
		</c:choose>

		<hr />
		<h1>Followers of ${celebrity.name}</h1>


		<c:forEach var="follower" items="${followers}">
			<p>${follower.userName}--${follower.email}</p>


		</c:forEach>
		<p>
		<p>Number of followers: ${followers.size()}</p>
		<hr>



	</div>



</body>
</html>