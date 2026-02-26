package com.logic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/reg")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String loadDriver = "com.mysql.cj.jdbc.Driver";
	public static final String url = "jdbc:mysql://localhost:3306/WD_adv_4_30";
	public static final String username = "root";
	public static final String password = "Anant@1234";
	Connection con;

	public void init() throws ServletException {
		try {
			Class.forName(loadDriver);
			con = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException e) {
			throw new ServletException("JDBC Driver not Found");
		} catch (SQLException e) {
			throw new ServletException("Database Connection error");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		if (con == null) {
			throw new ServletException("Database connection is null, check init()");
		}

		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String uname = req.getParameter("uname");
		String pass = req.getParameter("pass");

		try {
			PreparedStatement ps = con.prepareStatement("insert into uinfo values(?,?,?,?)");

			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, uname);
			ps.setString(4, pass);

			ps.executeUpdate();

			pw.println("<html><body bgcolor='black' text='white'><center>");
			pw.println("<h2>Registration Successful</h2>");
			pw.println("<a href='login.html'>Go to Login</a>");
			pw.println("</center></body></html>");

		} catch (Exception e) {
			pw.println("<h3>Error: " + e.getMessage() + "</h3>");
		}

	}

}
