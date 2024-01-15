package com.hibernateDemo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernateDemo.HibernateUtil;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HibernateInitDemo extends HttpServlet {
	
	SessionFactory sessionFactory = null;

	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		// Get the SessionFactory object and the Session object
		sessionFactory = HibernateUtil.getSessionFactory();		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("<html><body>");

		Session session = sessionFactory.openSession();
		
		out.println("Hibernate Session opened.<br>");
		
		session.close();
		out.println("Hibernate Session closed.<br>");

		out.println("</body></html>");
		out.close();	

		
		
	}

}
