package com.bridgeLabz.loginRegistraionProject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteEmp
 */
@WebServlet("/DeleteEmp")
public class DeleteEmp extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String uemail1 = req.getParameter("userEmail1");
		System.out.println("email to delete :"+uemail1);
		Connection con = null;
		PreparedStatement pstmt = null;
		PrintWriter pw = resp.getWriter();
		String qry = "DELETE FROM snehal_db.employee_details WHERE Email =?";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			pstmt = con.prepareStatement(qry);
			pstmt.setString(1, uemail1);
			int n = pstmt.executeUpdate();
			if (n > 0) {
				System.out.println("Delete Successfull... ");
				pw.print("Delete Successfull.........");

			} else {
				System.out.println("Delete not Successfull ...");
				pw.print("Delete not Successfull.........");
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
