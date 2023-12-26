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
<title>Home</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<h1>Home Page</h1>
	<p><a href="/products/new" >New Product</a></p>
	<p><a href="/categories/new" >New Category</a></p>
	<table>
<p>Products</p>
	<ul class="list-group">
	<c:forEach items="${allproducts}" var="pd">
  <li class="list-group-item"><a href="/products/${pd.id}">${pd.name }</a></li>
  </c:forEach>
</ul>
<p>Categories</p>
<ul class="list-group">
	<c:forEach items="${allcategories}" var="ct">
  <li class="list-group-item"><a href="/categories/${ct.id}">${ct.name }</a></li>
  </c:forEach>
</ul>
	</table>
</body>
</html>
