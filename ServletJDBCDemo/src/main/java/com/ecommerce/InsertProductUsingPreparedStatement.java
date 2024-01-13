package com.ecommerce;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/insert-product-prepared-statement")
public class InsertProductUsingPreparedStatement extends HttpServlet {
	DBUtil dbUtil = null;
	Connection connection = null;
	PreparedStatement pStatement = null;

	public void init(ServletConfig config) {
		try {
			dbUtil = new DBUtil();
			connection = dbUtil.getConnection();
			
			pStatement = connection.prepareStatement("INSERT INTO eproduct(name,price) VALUES(?,?)");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String priceStr = request.getParameter("price");
		float price = Float.parseFloat(priceStr);

		try {			

			pStatement.clearParameters();
			pStatement.setString(1,name);
			pStatement.setFloat(2, price);
			
			int count = pStatement.executeUpdate();			

			out.println(count + "(s) PRODUCT ADDED Successfully:<br><br>");

		} catch (SQLException e) {
			out.println(e);
		}

		out.printf("<br><br> <a href=\"index.html\">Home Page</a>");
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