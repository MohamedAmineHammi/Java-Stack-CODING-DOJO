<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<title>Create New Team</title>
	
	<!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	
	<!-- YOUR own local CSS -->
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	
	<!-- For any Bootstrap that uses JS -->
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	
	<script type="text/javascript" src="/js/clearErrors.js"></script>
	
	
</head>
<body>


<section class="vh-100"
		style="background-image: url('https://hd.wallpaperswide.com/thumbs/uefa_champions_league_2-t2.jpg'); height: 100vh; background-repeat: no-repeat; background-size: cover;">

	
	<div class="container-fluid vh-100 custom-width align-items-center">
		
		<h1>New Team</h1>
		<br>
		<p><a href="/home" class="btn btn-dark">dashboard</a></p>
	
	<br>
	<form:form action="/new/team" method="POST" modelAttribute="team">
		<input type="hidden" name="user" value="${user.id}">
	
		<form:errors id="teamNameErrors" path="name" class="text-danger"/>
		<div class="form-group d-flex align-items-center">
			<form:label class="col-md-3" path="name">Team Name </form:label>
			<form:input type="text" class="form-control" id="teamName" path="name"/>
		</div>
		<br>
		<form:errors id="skillErrors" path="skill_level" class="text-danger"/>
		<div class="form-group d-flex align-items-center">
			<form:label class="col-md-3" path="skill_level">Skill Level (1-5)</form:label>
			<form:input type="number" class="form-control" id="skill" path="skill_level" min="1" max="5"/>
		</div>
		<br>
		<form:errors id="gamedayErrors" path="game_day" class="text-danger"/>
		<div class="form-group d-flex align-items-center">
			<form:label class="col-md-3" path="game_day">Game Day </form:label>
			<form:select path="game_day">
				<form:option value="Sunday">Sunday</form:option>
				<form:option value="Monday">Monday</form:option>
				<form:option value="Tuesday">Tuesday</form:option>
				<form:option value="Wednesday">Wednesday</form:option>
				<form:option value="Thursday">Thursday</form:option>
				<form:option value="Friday">Friday</form:option>
				<form:option value="Saturday">Saturday</form:option>
			
			</form:select>
		</div>
		<br>

  		<button type="submit" class="col-md-12 btn btn-primary btn-block">Submit</button>
  		
  	
  
  	</form:form>
  	
</div>
    
    
</body>
</html>