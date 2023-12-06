<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Save Travels</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>
<body>
	<div class="container">
		<!-- Display Table of Travels -->
		<h1>Save Travels</h1>
		<hr />
		${allDaTravels }

		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th>Expense</th>
					<th>Vendor</th>
					<th>Amount</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${travels }" var="b">

					<tr>
						<td><a href="/travels/${b.getId() }"> ${b.getExpense() }
						</a></td>
						<td>${b.vendor }</td>
						<td>$ ${b.amount }</td>
						<td><a href="/edit/${b.id }">edit</a> |

							<form action="/travels/${b.id}" method="post">
								<input type="hidden" name="_method" value="delete"> <input
									type="submit" value="Delete">
							</form></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>

		<!-- 		Display Create Travel Form -->

		<h1>Add An Expense:</h1>
		<form:form action="/travels" method="post" modelAttribute="travel">
			<div class="container">
				<form:errors style="color: red" path="*" />
			</div>
			<p>
				<form:label path="expense">Expense Name: </form:label>
				<form:input path="expense" />
			</p>
			<p>
				<form:label path="vendor">Vendor: </form:label>
				<form:input path="vendor" />
			</p>
			<p>
				<form:label path="amount">Amount: </form:label>
				<form:input type="number" path="amount" />
			</p>
			<p>
				<form:label path="description">Description: </form:label>
				<form:input path="description" />
			</p>
			<input type="submit" value="Submit" />
		</form:form>
		
</body>
</html>