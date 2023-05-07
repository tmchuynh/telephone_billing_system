<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Telephone Record List</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<h1>Telephone Record List</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Record ID</th>
					<th>Phone Number</th>
					<th>Call Duration</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${telephoneRecords}" var="telephoneRecord">
					<tr>
						<td>${telephoneRecord.id}</td>
						<td>${telephoneRecord.phoneNumber}</td>
						<td>${telephoneRecord.callDuration}</td>
						<td><a href="/telephoneRecords/${record.id}/edit"
							class="btn btn-primary">Edit</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="container">
		<c:if test="${telephoneRecord.id eq null}">
			<h2>Add New Telephone Record</h2>
		</c:if>
		<c:if test="${telephoneRecord.id ne null}">
			<h2>Edit Telephone Record</h2>
		</c:if>
		<form:form action="/telephoneRecords/add" method="post"
			modelAttribute="telephoneRecord">
			<input type="hidden" name="billId" value="${billId}" />
			<input type="hidden" name="id" value="${telephoneRecord.id}" />
			<div class="form-group">
				<label for="callDate">Call Date:</label>
				<form:input type="date" path="callDate" class="form-control"
					id="callDate" required="required" />
			</div>
			<div class="form-group">
				<label for="duration">Duration (in minutes):</label>
				<form:input type="number" path="duration" class="form-control"
					id="duration" required="required" />
			</div>
			<button type="submit" class="btn btn-primary">Save</button>
		</form:form>
	</div>

	<div class="container">
		<a href="/bills/${billId}" class="btn btn-secondary mt-3">Back to
			Bill</a>
	</div>
</body>
</html>