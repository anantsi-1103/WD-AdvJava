package com.logic.servlet;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ArrayList;

import com.logic.bean.BookBean;
import com.logic.dao.viewBookDAO;

/**
 * Servlet implementation class viewBookServlet
 */
@WebServlet("/view")
public class viewBookServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		ArrayList<BookBean> al = new viewBookDAO().getAllBook();
		
		req.setAttribute("list", al);
		RequestDispatcher rd = req.getRequestDispatcher("viewBook.jsp");
		rd.include(req, res);
	}

}
