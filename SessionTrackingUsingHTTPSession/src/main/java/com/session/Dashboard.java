package com.session;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		
		// request.getSession(false) : false means if no http session object was ever created for this browser-session
		// then null be returned and don't create a new one.
		HttpSession session = request.getSession(false); 
		
		if(session!=null) {
			out.println("Welcome User.");
			out.println("<br> We are tracking you.");
		}else {
			// no session so no tracking.
			out.println("Welcome User.");
			
		}
		
		out.close();
	}

}