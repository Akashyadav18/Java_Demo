<!DOCTYPE html>
<html>
<head>
<title>Register Page</title>
</head>

<body>
	<h2>Register Page</h2>
	
	<c:if test="${not empty SuccessMsg}">
		<h3 style="color:green">${SuccessMsg}</h3>
	</c:if>
	
	<c:if test="${not empty errorMsg}">
		<h3 style="color:red">${errorMsg}</h3>
	</c:if>
	
	<form action="regForm" method="post">
		Name :<input type="text" name="name"/> <br/><br/>
		Email :<input type="email" name="email"/> <br/><br/>
		Password :<input type="password" name="password"/> <br/><br/>
		Phone No :<input type="text" name="phoneno"/> <br/><br/>
		<input type="submit" value="Register"/>
	<form>
</body>

</html>