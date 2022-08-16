package com.mindgate.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mindgate.pojo.Employee;
import com.mindgate.service.EmployeeService;
import com.mindgate.service.EmployeeServiceInterface;
@WebServlet("/ActionServlet")
public class ActionServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int employeeId;
	employeeId = Integer.valueOf(request.getParameter("action"));
	PrintWriter out = response.getWriter();
	out.println("Employee Id :: "+ employeeId);
	EmployeeServiceInterface employeeServiceInterface = new EmployeeService();
	String choice = request.getParameter("operation");
	switch (choice) {
	case "Delete" :
		boolean result = employeeServiceInterface.deleteEmployeeByEmployeeId(employeeId);
		if (result) {
			response.sendRedirect("index.jsp");
		} else {
			out.println("Delete failed");

		}
		break;
	case "Update" :
		Employee employee = employeeServiceInterface.getEmployeeByEmployeeId(employeeId);
		System.out.println(employee);
		HttpSession session = request.getSession();
		session.setAttribute("emp", employee);
		response.sendRedirect("updateemployee.jsp");
		break;
	}
	}

}























































