package com.bridgeLabz.loginRegistraionProject;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);

		if(session!=null){
			
			if (session.getAttribute("UserId") != null) {
				req.removeAttribute("UserId");
				session.invalidate();
				req.getSession(true);
				resp.sendRedirect("user_login");
			} 
		}
		else {
			resp.sendRedirect("user_login");
		}
	}
}
