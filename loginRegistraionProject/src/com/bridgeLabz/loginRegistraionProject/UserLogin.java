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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserLogin extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 		RequestDispatcher requestDispatcher=req.getRequestDispatcher("user_login.jsp");
		requestDispatcher.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		String User_Mail = req.getParameter("uemail");
		String User_pass = req.getParameter("pass");

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String QRY = "select * from snehal_db.user where user_email=? and user_pass=?";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
				pstmt = con.prepareStatement(QRY);
				pstmt.setString(1, User_Mail);
				pstmt.setString(2, User_pass);
				rs = pstmt.executeQuery();
				
				if(rs.next())
				{
				int user_id=rs.getInt(1);
				HttpSession session = req.getSession();
				session.setAttribute("UserId", user_id);
				RequestDispatcher rdq = req.getRequestDispatcher("profile");
				req.setAttribute("mail", User_Mail);
				rdq.forward(req, resp);
				}
				else{
					HttpSession session1 = req.getSession();
					session1.setAttribute("msg", User_Mail);
					/*System.out.println("Sorry Invalid userEmail & Password ");*/
					/*pw.print("<html><body><h5> Sorry invalid username and Password.....</h5></body></html>");*/
					resp.sendRedirect("user_login");
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			finally {
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
