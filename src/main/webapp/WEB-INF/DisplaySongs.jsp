<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   	<title>Song</title>
</head>
<body>
<div class="container">
        <div class="jumbotron">
          <h1>Songs</h1>
        </div>
		<table class="table">
			<thead class="thead-light">
			<tr>
				<th>Song Title</th>
				<th>Author</th>
				<th>Musician SSN </th>
				<th>Album ID</th>
				<th></th>
			</tr>
			<c:forEach items="${songs}" var="it">
			<tr>
				<td>${it.title}</td>
				<td>${it.author}</td>
				<td>${it.mus_ssn}</td>
				<c:choose>
					<c:when test="${it.album_id == 0}">
						<td>No Album</td>
					</c:when>
					<c:otherwise>
						<td>${it.album_id}</td>
					</c:otherwise>
	
				</c:choose>
				<td class="text-center">
					<a href="DeleteSong?title=${it.title}" class="btn btn-danger btn-xs">
						<span class="glyphicon glyphicon-trash"></span>
					</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		<p>The total # of songs that are in an album is ${totalsongs}</p>
		
</div>
	<a href="Home">Back to Home</a>
</body>
</html>