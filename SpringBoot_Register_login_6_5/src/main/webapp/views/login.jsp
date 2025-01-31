<!DOCTYPE html>
<html>
<head>
<title>login page</title>
</head>

<body>
	<h2>Login Page</h2>
	
	<c:if test="${not empty errorMsg}">
			<h3 style="color:red">${errorMsg}</h3>
	</c:if>
	
	<form action="loginForm" method="post">
			
			Email :<input type="email" name="email"/> <br/><br/>
			Password :<input type="password" name="password"/> <br/><br/>
			
			<input type="submit" value="Login"/>
	<form>
</body>

</html>