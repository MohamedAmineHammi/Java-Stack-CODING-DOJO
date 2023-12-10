<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${dorm.name}</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<script>
	function updateDormName() {
		var dormSelect = document.getElementById("dormSelect");
		var selectedDorm = dormSelect.options[dormSelect.selectedIndex];
		var dormName = selectedDorm.getAttribute("data-dorm-name");
		document.getElementById("selectedDormName").textContent = dormName;
	}
</script>
</head>
<body>
	<div class="container">
		<h1>${dorm.name}Students:</h1>
		<hr />
		<a href="/dorms">Dashboard</a> <br /> <br />

		<form action="/dorms/${dorm.id}/addStudent" method="POST">
			<select name="studentId" id="dormSelect" onchange="updateDormName()">
				<option value="">-- Select a student --</option>
				<c:forEach items="${students}" var="student">
					<option value="${student.id}" data-dorm-name="${student.dorm.name}">${student.studName}
						(${student.dorm.name})</option>
				</c:forEach>
			</select> <input type="submit" value="Add Student">
		</form>

		<p>
			Selected Dorm: <span id="selectedDormName">${dorm.name}</span>
		</p>

		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th>Student</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${dorm.students}" var="one_student">
					<tr>
						<td>${one_student.studName}</td>
						<td>
							<form
								action="/students/delete/${one_student.id}?dormId=${dorm.id}"
								method="post">
								<input type="hidden" name="_method" value="post"> <input
									type="submit" value="Delete">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>