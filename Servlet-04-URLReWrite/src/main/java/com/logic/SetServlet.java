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

		pw.print("<a href= 'get?book1=" + book1 + "&book2=" + book2 + "&book3=" + book3 + "&book4=" + book4
				+ "'> Next </a> ");

	}

}
