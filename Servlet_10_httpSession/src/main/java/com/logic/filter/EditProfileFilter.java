package com.logic.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import com.logic.bean.UserBean;

@WebFilter("/edit")
public class EditProfileFilter extends HttpFilter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		try {
			UserBean ub = new UserBean();

			ub.setId(Integer.parseInt(req.getParameter("uId")));
			ub.setFname(req.getParameter("fname"));
			ub.setLname(req.getParameter("lname"));
			ub.setMid(req.getParameter("email"));
			ub.setAddr(req.getParameter("addr"));
			ub.setPhone(req.getParameter("phone"));

			// optional: username
			req.setAttribute("uname", req.getParameter("uname"));
			chain.doFilter(req, res);
		} catch (Exception e) {
			req.setAttribute("msg", "Invalid data Format");
			req.getRequestDispatcher("EditProfile.jsp").forward(req, res);
		}

	}

}
