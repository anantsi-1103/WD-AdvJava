package com.logic.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import com.logic.bean.CustomerBean;
import com.logic.dao.UserLoginDAO;

@WebFilter("/uLogin")
public class UserLoginFilter extends HttpFilter {

	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		String uname = req.getParameter("uname");
		String pass = req.getParameter("pword");

		CustomerBean cb = new CustomerBean();

		cb.setUname(uname);
		cb.setPass(pass);

		cb = new UserLoginDAO().verifyUser(cb);

		if (cb != null && cb.getId() != null) {
			req.setAttribute("cbean", cb);
		}

		else {
			req.setAttribute("msg", "Invalid Username and Password");
			req.getRequestDispatcher("UserLogin.jsp").include(req, res);
		}

		chain.doFilter(req, res);
	}

}
