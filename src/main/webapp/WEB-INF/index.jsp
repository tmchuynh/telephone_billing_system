<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Consumer List</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<h1>Consumer List</h1>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th># of Phones</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${consumers}" var="consumer">
					<tr>
						<td>${consumer.id}</td>
						<td>${consumer.firstName}</td>
						<td>${consumer.lastName}</td>
						<td>${consumer.numberOfTelephones }</td>
						<td><a href="/bills/${consumer.id}" class="btn btn-primary">View
								Bills</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="container">
		<a href="/consumers/add" class="btn btn-secondary">Add New
			Consumer</a>
	</div>

</body>

</html>