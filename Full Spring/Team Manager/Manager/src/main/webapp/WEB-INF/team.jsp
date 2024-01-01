<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="/">dash</a>
	<a href="/player">Players</a>
	<a href="/coache">Coaches</a>
	<a href="/fan">Fans</a>
	<a href="/mascot">Mascots</a>
	<table>
		<form:form action="/saveTeam" method="POST" modelAttribute="newTeam">
			<tr>
				<td><form:label path="name">Team name:</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="city">Team city:</form:label></td>
				<td><form:input path="city" /></td>
			</tr>
			<tr>
			<td></td>
			<td><input type="submit" value="Save new team"/></td>
			</tr>
		</form:form>
	</table>
</body>
</html>