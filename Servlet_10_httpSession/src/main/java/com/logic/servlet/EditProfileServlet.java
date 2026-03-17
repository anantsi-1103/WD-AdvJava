package com.logic.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.logic.bean.UserBean;
import com.logic.dao.EditProfileDAO;


@WebServlet("/edit")
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	    HttpSession hs = req.getSession(false);

	    if (hs == null || hs.getAttribute("ubean") == null) {
	        req.setAttribute("msg", "Session Expired");
	        RequestDispatcher rd = req.getRequestDispatcher("UserLogin.jsp");
	        rd.forward(req, res);
	        return;
	    }

	    UserBean temp = (UserBean) req.getAttribute("ubean");

	    boolean success = new EditProfileDAO().UpdateProfile(temp);

	    if (success) {
	        hs.setAttribute("ubean", temp);

	        req.setAttribute("msg", "Profile Updated Successfully");
	        RequestDispatcher rd = req.getRequestDispatcher("Welcome.jsp");
	        rd.forward(req, res);
	    } else {
	        req.setAttribute("msg", "Profile Failed to Update");
	        RequestDispatcher rd = req.getRequestDispatcher("EditProfile.jsp");
	        rd.forward(req, res);
	    }
	}

	

}
