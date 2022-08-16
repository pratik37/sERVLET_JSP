<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee CRUD</title>
</head>
<body>
<h1>Add New Employee</h1>
<form action="AddNewEmployeeServlet" method ="post">
Employee Id: 
<input type ="text" name ="employeeid">
<br> <br>
Name :
<input type ="text" name ="employeename">
<br> <br>
 Salary :
 <input type ="text" name ="salary">
<br> <br>
<input type="submit" value="Add Employee">
</form>
</body>
</html>