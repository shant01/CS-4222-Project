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
   	<title>Musician</title>
</head>
<body>
<div class="container">
        <div class="jumbotron">
          <h1>Musicians</h1>
        </div>
		<table class="table">
			<thead class="thead-light">
				<tr>
					<th scope="col">Musician SSN</th>
					<th scope="col">Name</th>
					<th scope="col">Phone</th>
					<th scope="col">Address</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${musicians}" var="it">
					<tr>
						<th scope="row">${it.ssn}</th>
						<td>${it.name}</td>
						<td>${it.phone}</td>
						<td>${it.address}</td>
						<td class="text-center">
							<a href="DeleteMusician?ssn=${it.ssn}" class="btn btn-danger btn-xs">
								<span class="glyphicon glyphicon-trash"></span>
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</div>
	<a href="Home">    Back to Home  </a>
</body>
</html>