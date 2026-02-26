package com.logic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
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

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	        throws ServletException, IOException {

	    res.setContentType("text/html");
	    PrintWriter pw = res.getWriter();

	    String uname = req.getParameter("uname");
	    String pass = req.getParameter("pass"); // Make sure HTML uses same name

	    try {
	        PreparedStatement ps = con.prepareStatement(
	            "select * from uinfo where uname = ? and pass = ?"
	        );

	        ps.setString(1, uname);
	        ps.setString(2, pass);

	        ResultSet rs = ps.executeQuery();

	        pw.println("<html><body bgcolor='black' text='white'><center>");

	        if (rs.next()) {
	            pw.print("<h2>Welcome " + uname + "!</h2>");
	        } else {
	            pw.print("<h2>Invalid Username or Password</h2>");
	        }

	        pw.println("</center></body></html>");

	    } catch (Exception e) {
	        pw.println("<h3>Error: " + e.getMessage() + "</h3>");
	    }
	
	}

}
