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
		<c:if test="${bill.id eq null}">
			<h2>Add New Bill</h2>
		</c:if>
		<c:if test="${bill.id ne null}">
			<h2>Edit Bill</h2>
		</c:if>
		<form:form action="${billsFormAction}" method="post"
			modelAttribute="bill">
			<input type="hidden" name="consumerId" value="${consumerId}" />
			<div class="form-group">
				<label for="billDate">Bill Date:</label>
				<form:input type="date" path="billDate" class="form-control"
					id="billDate" required="required" />
			</div>
			<div class="form-group">
				<label for="amount">Amount:</label>
				<form:input type="number" path="amount" class="form-control"
					id="amount" required="required" />
			</div>
			<c:choose>
				<c:when test="${bill.id ne null}">
					<button type="submit" class="btn btn-primary">Update Bill</button>
					<a href="/bills/${bill.id}" class="btn btn-secondary">Cancel</a>
				</c:when>
				<c:otherwise>
					<button type="submit" class="btn btn-primary">Save Bill</button>
				</c:otherwise>
			</c:choose>
		</form:form>

		<a href="/" class="btn btn-secondary mt-3">Back to Consumer List</a>
	</div>


	<!-- Bootstrap JS -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>