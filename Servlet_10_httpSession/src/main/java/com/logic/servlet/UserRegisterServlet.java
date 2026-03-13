package com.logic.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logic.bean.CustomerBean;
import com.logic.bean.UserBean;
import com.logic.dao.UserRegisterDAO;



@WebServlet("/uReg")
public class UserRegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		UserBean ub = (UserBean) req.getAttribute("ubean");
		CustomerBean cb = (CustomerBean) req.getAttribute("cbean");

		int k = new UserRegisterDAO().addUser(ub, cb);

		if (k > 0) {
			req.setAttribute("msg", "Registration Successful");
			req.getRequestDispatcher("UserLogin.jsp").forward(req, res);
		} else {
			req.setAttribute("msg", "Registration Failed");
			req.getRequestDispatcher("UserRegister.jsp").forward(req, res);
		}
	}
}