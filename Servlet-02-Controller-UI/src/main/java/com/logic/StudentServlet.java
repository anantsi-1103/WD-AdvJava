package com.logic;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/logic")
public class StudentServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html");

		PrintWriter pw = res.getWriter();

		String Studentname = req.getParameter("name");
		String gender = req.getParameter("gender");
		String course = req.getParameter("course");
		String doj = req.getParameter("date");
		String fee = req.getParameter("fee");
		String state = req.getParameter("state");

		pw.print("------ Student Details ------<br>");
		pw.print("Student Name: " + Studentname + "<br>");
		pw.print("Gender: " + gender + "<br>");
		pw.print("Course Name: " + course + "<br>");
		pw.print("Date of Joining : " + doj + "<br>");
		pw.print("Fees: " + fee + "<br>");
		pw.print("State: " + state + "<br>");

	}

}
