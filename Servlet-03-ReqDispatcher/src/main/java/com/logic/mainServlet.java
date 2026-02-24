package com.logic;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Servlet implementation class mainServlet
 */
@WebServlet("/main")
public class mainServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html");

		String opt = req.getParameter("s");

		if (opt.equalsIgnoreCase("add")) {
			// add Servlet
			RequestDispatcher rd = req.getRequestDispatcher("add");
			rd.forward(req, res);
		}
		else {
			// sub servlet
			RequestDispatcher rd = req.getRequestDispatcher("sub");
			rd.forward(req, res);
		}
	}

}
