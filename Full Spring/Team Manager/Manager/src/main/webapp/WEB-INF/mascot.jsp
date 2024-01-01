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
	<a href="/team">Teams</a>
	<a href="/player">Players</a>
	<a href="/coache">Coaches</a>
	<a href="/fan">Fans</a>
	<table>
		<form:form action="/mascotSave" methood="POST" modelAttribute="newMascot">
			<tr>
				<td><from:label path="name">Mascot name:</from:label></td>
				<td><form:input type="text" path="name" /></td>
			</tr>
			<tr>
				<td><from:label path="type">Mascot type:</from:label></td>
				<td><form:input type="text" path="type" /></td>
			</tr>
			<tr>
				<td><from:label path="team">Mascot team:</from:label></td>
				<td><form:select path="team">
						<c:forEach var="team" items="${teams}">
							<form:option path="team" value="${team.id}">${team.name}</form:option>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
			<td></td>
			<td><input type="submit" value="Save new Mascot" /></td>
			</tr>
		</form:form>
	</table>
	type
</body>
</html>