<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Books Page</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/index_style.css"/>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="d-flex justify-content-around">
		<h3>Welcome, <c:out value="${user.userName}"></c:out>!</h3>
		<a href="http:/logout">
			<button type="submit" class="btn btn-warning">Logout</button>
		</a>
	</div>
	<div class="d-flex justify-content-around">
		<h2>The Book Broker!</h2>
		<a href="/addBook">
			<button type="submit" class="btn btn-success">Add book to my shelf</button>
		</a>
	</div>
	<h4>Available books to Borrow</h4>
	<div class="container col-6 text-center d-flex flex-row align-items-center shadow-xl shadow-lg p-3 mb-5 bg-black rounded">
		<table class="table table-dark col-6 class shadow-lg p-3 mb-5 bg-black rounded">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Title</th>
					<th scope="col">Author Name</th>
					<th scope="col">Owner</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${books}" var="book">
				<tr class="align-items-center">
					<td scope="col"><c:out value="${book.id}"></c:out></td>
					<td scope="col"><a href="http:/show/${book.id}"><c:out value="${book.title}"></c:out></a></td>
					<td scope="col"><c:out value="${book.author}"></c:out></td>
					<td scope="col"><c:out value="${book.user.userName}"></c:out></td>
					<td scope="col">
					<c:choose>
					    <c:when test="${book.user.id==user.id}">
							<div class="d-flex">
								<form action="/deleteBook/${book.id}" method="post">
									<input type="hidden" name="_method" value="delete">
									<input type="submit" value="Delete" class="btn btn-danger">
								</form>
								<a href="http:/editBook/${book.id}">
									<button type="submit" class="btn btn-warning">Edit</button>
								</a>
							</div>
					    </c:when>
					    <c:when test="${book.user.id!=user.id}">
							<form:form action="/borrowBook/${book.id}" method="post">
								<input type="submit" value="Borrow" class="btn btn-primary">
							</form:form>
					    </c:when>
					</c:choose>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	<h4>Books I'm Borrowing</h4>
	<div class="container col-6 text-center d-flex flex-row align-items-center shadow-xl shadow-lg p-3 mb-5 bg-black rounded">
		<table class="table table-dark col-6 class shadow-lg p-3 mb-5 bg-black rounded">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Title</th>
					<th scope="col">Author Name</th>
					<th scope="col">Owner</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${myBooks}" var="book">
				<tr class="align-items-center">
					<td scope="col"><c:out value="${book.id}"></c:out></td>
					<td scope="col"><a href="http:/show/${book.id}"><c:out value="${book.title}"></c:out></a></td>
					<td scope="col"><c:out value="${book.author}"></c:out></td>
					<td scope="col"><c:out value="${book.user.userName}"></c:out></td>
					<td scope="col">
						<a href="http:/returnBook/${book.id}">
							<button type="submit" class="btn btn-warning">Return</button>
						</a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>