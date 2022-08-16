<%@page import="com.mindgate.pojo.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.mindgate.repository.EmployeeRepository"%>
<%@page import="com.mindgate.repository.EmployeeRepositoryInterface"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee CRUD</title>
</head>
<body>
	<h3>All Employees</h3>
	 <%! EmployeeRepositoryInterface employeeRepositoryInterface= new EmployeeRepository(); %>
     <%
     List<Employee> allEmployee = employeeRepositoryInterface.getAllEmployees();
     %>
     <form action="ActionServlet" method="post">
     <table border="1" style="width:100%">
     <thead>
     <td>Employee_Id</td>
     <td>Name</td>
     <td>Salary</td>
     <td>Action</td>
     </thead>
     <%
     for(Employee employee : allEmployee){
     %>
     <tr>
     <td><%= employee.getEmployeeId() %></td>
     <td><%= employee.getName() %></td>
     <td><%= employee.getSalary() %></td>
     <td>
     <input type="radio" name="action" value="<%= employee.getEmployeeId() %>"> 
     </td>
     </tr>
     <%
     }
     %>
     
     </table>
     <br> <input type="submit" value="Delete" name="operation">
      <br> <input type="submit" value="Update" name="operation">
     </form>
     <form action="newEmployee.jsp">
    <input type ="submit" value = "Add new">
     
     </form>

</body>

</html>