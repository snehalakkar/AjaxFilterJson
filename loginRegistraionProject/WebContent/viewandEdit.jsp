<%@page import="com.bridgeLabz.loginRegistraionProject.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 	<link rel="stylesheet"
	href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css"> -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- <script
	src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script> -->

<title>view and edit details.....</title>
<script type="text/javascript">
var data={};
var update_Function = function() {

	data.fn=$("#fn1").val();
	data.ln=$("#ln1").val();
	data.email=$("#email").val();
	data.add=$("#add").val();
	data.comp_name=$("#comp").val();
	data.age=$("#age").val();
	data.sal=$("#sal").val();
	data.gender=$("#gender").val();
	data.specialise=$("#speci").val();
	data.lang=$("#lang").val();
	data.pwd=$("#pwd").val();
	data.contact=$("#contact").val();
	data.uid=$("#uid").val();
	console.log(data);

			$.ajax({
				url : 'ViewAndEditDetails',
				type:"POST",
				data :data, 
				
				success : function(responseText) {
					console.log(responseText);
					$("#myPopupDialog").html(responseText);
					$("#view").hide();
					$("#edit").show();
					
					
					//$("#abc").bind('click', getData); 
				},
			});
};		
</script>

<%
	Employee emp = (Employee) request.getAttribute("emp");
	if (emp != null) {
%>

<center>
<div id="view">
	 <div id="abc"><label>First_Name     :</label><%=(emp.getFirstName() != null) ? emp.getFirstName() : ""%></div><br>
	<div><label>Last_Name    :</label><%=(emp.getLastName() != null) ? emp.getLastName() : ""%></div><br>
	<div><label>Email    :</label><%=(emp.getEmail() != null) ? emp.getEmail() : ""%></div><br>
	<div><label>Address    :</label><%=(emp.getAddress() != null) ? emp.getAddress() : ""%></div><br>
	<div><label>Company_Name    :</label><%=(emp.getComp_name() != null) ? emp.getComp_name() : ""%></div><br>
	<div><label>Age    :</label><%=(emp.getAge() != 0) ? emp.getAge() : ""%></div><br>
	<div><label>Salary    :</label><%=(emp.getSal() != 0.0) ? emp.getSal() : ""%></div><br>
	<div><label>Gender    :</label><%=(emp.getGender() != null) ? emp.getGender() : ""%></div><br>
	<div><label>Specialization    :</label><%=(emp.getSpecialize() != null) ? emp.getSpecialize() : ""%></div><br>
	<div><label>lang_known    :</label><%=(emp.getLang_known() != null) ? emp.getLang_known() : ""%></div><br>
 	<div><label>Contact    :</label><%=(emp.getContact() != 0) ? emp.getContact() : ""%></div><br>
</div>
</center>
<%
	} else {
		out.print(" employee is not present ");
	}
%>


<center>
<div id="edit" style="padding-top: 5px ;">
<form id="editForm" action="ViewAndEditDetails" method="POST" >
<p><h3>Update Now...</h3></p>
<table>
<tr>
<td><label>First_Name    :</label></td><td><input type="text" id="fn1" value="<%=(emp.getFirstName() != null) ? emp.getFirstName() : ""%>"> <br></td>
</tr>
<tr>
<td><label>Last_Name    :</label></td><td><input type="text" id="ln1" value="<%=(emp.getLastName() != null) ? emp.getLastName() : ""%>"><br></td> 
</tr>
<tr>
<td><label>Email    :</label></td><td><input type="text" id="email" readonly="readonly" value="<%=(emp.getEmail() != null) ? emp.getEmail() : ""%>"> <br></td>
</tr>
<tr>
<td><label>Address    :</label></td><td><input type="text" id="add" value="<%=(emp.getAddress() != null) ? emp.getAddress() : ""%>"><br></td> 
</tr>
<tr>
<td><label>Company_Name    :</label></td><td><input type="text" id="comp" value="<%=(emp.getComp_name() != null) ? emp.getComp_name() : ""%>"> <br></td>
</tr>
<tr>
<td><label>Age    :</label></td><td><input type="number" id="age" value="<%=(emp.getAge() != 0) ? emp.getAge() : ""%>"><br> </td>
</tr>
<tr>
<td><label>Salary    :</label></td><td><input type="text" id="sal" value="<%=(emp.getSal() != 0.0) ? emp.getSal() : ""%>"><br> </td>
</tr>
<tr>
<td><label>Gender    :</label></td><td><input type="text" id="gender" value="<%=(emp.getGender() != null) ? emp.getGender() : ""%>"><br> </td>
</tr>
<tr>
<td><label>Specialization    :</label></td><td><input type="text" id="speci" value="<%=(emp.getSpecialize() != null) ? emp.getSpecialize() : ""%>"><br></td> 
</tr>
<tr>
<td><label>lang_known    :</label></td><td><input type="text" id="lang" value="<%=(emp.getLang_known() != null) ? emp.getLang_known() : ""%>"><br> </td>
</tr>
<tr>
<td><label>Contact    :</label></td><td><input type="number" id="contact" value="<%=(emp.getContact() != 0) ? emp.getContact() : ""%>"> <br></td>
</tr>
</table>

<button type="button" class="btn btn-default" id="save_btn" onclick="update_Function()" >Save</button>
 
</form>
</div>
</center>



