package com.logic;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/get")
public class getServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

//		Mime Type
		res.setContentType("text/html");

//		Print
		PrintWriter pw = res.getWriter();

		String book1 = req.getParameter("book1");
		String book2 = req.getParameter("book2");
		String book3 = req.getParameter("book3");
		String book4 = req.getParameter("book4");

		Cookie ck[] = req.getCookies();

		for (Cookie c : ck) {
			if (c.getName().equals("book1")) {
				pw.print(c.getValue() + "<br>");
			}

			if (c.getName().equals("book2")) {
				pw.print(c.getValue() + "<br>");
			}

			if (c.getName().equals("book3")) {
				pw.print(c.getValue() + "<br>");
			}

			if (c.getName().equals("book4")) {
				pw.print(c.getValue() + "<br>");
			}
		}

	}

}
