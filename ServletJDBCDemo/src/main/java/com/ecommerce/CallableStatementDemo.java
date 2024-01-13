package com.ecommerce;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/callable-statement-demo")
public class CallableStatementDemo extends HttpServlet {
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
	
	/*
	use ecommercedb;
	 
	DELIMITER $$
	CREATE PROCEDURE add_product( IN in_name varchar(40), IN in_price decimal(10,2))
	INSERT INTO eproduct(name,price) VALUES (in_name, in_price);
	$$
	DELIMITER ;
	
	call add_product("dell",1010);
	*/
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String priceStr = request.getParameter("price");
		float price = Float.parseFloat(priceStr);

		try {
			CallableStatement callableStatement = connection.prepareCall(" { call add_product(?,?) } ");

			callableStatement.setString(1,name);
			callableStatement.setFloat(2, price);
			
			int count = callableStatement.executeUpdate();

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