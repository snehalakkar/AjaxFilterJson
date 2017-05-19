package com.bridgeLabz;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ajaxDemoServlet
 */
@WebServlet("/ajaxDemoServlet")
public class ajaxDemoServlet extends HttpServlet {
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
	
		String userName = req.getParameter("userName").trim();
		if(userName == null || "".equals(userName)){
			userName = "Guest";
		}
		
		String greetings = "Hello " + userName;
		
		resp.setContentType("text/plain");
		resp.getWriter().write(greetings);
		
	}

}
