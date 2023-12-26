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
<title>Products Page</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<h1>${product.name}</h1>
	<p><a href="/" >Home</a></p>
	
	<p>Categories:</p>
<ul class="list-group">
	<c:forEach items="${existingcategories}" var="categ">
  <li class="list-group-item">${categ.name}</li>
  </c:forEach>
</ul>
	
	<form action="//products/new/${cat.id}" method="post" >
	<p><input type="hidden" name="prodid" value="${product.id}"/></p>
    <p>
        <label >Add Category: </label>
        <select name="catid">
            <c:forEach items="${missingcategories}" var="cat">
                <option value="${cat.id}">${cat.name}</option>
            </c:forEach>
        </select>
    </p>
    <input type="submit" value="Submit"/>
</form> 

</body>
</html>