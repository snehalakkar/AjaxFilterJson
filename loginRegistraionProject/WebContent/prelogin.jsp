<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<div class="w3-container" style="padding: 0">
		<div style="background-color: #00B2EE" class="w3-bar" class="w3-top">
			<div><p class="navbar-brand " class="navbar-text  w3-left;" style="font-family:verdana; color:white; text-shadow: 2px 2px 8px #FF0000;"><em>Bridgelabz</em></p></div>
			<div><a href="user_reg" class="w3-bar-item w3-button w3-right"
				style="margin-top:5px;" class="w3-bar-item w3-button w3-mobile "><i
				class="fa fa-sign-in"></i>Sign Up</a></div>
			<%-- <%
			Integer id1=(Integer) session.getAttribute("UserId");
				if(id1 !=null){
			%>
			<a	href="LogoutServlet" class="w3-bar-item w3-button w3-mobile  w3-right"><span class="glyphicon glyphicon-log-out"></span>LogOut</a>
		<% }%> --%>
		</div>
	</div>
</body>
</html>