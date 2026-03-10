package com.logic.servlet;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

import com.logic.bean.BookBean;
import com.logic.dao.ViewBookByDAO;

@WebServlet("/viewBy")
public class viewByServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//		Data Store krna hai -> 
		BookBean bb = new BookBean();

		bb.setId(Integer.parseInt(req.getParameter("id")));

		bb = new ViewBookByDAO().getByID(bb);

		req.setAttribute("bean", bb);
		req.getRequestDispatcher("viewBookOutput.jsp").include(req, res);

	}

}
