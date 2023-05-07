<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Customer</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<h1>Add Consumer</h1>
	<form class="form" method="post" action="/consumers/save">
		<div class="mb-3">
			<label for="firstName" class="form-label">First Name:</label> <input
				type="text" id="firstName" name="firstName" class="form-control"
				required>
		</div>
		<div class="mb-3">
			<label for="lastName" class="form-label">Last Name:</label> <input
				type="text" id="lastName" name="lastName" class="form-control"
				required>
		</div>
		<div class="mb-3">
			<label for="phoneNumber" class="form-label">Phone Number:</label> <input
				type="text" id="phoneNumber" name="phoneNumber" class="form-control"
				required>
		</div>
		<button type="submit" class="btn btn-primary">Save Customer</button>
		<a href="/" class="btn btn-secondary">Cancel</a>
	</form>
</body>
</html>