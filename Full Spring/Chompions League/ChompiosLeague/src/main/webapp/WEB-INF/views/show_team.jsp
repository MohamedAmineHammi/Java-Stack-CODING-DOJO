<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<title>Team Details</title>
	
	<!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	
	<!-- YOUR own local CSS -->
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	
	<!-- For any Bootstrap that uses JS -->
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	
	<script type="text/javascript" src="/js/clearErrors.js"></script>
	
	
</head>
<body>
	
<section class="vh-100"
		style="background-image: url('https://hd.wallpaperswide.com/thumbs/uefa_champions_league_2-t2.jpg'); height: 100vh; background-repeat: no-repeat; background-size: cover;">

	
	<div class="container-fluid vh-100 custom-width align-items-center">		
		<h1>${team.name}</h1>
		<br>
		<p><a href="/home" class="btn btn-dark">dashboard</a></p>
        <br>
        
        <p>Team Name: ${team.name}</p>
        <p>Skill Level: ${team.skill_level}</p>
        <p>Game Day: ${team.game_day}</p>
        
        <c:set var="playersExist" value="${team.playersCount > 0 }" />    
        
        <c:choose>
			<c:when test="${playersExist}">
				<p>Players :</p>
				<c:forEach var="onePlayer" items="${players}">
			
					<ul> - <c:out value="${onePlayer.name}"></c:out></ul>

				</c:forEach>
			</c:when>
		</c:choose>
        
		<c:set var="isUser" value="${team.user.id == user.id}" />
	    <c:set var="teamIsFull" value="${team.playersCount == 9 }" />
	     
		<c:choose>
	    	<c:when test="${isUser}">
	        	<hr class="my-4"> <!-- Move the <hr> outside of the choose block -->
	        	<c:choose>
	            	<c:when test="${teamIsFull}">
	                	<p class="text-large text-danger">The team is full !</p>
	                </c:when>
	            <c:otherwise>
	                <p>Add Player:</p>
	                <form:form action="/new/player" method="POST" modelAttribute="player">
	           
	                	<input type="hidden" name="teamId" value="${team.id}">
	                    
	                    <form:errors id="playerNameErrors" path="name" class="text-danger"/>
	                    <div class="form-group d-flex align-items-center">
	                        <form:label class="col-md-3" path="name">Player Name </form:label>
	                        <form:input type="text" class="form-control" id="playerName" path="name"/>
	                    </div>
	                    <br>
	                    <button type="submit" class="col-md-12 btn btn-primary btn-block">Add</button>
	                </form:form>
	            </c:otherwise>
	            </c:choose>
	        <br>
	        <p><a href="/teams/${team.id}/edit" class="btn btn-dark">edit</a></p>
	        <p><a href="/delete/${team.id}" class="btn btn-dark">delete</a></p>
	        </c:when>
	    </c:choose>

    </div>
    
    
</body>
</html>