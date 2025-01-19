<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>My Form</h2>
	<form action="submitForm" method="post">
		Name :<input type="text" name="name"/>
		Email : <input type="email" name="email" />
		Phone No : <input type="number" name="phoneno"/>
		<input type="submit" value="Submit Form"/>
	</form>
</body>
</html>