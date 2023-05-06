<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<form method="post" action="/saveConsumer">
		<label for="firstName">First Name:</label> <input type="text" id="firstName"
			name="firstName" required><br>
			<label for="lastName">Last Name:</label> <input type="text" id="lastName"
			name="lastName" required><br>
		<br> <label for="phoneNumber">Phone Number:</label> <input
			type="text" id="phoneNumber" name="phoneNumber" required><br>
		<br> <input type="submit" value="Save Customer">
	</form>
</body>
</html>