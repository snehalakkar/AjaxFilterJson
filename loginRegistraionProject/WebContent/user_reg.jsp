<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Registeration</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style type="text/css">
body {
	background: white;
}

#ex1 {
	background-color: transparent;
	height: 320px;
	width: 390px;
	div-align: center;
	margin-top: 100px;
	border-radius: 5px;
	opacity: 0.95;
	alpha: 0.65;
	box-shadow: 0 0 40px 0 rgba(0, 0, 0, 0.4), 0 10px 10px 0
		rgba(0, 0, 0, 0.45);
}
</style>

</head>
<body>
<%@ include file="prelogin.jsp" %>
	<div class="container">
		<form action="user_reg" method="post" name='registration'
			onSubmit="return formValidation();">
			<center>
				<div class="table-responsive">
					<table width="30%" cellpadding="3" class="table" id="ex1">
						<thead>
							<tr>
								<th colspan="2"
									style="text-align: center; font-size: 28px; font-family:"Roboto", sans-serif;">Register
									Here</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>UserId</td>
								<td><input type="number" name="UserId" value="" /></td>
							</tr>

							<tr>
								<td>UserName</td>
								<td><input type="text" name="Username" value="" size="50" /></td>
							</tr>

							<tr>
								<td>UserEmail</td>
								<td><input type="text" name="UserMail" value="" size="50" /></td>
							</tr>

							<tr>
								<td>Password</td>
								<td><input type="password" name="UserPass" value="" /></td>
							</tr>

							<tr>
								<td><input type="submit" value="Submit"
									onmouseover="this.style.backgroundColor='#FF9B9B';return true;"
									onmouseout="this.style.backgroundColor='#ffa31a';return true;" /></td>
								<td><input type="reset" value="Reset"
									onmouseover="this.style.backgroundColor='#FF9B9B';return true;"
									onmouseout="this.style.backgroundColor='#ffa31a';return true;" /></td>
							</tr>

							<tr>
								<td colspan="2">Already registered!! <a
									href="user_login">Login Here</a></td>
							</tr>
						</tbody>
					</table>
				</div>
			</center>
			<script type="text/javascript">
				function formValidation() {
					var userId = document.registration.UserId;
					var Username = document.registration.Username;
					var UserMail = document.registration.UserMail;
					var UserPass = document.registration.UserPass;

					if (ValidateUserId(userId)) {
						if (ValidateUserName(Username)) {
							if (ValidateUserMail(UserMail)) {
								if (ValidateUserPass(UserPass, 7, 12)) {
									return true;
								}
							}
						}
					}
				}

				function ValidateUserId(userId) {
					var numbers = /^[0-9]+$/;
					if (userId.value.match(numbers)) {
						return true;
					} else {
						alert('User Id must be int value ');
						userId.focus();
						return false;
					}
				}

				function ValidateUserName(Username) {
					var letters = /^[A-Za-z]+$/;
					if (Username.value.match(letters)) {
						return true;
					} else {
						alert('Username must have alphabet characters only');
						Username.focus();
						return false;
					}
				}

				function ValidateUserMail(UserMail) {
					var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
					if (UserMail.value.match(mailformat)) {
						return true;
					} else {
						alert("You have entered an invalid email address!");
						UserMail.focus();
						return false;
					}
				}

				function ValidateUserPass(UserPass, mx, my) {
					var passid_len = UserPass.value.length;
					if (passid_len == 0 || passid_len > my || passid_len < mx) {
						alert("Password should not be empty / length must be between "
								+ mx + " to " + my);
						UserPass.focus();
						return false;
					}
					return true;
				}
			</script>
		</form>
	</div>
	<%-- <%@ include file="footer.jsp" %> --%>
</body>
</html>