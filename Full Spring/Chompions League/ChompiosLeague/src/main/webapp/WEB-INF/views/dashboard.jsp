<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<title>Chompions League Dashboard</title>
	
	<!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	
	<!-- YOUR own local CSS -->
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	
	<!-- For any Bootstrap that uses JS -->
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	
	 		
	
</head>
<body>

<section class="vh-100"
		style="background-image: url('https://hd.wallpaperswide.com/thumbs/uefa_champions_league_2-t2.jpg'); height: 100vh; background-repeat: no-repeat; background-size: cover;">

	
	<div class="container-fluid vh-100 custom-width align-items-center">
		
		<h1>Welcome, ${user.userName} !</h1>	
		<br>			
		<p><a href="/logout" class="btn btn-dark">log out</a></p>
				
		<table class="table">
	    <thead>
	        <tr>
	            <th>Team Name</th>
	            <th>Skill Level (1-5)</th>
	            <th>Players</th>
	            <th>Game Day</th>
	        </tr>
	    </thead>
	    <tbody>
	    	<c:forEach var="oneTeam" items="${teams}">
	    		<tr>
	    			<td><a href="/teams/${oneTeam.id}"><c:out value="${oneTeam.name}"></c:out></a></td>
	    			<td><c:out value="${oneTeam.skill_level}"></c:out></td>
	    			<td><c:out value="${oneTeam.playersCount}"></c:out>/9</td>
	    			<td><c:out value="${oneTeam.game_day}"></c:out></td>
	    		</tr>
	    	</c:forEach>
	    </tbody>
	    </table>
	    
	    <a href="/teams/new" class="col-md-12 btn btn-primary btn-block">Create New Team</a>
	    
    </div>
    
</body>
</html>