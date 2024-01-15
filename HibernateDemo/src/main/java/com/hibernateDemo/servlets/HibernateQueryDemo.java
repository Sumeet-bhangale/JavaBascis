package com.hibernateDemo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernateDemo.EProduct;
import com.hibernateDemo.HibernateUtil;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hibernate-query-demo")
public class HibernateQueryDemo extends HttpServlet {

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

		// Fetch data from eproduct table

		List<EProduct> products = session.createQuery("from EProduct").list();

		out.println("<table border=1>");
		for (EProduct p : products) {

			out.println("<tr>");

			out.printf("<td> %s", p.getID());
			out.printf("<td>  %s", p.getName());
			out.printf("<td> %s", p.getPrice());
			out.printf("<td>  %s", p.getDateAdded());

		}

		out.println("</table>");
		session.close();

		out.println("</body></html>");
		out.close();

	}

}
