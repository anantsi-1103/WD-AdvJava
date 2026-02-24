package com.logic;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sub")
public class SubServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");

		PrintWriter pw = res.getWriter();

		int first = Integer.parseInt(req.getParameter("first"));
		int second = Integer.parseInt(req.getParameter("second"));

		if (first > second) {
			pw.print("Substraction of your number is " + (first - second));
		} else {
			pw.print("Substraction of your number is " + (second - first));
		}

		RequestDispatcher rd = req.getRequestDispatcher("SubOutput.html");
		rd.include(req, res);
	}

}
