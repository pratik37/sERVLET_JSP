package com.mindgate.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ApplicationServlet")
public class ApplicationServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String Firstname, Lastname, gender, qualification, language;
		Firstname = request.getParameter("Firstname");
		Lastname = request.getParameter("Lastname");
		gender = request.getParameter("gender");
		qualification = request.getParameter("education");
		language = request.getParameter("language");

		String langs[] = request.getParameterValues("language");

		PrintWriter out = response.getWriter();
		out.println("<h1> Applicant Details are :- </h1>");
		out.println("First Name :" + Firstname +"<br>");

		out.println("Last Name :" + Lastname+"<br>");
		out.println("Gender :" + gender +"<br>");
		out.println("Qualification : " + qualification +"<br>");
		out.println("Languages :");
		for (String string : langs) {
			out.println(string);
		}

	}

}
