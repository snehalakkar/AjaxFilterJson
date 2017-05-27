<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page ...</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
body {
	/* background-image: url("img/login.jpeg");
	background-repeat: no-repeat;
	background-size: cover; */
	background: white;
}

#ex1 {
	background-color: transparent;
	height: 40%;
	width: 40%;
	div-align: center;
	margin-top: 100px;
	border-radius: 10px;
	opacity: 0.95;
	alpha: 0.65;
	box-shadow: 0 0 40px 0 rgba(0, 0, 0, 0.2), 0 10px 10px 0
		rgba(0, 0, 0, 0.24);
}

</style>
<script type="text/javascript">
				function formValidation() {
					var email = document.registration.uemail;
					var pass = document.registration.pass;
					if (ValidateEmail(email)) {
						if (pass_validation(pass, 7, 12)) {
							return true;
						}
					}
				}

				function ValidateEmail(email) {
					var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
					if (email.value.match(mailformat)) {
						return true;
					} else {
						alert("You have entered an invalid email address!");
						email.focus();
						return false;
					}
				}

				function pass_validation(pass, mx, my) {
					var passid_len = pass.value.length;
					if (passid_len == 0 || passid_len > my || passid_len < mx) {
						alert("Password should not be empty / length must be between "
								+ mx + " to " + my);
						pass.focus();

						return false;
					}
					else{
					return true;
				}
				}
				
</script>
</head>
<body>

<%@ include file="prelogin.jsp" %>
	<div class="container" style="height:100%; width:100%">
	<div class="row">
    <div class="col-sm-12">
     <div class="col-sm-4">
     </div>
     <div class="col-sm-4">
    <form action="user_login" method="post" name='registration'
			onSubmit="return formValidation();">
			<center>
				<div class="table-responsive">
					<table width="30%" cellpadding="3" class="table" id="ex1">
						<thead>
							<tr>
								<th colspan="2">Login Here</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>&nbsp User Email</td>
								<td><input type="text" name="uemail" value="" /></td>
							</tr>
							<tr>
								<td>&nbsp User Password</td>
								<td><input type="password" name="pass" value="" /></td>
								
								<tr><td></td><td><%HttpSession session1=request.getSession();
				String msg = (String)session1.getAttribute("msg");
				
				if(msg!=null){
				%>
				<p style='font-style:verdana ;color:red'>Invalid credential...</p></td></tr>
				<%}%>
				
							</tr>
							
							<tr>
								<td style="text-indent: 5em;"><input type="submit"
									value="Login"
									onmouseover="this.style.backgroundColor='#FF9B9B';return true;"
									onmouseout="this.style.backgroundColor='bisque';return true;" /></td>
								<td style="text-indent: 5em;"><input type="reset"
									value="Reset"
									onmouseover="this.style.backgroundColor='#FF9B9B';return true;"
									onmouseout="this.style.backgroundColor='bisque';return true;" /></td>
							</tr>
							<tr>
								<td colspan="2">Yet Not Registered!! <a href="user_reg">Register
										Here</a></td>
							</tr>
						</tbody>
					</table>
				</div>
			</center>

			
		</form>
    </div>
    <div class="col-sm-4">
     </div>
    </div>
   
  </div>
		
	</div>
	<%-- <%@ include file="footer.jsp" %> --%>
</body>
</html>
