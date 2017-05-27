package com.bridgeLabz.loginRegistraionProject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewAndEditDetails
 */
@WebServlet("/ViewAndEditDetails")
public class ViewAndEditDetails extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uemail = req.getParameter("userEmail");
		Employee employee = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String qry = "select * from snehal_db.employee_details where Email=?";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			pstmt = con.prepareStatement(qry);
			pstmt.setString(1, uemail);
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
				/*String pass = rs.getString(11);
				employee.setPass(pass);*/
				long contact = rs.getLong(11);
				employee.setContact(contact);
				int userid = rs.getInt(12);
				employee.setUserid(userid);

				req.setAttribute("emp", employee);

			}
			RequestDispatcher rdq = req.getRequestDispatcher("viewandEdit.jsp");
			rdq.forward(req, resp);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fn = req.getParameter("fn");
		String ln = req.getParameter("ln");
		String email = req.getParameter("email");
		String add = req.getParameter("add");
		String comp_name = req.getParameter("comp_name");
		String age = req.getParameter("age");
		int age1 = Integer.parseInt(age);
		String sal = req.getParameter("sal");
		// double newSal=Double.parseDouble("sal");
		String gender = req.getParameter("gender");
		String specialise = req.getParameter("specialise");
		String lang = req.getParameter("lang");
		/*String pwd = req.getParameter("pwd");*/
		String contact = req.getParameter("contact");
		long contact1 = Long.parseLong(contact);
		System.out.println("cont check :" + contact);
		String uid = req.getParameter("uid");
		/* int newUid=Integer.parseInt("uid"); */

		System.out.println("updated mail:" + email);
		Connection con = null;
		PreparedStatement pstmt = null;
		PrintWriter pw = resp.getWriter();

		/*
		 * String email1=(String) req.getAttribute("updatedMail");
		 * System.out.println(email1);
		 */
		String qry1 = "update  snehal_db.employee_details set First_Name=?,Last_Name=?,Address=?,Company_Name=?,Age=?,Salary=?,Gender=?,Specialized=?,Lang_known=? where Email=?";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			pstmt = con.prepareStatement(qry1);
			pstmt.setString(1, fn);
			pstmt.setString(2, ln);
			pstmt.setString(3, add);
			pstmt.setString(4, comp_name);
			pstmt.setInt(5, age1);
			pstmt.setString(6, sal);
			pstmt.setString(7, gender);
			pstmt.setString(8, specialise);
			pstmt.setString(9, lang);
			/*pstmt.setString(10, pwd);*/
			pstmt.setString(10, email);
			// pstmt.setLong(11, contact1);
			// pstmt.setString(13, uid);

			int n = pstmt.executeUpdate();
			if (n > 0) {
				System.out.println("Update Successfull... ");
				pw.print("Update Successfull.........");

			} else {
				System.out.println("Update not Successfull ...");
				pw.print("Update not Successfull.........");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

	}
}
