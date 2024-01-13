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

@WebServlet("/insert-product")
public class InsertProduct extends HttpServlet {
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

		String name = request.getParameter("name");
		String price = request.getParameter("price");

		try {
			Statement statement = connection.createStatement();

			String sql = String.format("INSERT INTO eproduct(name,price) VALUES('%s',%s)", name, price);

			int count = statement.executeUpdate(sql);

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