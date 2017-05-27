package com.bridgeLabz.loginRegistraionProject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyFilter implements Filter{
	FilterConfig filterConfig = null;

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req1=(HttpServletRequest) req;
		HttpServletResponse resp1=(HttpServletResponse) resp;

		PrintWriter pw=resp.getWriter();
		HttpSession session=req1.getSession();
		
		 Integer id= (Integer) session.getAttribute("UserId");
		if(id !=null){
			chain.doFilter(req, resp);
		}
		else{
			resp1.sendRedirect("user_login");
		}
	}
	 public void destroy() {}
}
