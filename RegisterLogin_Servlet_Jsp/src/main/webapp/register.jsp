<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="regForm" method="post">
		Name :<input type="text" name="name1" placeholder="Enter Name "/><br/>
		Email :<input type="email" name="email1" placeholder="Enter Email "/><br/>
		Password :<input type="password" name="Password1" placeholder="Enter Password "/><br/>
		Gender : <input type="radio" name="gender1" value="Male" /> Male
				<input type="radio" name="gender1" value="Female" />Female
		City :<select name="city1">
					<option>Select City</option>
					<option>Mumabi</option>
					<option>Kolkata</option>
					<option>Jaipur</option>
					<option>Pune</option>
			  </select><br/>
			  <input type="submit" value="Register"/>
	</form>
</body>
</html>