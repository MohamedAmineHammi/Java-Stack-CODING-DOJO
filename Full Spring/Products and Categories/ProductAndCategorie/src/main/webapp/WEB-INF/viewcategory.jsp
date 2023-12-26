<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category Page</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<h1>${category.name}</h1>
	<p><a href="/" >Home</a></p>
	
	<p>Products:</p>
<ul class="list-group">
	<c:forEach items="${existingproducts}" var="prod">
  <li class="list-group-item">${prod.name}</li>
  </c:forEach>
</ul>
	
	<form action="//category/new/${pro.id}" method="post" >
	<p><input type="hidden" name="catid" value="${category.id}"/></p>
    <p>
        <label >Add Product: </label>
        <select name="prodid">
            <c:forEach items="${missingproducts}" var="pro">
                <option value="${pro.id}">${pro.name}</option>
            </c:forEach>
        </select>
    </p>
    <input type="submit" value="Submit"/>
</form> 

</body>
</html>