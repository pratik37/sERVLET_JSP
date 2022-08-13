package com.mindgate.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NumbersServlet")
public class NumbersServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int number1=Integer.parseInt(request.getParameter("number1"));
		int number2=Integer.parseInt(request.getParameter("number2"));
		String choice = request.getParameter("oprtn"); 
		PrintWriter out = response.getWriter();
		
		switch (choice) {
		case "add":
			out.println("Addition of " + number1 +  "and" + number2  + "is" + (number1 + number2));
			break;
		case "Sub":
			out.println("Substraction of " + number1 +  "and" + number2  + "is" + (number1 - number2));

		default:
			System.out.println("Invalid choice");
			break;
		}
		}
	}
