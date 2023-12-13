<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<title>Book Share</title>
	
	<!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	
	<!-- YOUR own local CSS -->
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	
	<!-- For any Bootstrap that uses JS -->
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	
	<script type="text/javascript" src="/js/clearErrors.js"></script>
	
	
</head>
<body>


<div class="container custom-width mt-2 p-3 border border-secondary">

		
		<h1>Add a Book To Your Shelf!</h1>
		<p><a href="/home">Back To The Shelves</a></p>
	
	<br>
	<form:form action="/new/book" method="POST" modelAttribute="book">
		<input type="hidden" name="user" value="${user.id}">
	
		<form:errors id="bookTitleErrors" path="title" class="text-danger"/>
		<div class="form-group d-flex align-items-center">
			<form:label class="col-md-3" path="title">Title </form:label>
			<form:input type="text" class="form-control" id="bookTitle" path="title"/>
		</div>
		<br>
		<form:errors id="bookAuthorErrors" path="author" class="text-danger"/>
		<div class="form-group d-flex align-items-center">
			<form:label class="col-md-3" path="author">Author </form:label>
			<form:input type="textarea" class="form-control" id="bookAuthor" path="author"/>
		</div>
		<br>
				<form:errors id="bookThoughtErrors" path="thought" class="text-danger"/>
		<div class="form-group d-flex align-items-center">
			<form:label class="col-md-3" path="thought">Thought </form:label>
			<form:input type="textarea" class="form-control" id="bookThought" path="thought"/>
		</div>
		<br>
		

  		<button type="submit" class="col-md-12 btn btn-primary btn-block">Submit</button>
  		
  	
  
  	</form:form>
  	
</div>
    
    
</body>
</html>