package com.hibernateDemo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernateDemo.Color;
import com.hibernateDemo.EProduct;
import com.hibernateDemo.Finance;
import com.hibernateDemo.HibernateUtil;
import com.hibernateDemo.OS;
import com.hibernateDemo.ScreenSize;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hibernate-collection-mapping-demo")
public class HibernateCollectionMappingDemo extends HttpServlet {

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
		out.printf("<th>ID <th> NAME <th>PRICE<th>DATE_ADDED <th colspan=2>COLORS</th> <th> OS <th> SCREEN SIZE <th> FINANCE ");
		for (EProduct p : products) {

			out.println("<tr>");

			out.printf("<td> %s", p.getID());
			out.printf("<td>  %s", p.getName());
			out.printf("<td> %s", p.getPrice());
			out.printf("<td>  %s", p.getDateAdded());
			
			List<Color> colors = p.getColors();
			for(Color color : colors)	out.printf("<td>  %s", color.getName());
			
			Set<OS> oses = p.getOses();
			for(OS os : oses)	out.printf("<td>  %s", os.getName());	
			
			Collection<ScreenSize> screenSizes = p.getScreenSizes();
			for(ScreenSize screenSize : screenSizes)	out.printf("<td>  %s", screenSize.getSize());	
			
			Map finances = p.getFinance();			
			finances.forEach( (ftype,name) -> out.printf("<td>  %s , %s ",ftype, name));	

		}

		out.println("</table>");
		session.close();

		out.println("</body></html>");
		out.close();

	}

}