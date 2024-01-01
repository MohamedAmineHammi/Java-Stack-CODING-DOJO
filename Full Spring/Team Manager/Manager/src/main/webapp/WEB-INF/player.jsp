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
	<a href="/coache">Coaches</a>
	<a href="/fan">Fans</a>
	<a href="/mascot">Mascots</a>
	<hr>
	<h3>New Player</h3>
	<table>
		<form:form action="/savePlayer" method="POST"
			modelAttribute="newPlayer">
			<tr>
				<td>
					<form:label path="firstName">First name:</form:label>
				</td>
				<td>
					<form:input type="text" path="firstName" />
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="lastName">Last name:</form:label>
				</td>
				<td>
					<form:input type="text" path="lastName" />
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="age">Age:</form:label>
				</td>
				<td>
					<form:input type="number" path="age" />
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="position">Position:</form:label>
				</td>
				<td>
					<form:input type="text" path="position" />
				</td>
			</tr>
			<tr>
				<td><form:label path="team">team</form:label></td>
				<td><form:select path="team">
						<c:forEach var="team" items="${teams}">
							<form:option value="${team.id}" path="team">${team.name}</form:option>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save new player" /></td>
			</tr>
		</form:form>
	</table>
	<hr>
</body>
</html>