<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
body {
	/* background-image: url("img/reg1.jpeg");
	background-repeat: no-repeat;
	background-size: cover;  */
	background-color: white;
}

#ex1 {
	background: transparent;
	/* background-image: url("img/reg1.jpeg"); */
	/* background-color: #e6e6e6; */
	background-repeat: no-repeat;
	background-size: cover;
	height: 55%;
	div-align: center;
	margin-top: 100px;
	opacity: 0.95;
	alpha: 0.65;
	box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.3), 0 5px 5px 0
		rgba(0, 0, 0, 0.34);
	div-align: center;
}
</style>
<script type="text/javascript">
	function formValidation1() {
		var fname = document.registration.fname;
		var lname = document.registration.lname;
		var email = document.registration.email;
		var add = document.registration.add;
		var comp_name = document.registration.comp_name;
		var age = document.registration.age;
		var sal = document.registration.sal;
		var gender = document.registration.gender;
		var specialize = document.registration.specialize;
		var lang_known = document.registration.lang_known;
		var pass = document.registration.pass;
		var contact = document.registration.contact;

		if (fname_validation(fname)) {
			if (lname_validation(lname)) {
				if (ValidateEmail(email)) {
					if (ValidateAge(age, 18, 65)) {
						if (gender_validation(gender)) {
							if (pass_validation(pass, 7, 12)) {
								if (contact_validation(contact)) {
									return true;
								}
							}
						}
					}
				}
			}
		}
	}
	function fname_validation(fname) {
		var letters = /^[A-Za-z]+$/;
		if (fname.value.match(letters)) {
			return true;
		} else {
			alert('firstname must have alphabet characters only');
			fname.focus();
			return false;
		}
	}

	function lname_validation(lname) {
		var letters = /^[A-Za-z]+$/;
		if (lname.value.match(letters)) {
			return true;
		} else {
			alert('lasttname must have alphabet characters only');
			lname.focus();
			return false;
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

	function ValidateAge(age, mxx, myy) {
		var age1 = age.value;
		if (age1< mxx || age1>myy) {
			alert("age should be between " + mxx + " to " + myy);
			age.focus();
			return false;
		}
		return true;
	}

	function gender_validation(gender) {
		x = 0;
		if (gender.value != "") {
			x++;
		}
		if (x == 0) {
			alert('Select Male/Female/other');
			gender.focus();
			return false;
		} else {
			//window.location.reload() ; 
			return true;
		}
	}

	function pass_validation(pass, mx, my) {
		var passid_len = pass.value.length;
		if (passid_len == 0 || passid_len >= my || passid_len < mx) {
			alert("Password should not be empty / length be between " + mx
					+ " to " + my);
			pass.focus();
			return false;
		}
		return true;
	}

	function contact_validation(contact) {
		var numbers = /^[0-9]+$/;
		if (contact.value.match(numbers) && (contact.value.length == 10)) {
			alert('Form Successfully Submitted');
			return true;
		} else {
			alert('contact code must have numeric characters only and 10 digit ');
			contact.focus();
			return false;
		}
	}
</script>
</head>
<body>
	<%@ include file="postLogin.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-lg-4 col-md-3"></div>
			<div class="col-lg-4 col-md-6 col-sm-12 col-xs-12">
				<form action="reg" method="post" name='registration'
					onSubmit="return formValidation1();">
					<!-- <center>
					<div class="table-responsive"> -->
					<table  class="table" id="ex1">
						<thead>
							<tr>
								<th colspan="2" style="text-align: center; font-size: 18px;">Enter
									Information Here</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>First Name</td>
								<td><input type="text" name="fname" value="" /></td>
							</tr>
							<tr>
								<td>Last Name</td>
								<td><input type="text" name="lname" value="" /></td>
							</tr>
							<tr>
								<td>Email</td>
								<td><input type="text" name="email" value="" /></td>
							</tr>
							<tr>
								<td>Address</td>
								<td><textarea name="add" rows="3" cols="20" value="";/></textarea></td>
							</tr>
							<tr>
								<td>Company Name</td>
								<td><input type="text" name="comp_name" value="" /></td>
							</tr>
							<tr>
								<td>Age</td>
								<td><input type="number" name="age" value="" /></td>
							</tr>
							<tr>
								<td>Salary</td>
								<td><input type="text" name="sal" value="" /></td>
							</tr>
							<tr>
								<td>Gender</td>
								<td><input type="radio" name="gender" value="male"><label
									for="male">Male</label><br> <input type="radio"
									name="gender" value="female"><label for="female">female</label><br>
									<input type="radio" name="gender" value="other"><label
									for="other">other</label><br></td>
							</tr>
							<tr>
								<td>Specialized</td>
								<td><li><select name="specialize"
										style="color: #ff4d4d; font-size: 14px; width: 55%;">
											<option selected="" value="Default"
												style="color: #ffa31a; font-size: 14px;">(select)</option>
											<option value="java">java</option>
											<option value="sql">sql</option>
											<option value="dotnet">dotnet</option>
											<option value="android">android</option>
											<option value="angular">angular</option>
											<option value="ios">ios</option>
									</select></li></td>
							</tr>
							<tr>
								<td>Languages Known</td>
								<td><input type="checkbox" name="lang_known" value="hindi" /><label
									for="hindi">hindi</label><br> <input type="checkbox"
									name="lang_known" value="english" /><label for="english">english</label><br>
									<input type="checkbox" name="lang_known" value="marathi" /><label
									for="marathi">marathi</label><br> <input type="checkbox"
									name="lang_known" value="kannada" /><label for="kannada">kannada</label><br>
									<input type="checkbox" name="lang_known" value="gujrathi" /><label
									for="gujrathi">gujrathi</label><br> <input type="checkbox"
									name="lang_known" value="tamil" /><label for="tamil">tamil</label></td>
							</tr>
							<tr>
								<td>Contact</td>
								<td><input type="number" name="contact" value="" size="10" /></td>
							</tr>

							<tr>
								<td></td>
								<td><input type="submit" class="btn btn-info"
									value="submit"/>
									
									<input type="reset" class="btn btn-info" value="Reset"/></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
			<div class="col-lg-4 col-md-3"></div>
		</div>
	</div>
	<%-- <%@ include file="footer.jsp" %> --%>
</body>
</html>


