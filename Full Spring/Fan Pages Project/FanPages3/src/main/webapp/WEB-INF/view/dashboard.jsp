<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<title>Fan Pages</title>

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

		<h1>Welcome, ${user.userName} !</h1>
		<p>
			<a href="/logout">log out</a>
		</p>

		<a href="/celebrities/new" class="col-md-12 btn btn-primary btn-block">Add
			Celebrity Page</a> <br /> <br />
		<form action="/celebrities/search" method="get">
			<input type="text" name="name" placeholder="Search">
			<button type="submit">Search</button>
		</form>
		<hr />

		<div>
			<c:forEach var="oneCelebrity" items="${allCelebrities}">

				<p>
					<a href="/celebrities/${oneCelebrity.id}"><c:out
							value="${oneCelebrity.name}"></c:out></a>
				</p>
				<p>
					Page Manager:
					<c:out value="${oneCelebrity.user.userName}"></c:out>
				</p>
						
				
				<p>Number of followers: ${oneCelebrity.followers.size()}</p>
				
				
				<c:if test="${oneCelebrity.followers.contains(thisUser) eq false}">
					<a href="/addtofav/${oneCelebrity.id }">Add to list</a>
				</c:if>
				<c:if test="${oneCelebrity.followers.contains(thisUser)}">
					<a href="/removefromfav/${oneCelebrity.id }">Remove from list</a>
				</c:if>


				<hr />
			</c:forEach>
		</div>
	</div>

</body>
</html>