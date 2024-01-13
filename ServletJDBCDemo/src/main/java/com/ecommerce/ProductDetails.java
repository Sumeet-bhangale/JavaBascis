package com.ecommerce;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/product-details")
public class ProductDetails extends HttpServlet {
	DBUtil dbUtil = null;
	Connection connection = null;

	public void init(ServletConfig config) {
		try {
			dbUtil = new DBUtil();
			connection = dbUtil.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String idStr = request.getParameter("ID");

		try {
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery("SELECT * FROM eproduct WHERE ID="+idStr);

			out.println("PRODUCT DETAILS:<br><br>");
			out.println("<table border=1>");
			out.println("<tr><th>ID<th> NAME <th>PRICE<th> DATE_ADDED<th></tr>");

			while (resultSet.next()) {
				// Get data for each column of the current row
				long ID = resultSet.getLong("ID");
				String name = resultSet.getString("name");
				float price = resultSet.getFloat("price");
				Date dateAdded = resultSet.getDate("date_added");

				out.printf("<tr><td> %s <td>%s <td>%s <td>%s </tr>", ID, name, price, dateAdded);
			}
			
			out.println("</table>");

		} catch (SQLException  e) {
			out.println(e);
		}

		out.printf("<a href=\"index.html\">Home Page</a>");
		out.close();
	}

	public void destroy() {
		try {
			dbUtil.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}