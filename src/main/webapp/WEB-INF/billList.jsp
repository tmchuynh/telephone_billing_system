<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bill List</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<h1>Bill List for ${firstName} ${lastName}</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Bill ID</th>
					<th>Bill Date</th>
					<th>Amount</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${bills}" var="bill">
					<tr>
						<td>${bill.id}</td>
						<td>${bill.billDate}</td>
						<td>$${bill.amount}</td>
						<td><a href="/bills/edit/${bill.id}" class="btn btn-primary">Edit</a>
							<a href="/telephoneRecords/${bill.id}"
							class="btn btn-secondary">View Telephone Records</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="container">
		<a href="/" class="btn btn-secondary mt-3">Back to Consumer List</a>
	</div>


	<!-- Bootstrap JS -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>