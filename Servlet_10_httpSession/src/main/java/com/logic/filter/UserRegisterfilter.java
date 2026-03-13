package com.logic.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.logic.bean.CustomerBean;
import com.logic.bean.UserBean;

@WebFilter("/uReg")
public class UserRegisterfilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		UserBean ub = new UserBean();

		ub.setId(Integer.parseInt(req.getParameter("uId")));
		ub.setFname(req.getParameter("fname"));
		ub.setLname(req.getParameter("lname"));
		ub.setMid(req.getParameter("email"));
		ub.setAddr(req.getParameter("address"));
		ub.setPhone(req.getParameter("phone"));

		CustomerBean cb = new CustomerBean();

		cb.setUname(req.getParameter("uname"));
		cb.setPass(req.getParameter("pass"));
		cb.setId(Integer.parseInt(req.getParameter("uId"))); // FIXED

		req.setAttribute("ubean", ub);
		req.setAttribute("cbean", cb);

		chain.doFilter(req, res);
	}
}