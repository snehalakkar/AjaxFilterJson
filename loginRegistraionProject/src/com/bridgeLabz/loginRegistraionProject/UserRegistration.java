package com.bridgeLabz.loginRegistraionProject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserRegistration extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher=req.getRequestDispatcher("user_reg.jsp");
		requestDispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String User_Id = req.getParameter("UserId");
		String User_Name = req.getParameter("Username");
		String User_Pass = req.getParameter("UserPass");
		String User_Email = req.getParameter("UserMail");
		Connection con = null;
		PreparedStatement pstmt = null;
		String qry = "insert into snehal_db.user values(?,?,?,?)";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			pstmt = con.prepareStatement(qry);
			pstmt.setString(1, User_Id);
			pstmt.setString(2, User_Name);
			pstmt.setString(3, User_Pass);
			pstmt.setString(4, User_Email);
			int n = pstmt.executeUpdate();
			if (n > 0) {
				System.out.println("Registration Successfull ");
				resp.sendRedirect("user_login.jsp");
			} else {
				System.out.println("You have to registered again ...");
				resp.sendRedirect("user_reg.jsp");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			resp.sendRedirect("user_reg.jsp");
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
