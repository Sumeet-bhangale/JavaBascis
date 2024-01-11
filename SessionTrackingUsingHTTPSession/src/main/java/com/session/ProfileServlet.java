package com.session;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession(false);

		if (session == null) {
			out.print("Login to see your profile.");
			out.print("<br> <a href=\"login.html\">Login</a>");
			out.print("<br> <a href=\"index.html\">Index Page</a>");
		} else {

			String user = (String) session.getAttribute("userid");
			out.print("Welcome, " + user);
			out.print("<br> <a href=\"index.html\">Index page</a>");
		}

	}

}