package com.logic;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/add")
public class AddServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");

		PrintWriter pw = res.getWriter();

//		pw.print("Inside Add Servlet");

		String first = req.getParameter("first");
		String second = req.getParameter("second");

		pw.print("Addition of your number is " + (Integer.parseInt(first) + Integer.parseInt(second)));

		RequestDispatcher rd = req.getRequestDispatcher("AddOutput.html");
		rd.include(req, res);
	}

}
