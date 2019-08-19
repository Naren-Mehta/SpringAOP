package com.cms.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TestDBServlet() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Setup connection variable

		String username = "springstudent";
		String password = "springstudent";

		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?createDatabaseIfNotExist=true&useSSL=false";
		String driver = "com.mysql.cj.jdbc.Driver";

		// get a connection

		try {
			PrintWriter out=	response.getWriter();
			
			out.print("Connecting to Database "+jdbcUrl);
			
			Class.forName(driver);
			Connection myCon= DriverManager.getConnection(jdbcUrl,username,password);
			out.println("Success!!!");
			
			myCon.close();
		
		} catch (Exception e) {
			System.out.println("Exception======>");
			e.printStackTrace();
		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
