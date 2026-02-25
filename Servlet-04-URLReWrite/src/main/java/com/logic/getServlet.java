package com.logic;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/get")
public class getServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

//		Mime Type
		res.setContentType("text/html");

//		Print
		PrintWriter pw = res.getWriter();

		String book1 = req.getParameter("book1");
		String book2 = req.getParameter("book2");
		String book3 = req.getParameter("book3");
		String book4 = req.getParameter("book4");

		if (book1 != null) {
			pw.print(book1 + "<br>");
		}

		if (book2 != null) {
			pw.print(book2 + "<br>");
		}

		if (book3 != null) {
			pw.print(book3 + "<br>");
		}

		if (book4 != null) {
			pw.print(book4 + "<br>");
		}

	}

}
