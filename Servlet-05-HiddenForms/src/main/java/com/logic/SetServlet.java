package com.logic;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/set")
public class SetServlet extends GenericServlet implements Servlet {
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

		pw.print("<h1> Your books are added to the Cart</h1>");

		pw.print("<form action ='get' method='post'>" + "<input type='hidden' name='book1' value='" + book1 + "'>"
				+ "<input type='hidden' name='book2' value='" + book2 + "'>"
				+ "<input type='hidden' name='book3' value='" + book3 + "'>"
				+ "<input type='hidden' name='book4' value='" + book4 + "'>" + "<input type='submit' value='Next'>"
				+ "</form>");

	}

}
