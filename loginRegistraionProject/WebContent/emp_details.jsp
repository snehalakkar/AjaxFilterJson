<%@page import="com.bridgeLabz.loginRegistraionProject.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*" import="java.lang.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<title>Insert title here</title>
<!-- <link rel="stylesheet"
	href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css"> -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	var data = {};
	var getData = function(email) {

		data.eml = email;
		console.log(email);

		$.ajax({
			url : 'ViewAndEditDetails',
			type : "GET",
			data : {
				userEmail : email
			},
			success : function(responseText) {
				
				$("#myPopupDialog").html(responseText);
				$("#view").show();
				$("#edit").hide();
				$("#deletepopup").hide();
				/* 	$("#save_btn").bind('click', getData); //for again switching control to the save btn */
			},

		});

		/* $("#myPopupDialog").html(
				"<center><div> First_Name   :" + fname + "<br> Last_Name   :"
						+ lname + "<br> Email   :" + email + "<br> Address   :"
						+ address + "<br> Comp_Name   :" + comp_name
						+ "<br> Age   :" + age + "<br> Salary   :" + sal
						+ "<br> Gender   :" + gender
						+ "<br> Specialization   :" + specialize
						+ "<br> Language_Known   :" + lang_known
						+ "<br> Password   :" + pass + "<br> Contact   :"
						+ contact + "<br> User_Id   :" + uid
						+ "<br></div></center>");
		 */
		/* 	$("#myPopupDialog").html("<center><div>" +dataObject+ "</div></center>"); */
		$("#view_btn").hide();
		$("#btn_edit").show();
		/* $("#save_btn").hide(); */

		$("#btn_delete").click(function() {
			deleteEmployee(email);

		});

		$("#view_btn").click(function() {
			getData(email);

		});
	};

	$(document).ready(function() {
		$("#btn_edit").click(function() {
			$("#view_btn").show();
			/* $("#save_btn").show(); */
			$("#btn_edit").hide();
			$("#view").hide();
			$("#edit").show();
		});
		$("#btn_close").click(function() {
			$(this).parent().parent().show();
		});
		$("#btn_delete").click(function() {
			$("#view_btn").hide();
			$("#btn_edit").hide();
			$("#btn_delete").hide();
		});
		$("#view_btn").click(function() {
			$("#btn_edit").show();
			$("#btn_delete").show();
			$("#btn_close").show();
			$("#deletepopup").hide();
		});
	});

	function deleteEmployee(eml) {

		var checkstr = confirm('are you sure you want to delete this?');

		if (checkstr == true) {
			console.log("get eml " + eml);

			$.ajax({
				url : 'DeleteEmp',
				type : "GET",
				data : {
					userEmail1 : eml
				},
				success : function(responseText) {
					console.log(responseText);
					$("#deletepopup").html(responseText);
					$("#view").hide();
					$("#edit").hide();
				var val=eml.replace("@","_").replace(".","_");
				console.log(val);
					$('#'+val).remove();
				},
				error : function() {
					alert("error");
				}
			});
			return true;
		} else {
			return false;
		}

	};
</script>
<style type="text/css">
#myPopupDialog {
	background-color: silver;
	color: black;
}
</style>
<title>Employee details.....</title>
</head>
<body>
	<%@ include file="postLogin.jsp"%>
	<div class="container">
		<center>
			<table width=35% cellpadding="3">
				<%
					LinkedList l1 = (LinkedList) request.getAttribute("linkedList");
				%>
				<div>
					<p style="font-size: 40px; text-color: #777; left-margin: 40%">Employee
						Details...</p>
				</div>
				<tr height=40px>
					<th style="text-align: center; font-size: 20px">Employee Name</th>
					<br>
					<!-- <th>Last Name</th>
       		<th>  Email </th>
       		<th>  Address </th>
       		<th> comp_name </th>
       		<th> Age</th>
       		<th> Salary  </th>
       		<th> Gender </th>
       		<th> specialize </th>
       		<th> lang_known </th>
       		<th> Password </th>
       		<th> Contact </th>
       		<th> UserId </th> -->
				</tr>
				<%!String email;%>
				<%!Employee e1;%>
				<%
					int count = 1;
					for (int i = 0; i < l1.size(); i++) {
						e1 = (Employee) l1.get(i);

						email = e1.getEmail();

						if (count % 2 == 1) {
				%>
				<tr height=20px id="<%=email.replace("@","_").replace(".","_")%>">
					<td style="text-align: center; background-color: #bfbfbf; height: 40px; font-size: 20px"><a
						data-toggle="modal" data-target="#myModal" href="#myPopupDialog"
						data-rel="popup" onclick="getData('<%=email%>')"><%=e1.getFirstName()%></a>
						<%
							count++;
						%> <%
 	} else {
 %>
				<tr height=20px id="<%=email%>">
					<td style="text-align: center; background-color: #ffffff; height: 40px; font-size: 20px"><a
						data-toggle="modal" data-target="#myModal" href="#myPopupDialog"
						data-rel="popup" onclick="getData('<%=email%>')"><%=e1.getFirstName()%></a>
						<%
							count++;
								}
						%> <%
 	}
 %></td>
				</tr>
			</table>
		</center>
	</div>

	<!-- Modal -->
	<div class="container" id="outer_div">
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content" style="margin-top: 65px;">
					<div class="modal-header" id="header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<center>
							<h2 class="modal-title">Employee Details...</h2>
						</center>
					</div>

					<div id="myPopupDialog" data-role='popup' class='ui-content' style='height:500px';></div>
					<div id="deletepopup" data-role='popup' class='ui-content'></div>



					<div class="modal-footer" id="footer">
						<button type="button" class="btn btn-warning" id="view_btn">View</button>
						<button type="button" class="btn btn-warning" id="btn_edit">Edit</button>
						<button type="button" class="btn btn-warning" id="btn_delete">
							Delete</button>
						
						<button type="button" class="btn btn-warning" data-dismiss="modal"
							id="btn_close">Close</button>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>