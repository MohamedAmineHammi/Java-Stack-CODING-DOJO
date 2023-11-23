<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Page d'accueil</title>
</head>
<body>
    <h1>Liste des fruits</h1>
    <table>
        <tr>
            <th>Nom du fruit</th>
            <th>Prix</th>
        </tr>
        <c:forEach var="fruit" items="${fruits}">
            <tr>
                <td>${fruit.name}</td>
                <td>${fruit.price}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>