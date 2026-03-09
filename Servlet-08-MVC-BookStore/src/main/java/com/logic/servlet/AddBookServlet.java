package com.logic.servlet;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

import com.logic.bean.BookBean;
import com.logic.dao.AddBookDAO;

@WebServlet("/add")
public class AddBookServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");

		PrintWriter pw = res.getWriter();

		BookBean bb = new BookBean();

		bb.setId(Integer.parseInt(req.getParameter("id")));
		bb.setName((req.getParameter("name")));
		bb.setPrice(Integer.parseInt(req.getParameter("price")));
		bb.setAuthor((req.getParameter("author")));

		int k = new AddBookDAO().saveBook(bb);

		if (k > 0) {
			pw.print("<font color= green> Book Added Successfully </font> <br>");
			RequestDispatcher rd = req.getRequestDispatcher("index.html");
			rd.include(req, res);
		} else {
			pw.print("<font color= red> Book Failed to Add </font> <br>");
			RequestDispatcher rd = req.getRequestDispatcher("index.html");
			rd.include(req, res);
		}
	}

}
