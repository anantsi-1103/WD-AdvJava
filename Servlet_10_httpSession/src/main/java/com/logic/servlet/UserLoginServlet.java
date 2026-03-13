package com.logic.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.logic.bean.CustomerBean;
import com.logic.bean.UserBean;
import com.logic.dao.UserLoginDAO;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/uLogin")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		CustomerBean cb = (CustomerBean) req.getAttribute("cbean");

		if (cb == null) {
			req.setAttribute("msg", "Session Error");
			req.getRequestDispatcher("UserLogin.jsp").forward(req, res);
			return;
		}

		UserBean ub = new UserLoginDAO().getData(cb);

		if (ub == null) {
			req.setAttribute("msg", "User detail not found");
			req.getRequestDispatcher("UserLogin.jsp").forward(req, res);
		} else {
			HttpSession hs = req.getSession();
			hs.setAttribute("cbean", cb);
			hs.setAttribute("ubean", ub);
			res.sendRedirect("Welcome.jsp");
		}

	}

}
