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

@WebServlet("/set")
public class SetServlet extends HttpServlet {
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
//
//		pw.print("<h1> Your books are added to the Cart</h1>");
//
//		pw.print("<form action ='get' method='post'>" + "<input type='hidden' name='book1' value='" + book1 + "'>"
//				+ "<input type='hidden' name='book2' value='" + book2 + "'>"
//				+ "<input type='hidden' name='book3' value='" + book3 + "'>"
//				+ "<input type='hidden' name='book4' value='" + book4 + "'>" + "<input type='submit' value='Next'>"
//				+ "</form>");
		
		if(book1 != null) {
			Cookie ck = new Cookie("book_1", book1);
			res.addCookie(ck); // cookie ko add kr rhe ho as a collection - array
		}
		
		if(book2 != null) {
			Cookie ck = new Cookie("book_2", book2);
			res.addCookie(ck); // cookie ko add kr rhe ho as a collection - array
		}
		
		if(book3 != null) {
			Cookie ck = new Cookie("book_3", book3);
			res.addCookie(ck); // cookie ko add kr rhe ho as a collection - array
		}
		
		
		if(book4 != null) {
			Cookie ck = new Cookie("book_4", book4);
			res.addCookie(ck); // cookie ko add kr rhe ho as a collection - array
		}

		pw.print("<h1> Yout books will add to cart </h1>");
		
		pw.print("<a href='get'>Next</a>");
	}

}
