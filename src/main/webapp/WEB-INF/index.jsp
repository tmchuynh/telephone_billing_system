<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Consumer List</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<h1>Consumer List</h1>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Phone Number</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${consumers}" var="consumer">
				<tr>
					<td>${consumer.id}</td>
					<td>${consumer.name}</td>
					<td>${consumer.phoneNumber}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<a href="/addConsumer">Add New Consumer</a>
</body>
</html>