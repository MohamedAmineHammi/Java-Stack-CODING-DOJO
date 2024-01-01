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
	<a href="/mascot">Mascots</a>
	<hr>
	<!-- 	<table> -->
	<%-- 		<form> --%>
	<!-- 			<tr> -->
	<!-- 				<td><label>Fan name:</label></td> -->
	<!-- 				<td><input type="text" name="fanName" /></td> -->
	<!-- 			</tr> -->
	<!-- 			<tr> -->
	<!-- 				<td><label>Fan team:</label></td> -->
	<!-- 				<td><select> -->
	<%-- 						<c:forEach var="team" items="${teams}"> --%>
	<%-- 							<option name="fanTeam" value="${team.id}">${team.name}</option> --%>
	<%-- 						</c:forEach> --%>
	<!-- 				</select></td> -->
	<!-- 			</tr> -->
	<%-- 		</form> --%>
	<!-- 	</table> -->
	<hr>
	<table>
		<form:form action="/fanSave" method="POST" modelAttribute="newFan">
			<tr>
				<td><form:label path="name">Fan name:</form:label></td>
				<td><form:input type="text" path="name" /></td>
			</tr>
			<!-- 			<tr> -->
			<%-- 				<td><form:label path="team">Fan teams:</form:label></td> --%>
			<%-- 				<td><form:select path="team"> --%>
			<%-- 						<c:forEach var="team" items="${teams}"> --%>
			<%-- 							<form:option path="team" value="${team}">${team.name}</form:option> --%>
			<%-- 						</c:forEach> --%>
			<%-- 					</form:select></td> --%>
			<!-- 			</tr> -->
			<tr>
				<td><label>Fan team:</label></td>
				<td><select name="fanTeam">
						<c:forEach var="team" items="${teams}">
							<option  value="${team.id}">${team.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save new Fan" /></td>
			</tr>
		</form:form>
	</table>
	<hr>

</body>
</html>