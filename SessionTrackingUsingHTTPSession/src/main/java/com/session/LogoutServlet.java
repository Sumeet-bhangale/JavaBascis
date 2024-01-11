package com.session;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session  = request.getSession(false);
		
		if(session!=null)
			session.invalidate();
		
		out.print("<center>Logout successful.</center>");
		out.print("<br> <a href=\"login.html\">Re Login</a>");
		out.print("<br> <a href=\"index.html\">Go to Index Page</a>");
	}
    

}