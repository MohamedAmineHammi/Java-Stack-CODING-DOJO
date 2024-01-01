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
	<a href="/team">Teams</a>
	<a href="/player">Players</a>
	<a href="/coache">Coaches</a>
	<a href="/fan">Fans</a>
	<a href="/mascot">Mascots</a>
	<hr>
	<table>
		<h3>Teams:</h3>
		<c:forEach var="team" items="${teams}">
			<tr>
				<a href="/team/${team.id}">${team.name}</a><br>
			</tr>
		</c:forEach>
	</table>
	<hr>
	<table>
		<h3>Players:</h3>
		<c:forEach var="player" items="${players}">
			<tr>
				<a href="/team/${player.id}">${player.firstName}
					${player.lastName}</a><br>
			</tr>
		</c:forEach>
	</table>
	<hr>

</body>
</html>