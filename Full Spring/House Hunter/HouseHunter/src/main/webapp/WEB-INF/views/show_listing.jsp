<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<title>Listing Details</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

<!-- YOUR own local CSS -->
<link rel="stylesheet" type="text/css" href="/css/style.css">

<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript" src="/js/clearErrors.js"></script>


</head>
<body>

	<div
		class="container-fluid vh-100 mt-5 custom-width  align-items-center">

		<h1>${listing.adress}</h1>
		<p>
			<a href="/home" class="btn btn-secondary">Dashboard</a>
		</p>
		<br>

		<p>Day: ${listing.adress}</p>

		<p>
			Listing Date:
			<fmt:formatDate value="${listing.due_date}" pattern="MM/dd/yyyy" />
		</p>


		<p>Price: $${listing.price}</p>

		<br>

		<c:set var="notesExist" value="${listing.notesCount > 0 }" />
		<c:choose>
			<c:when test="${notesExist}">
				<h3 style="color: #CC00CC;">Notes :</h3>
				<c:forEach var="oneNote" items="${notes}">
				
				
					<ul style="color: #CC00CC;"> Added By: ${oneNote.lead.userName} </ul>

					<ul style="color: #CC00CC;"> - ${oneNote.title} </ul>

				</c:forEach>
			</c:when>
		</c:choose>



				<hr class="my-4">

				<h5 style="color: #CC00CC;">Add Notes To Listing :</h5>
				<br>
				<form:form action="/new/note" method="POST" modelAttribute="note">

					<input type="hidden" name="listingId" value="${listing.id}">

					<form:errors id="noteTitleErrors" path="title"
						class="text-danger" />
					<div class="form-group d-flex align-items-center">
						<form:label class="col-md-3" path="title"
							style="color: #CC00CC;">Notes </form:label>
						<form:input type="text" class="form-control" id="title"
							path="title" />
					</div>

					<br>
					<button type="submit"
						class="col-md-12 btn btn-outline-danger btn-block">Add
						Note</button>
				</form:form>
	<br>
	
	<c:set var="isUser"
								value="${listing.user.id == user.id}" /> <c:choose>
								<c:when test="${isUser}">
											<p class="mt-5">
										<a href="/listings/edit/${listing.id}"
											class="btn btn-danger">Edit</a>
									</p>
											<p class="mt-5">
			<a href="/delete/${listing.id}" class="btn btn-danger">Delete</a>
		</p>
								</c:when>
							</c:choose>
	</div>


</body>
</html>