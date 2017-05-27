<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Form</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style>
body {
	background-image: url("img/login.jpeg");
	background-repeat: no-repeat;
	background-size: cover;
}
#ex1{
background-color:#8b8f96;
height:	200px;
width:  250px;
div-align: center;
 margin-top:100px;
}
h1{
font-style: italic ;
line-height: 18px;
text-align: center;
}
</style>
</head>
<body>
<center><div  id="ex2" class="container">
	<h1 >Welcome to User Login Page...</h1>
	<div id="ex1" class="container">
		<form action="f1" method="post">
		Email 		:<input type="text" name="userMail"><br> 
		Password 	:<input type="password" name="userPass"><br>
		<input type="submit" value="submit" class="btn btn-info">
		</form>
		<button type="button" class="btn btn-default">
			<a href="">click here to registration</a>
		</button>
	</div></div></center>

</body>
</html>