package com.bridgeLabz.loginRegistraionProject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetEmployeeDetails extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		PrintWriter pw = resp.getWriter();
		if (session != null) {
			 
			if (session.getAttribute("UserId") != null) {
				int user_id=(int) session.getAttribute("UserId");
				Employee employee = new Employee();
				LinkedList<Employee> linkedList = new LinkedList<>();

				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String qry = "select * from snehal_db.employee_details where user_id=? ORDER BY Salary desc";

				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
					pstmt = con.prepareStatement(qry);
					pstmt.setInt(1, user_id);
					pstmt.executeQuery();
					rs = pstmt.getResultSet();

					while (rs.next()) {

						employee = new Employee();

						String fname = rs.getString(1);
						employee.setFirstName(fname);
						String lname = rs.getString(2);
						employee.setLastName(lname);
						String email = rs.getString(3);
						employee.setEmail(email);
						String add = rs.getString(4);
						employee.setAddress(add);
						String comp_name = rs.getString(5);
						employee.setComp_name(comp_name);
						int age = rs.getInt(6);
						employee.setAge(age);
						double sal = rs.getDouble(7);
						employee.setSal(sal);
						String gender = rs.getString(8);
						employee.setGender(gender);
						String specialize = rs.getString(9);
						employee.setSpecialize(specialize);
						String lang_known = rs.getString(10);
						employee.setLang_known(lang_known);
						
						long contact = rs.getLong(11);
						employee.setContact(contact);
						int userid = rs.getInt(12);
						employee.setUserid(userid);
						/*
						 * pw.print("<tr><td>\t " + fname + " \t</td><td>\t " +
						 * lname + "\t</td><td> " + email + "</td><td> " + add +
						 * "</td><<td>" + comp_name + " </td><td>" + age +
						 * "</td><td>" + sal + "</td><td>" + gender +
						 * "</td><td>" + specialize + "</td><td>" + lang_known +
						 * "</td><td>" + pass + "</td><td>" + contact +
						 * "</td><td> " + userid + "</td></tr>");
						 */
						linkedList.add(employee);

					}
					req.setAttribute("linkedList", linkedList);
					RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/emp_details.jsp");
					requestDispatcher.forward(req, resp);
					/*
					 * pw.
					 * print("</table><br><br><a href=user_login.jsp><button value='back'style=color:red>Back</button></a></body></html>"
					 * );
					 */ } catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			} else {
				pw.print("<html><body><a href='user_login'>session invalid ,login again....</a></body></html>");
				System.out.println("session logout ");
			}
		}

	}
}
