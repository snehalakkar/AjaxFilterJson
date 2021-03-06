<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jQuery, Ajax and Servlet/JSP integration example</title>
<script src="http://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<script>
$(document).ready(function() {
	$('#userName').blur(function() {
			
		$.ajax({
			url : 'ajaxDemoServlet',
			type:"GET",
			data : {
				userName : $('#userName').val()
			},
			success : function(responseText) {
				console.log(responseText);
				$('#ajaxGetUserServletResponse').text(responseText);
			}
		});
	});
});
</script>
</head>
<body>
<form>
		Enter Your Name: <input type="text" id="userName" />
	</form>
	<br>
	<br>

	<strong>Ajax Response</strong>:
	<div id="ajaxGetUserServletResponse"></div>
</body>
</html>