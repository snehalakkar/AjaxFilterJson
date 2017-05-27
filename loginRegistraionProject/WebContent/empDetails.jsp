<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" import="java.lang.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="postLogin.jsp" %>
<div class="container">
<center>

<table width="90%" cellpadding="3" class="table" border=1 style="background-color:#D8F0DA";>
<% 
     ArrayList rows = new ArrayList();

     if (request.getSession().getAttribute("EmpDetails") != null) 
     {
         rows = (ArrayList) request.getSession().getAttribute("EmpDetails");
         %>
         
         <tr>
       		<th>First Name</th>
       		<th>Last Name</th>
       		<th>  Email </th>
       		<th>  Address </th>
       		<th> comp_name </th
       		><th> Age</th>
       		<th> Salary  </th>
       		<th> Gender </th>
       		<th> specialize </th>
       		<th> lang_known </th>
       		<th> Password </th>
       		<th> Contact </th>
       		<th> UserId </th>
        </tr>
         <%
        
         for(Object o1:rows)
         {
        		ArrayList al=(ArrayList)o1;
        		%>
        		<tr>
        		<%
        		for(Object o2:al)
        		{
        			String v1=(String)o2;
        			%>
        			<td>
        			<% 
        				out.print(v1);
        			%>
        			</td>
        			<%
        		}
        		%>
        		</tr>
        		<%
         	}
     }
%>
</table>
</center>
</div>
<br>
<a href=profile><button value='back'style=color:red class="btn btn-warning">Back</button></a>
</body>
</html>