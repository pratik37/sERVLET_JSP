package com.mindgate.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LifeCycleServlet")
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LifeCycleServlet() {
        super();
    }
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() of servlet");
	}
	public void destroy() {
		System.out.println("destroy() of servlet");
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
	response.setContentType("text/html");
	out.println("<h1>service() of servlet</h1>");
	out.println("<h2>service() of servlet</h2>");
	out.println("<h3>service() of servlet</h3>");
	out.println("<h4>service() of servlet</h4>");
		//System.out.println("service() of servlet");
	}
}
