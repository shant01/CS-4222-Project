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
   	<title>Album</title>
</head>
<body>
<div class="container">
        <div class="jumbotron">
          <h1>Albums</h1>
        </div>
		<table class="table">
			<thead class="thead-light">
			<tr>
				<th>ID No</th>
				<th>Title</th>
				<th>Copyright Date</th>
				<th>Format</th>
				<th>Album ID</th>
				<th>Producer SSN</th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${albums}" var="it">
			<tr>
				<td>${it.idno}</td>
				<td>${it.title}</td>
				<td>${it.copyright_date}</td>
				<td>${it.format}</td>
				<td>${it.album_id}</td>
				<td>${it.prod_ssn}</td>
				<td class="text-center">
					<a href="DeleteAlbum?idno=${it.idno}" class="btn btn-danger btn-xs">
						<span class="glyphicon glyphicon-trash"></span>
					</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		<p>The % of albums that are CD format is ${cd_albums}%</p>
		
</div>
	<a href="Home">Back to Home</a>
	
</body>
</html>