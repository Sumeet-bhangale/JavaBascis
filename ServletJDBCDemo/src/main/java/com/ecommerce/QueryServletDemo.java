package com.ecommerce;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class QueryServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			
			// 1. Loading the JDBC Driver
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			Connection connection = null;
			try {
				// 2. Get the connection to the data base
				
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/ecommercedb", "root", "root1234");

				Statement statement = connection.createStatement();

				ResultSet resultSet = statement.executeQuery("SELECT * FROM eproduct");

				out.println("QUERY RESULTS:<br><br>");
				out.println("<table border=1>");
				out.println("<tr><th>ID<th> NAME <th>PRICE<th> DATE_ADDED<th></tr>");
				
				while (resultSet.next()) {
					
					// Get data for each column of the current row
					
					long ID = resultSet.getLong("ID");
					String name = resultSet.getString("name");
					float price = resultSet.getFloat("price");
					Date dateAdded = resultSet.getDate("date_added");

					out.printf("<tr><td> %s <td>%s <td>%s <td>%s </tr>",ID , name ,price , dateAdded);
				}

			} catch (SQLException e) {
				out.println(e);
			}
			
			
			
			out.close();
	}
				
}
