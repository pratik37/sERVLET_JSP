package com.mindgate.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mindgate.pojo.Employee;

public class EmployeeRepository implements EmployeeRepositoryInterface {
	private String driverName = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "system";
	private String password = "mindgate123";
	private List<Employee> employeeList;
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private static final String INSERT_EMPLOYEE = "insert into employee_details values(?,?,?)";
	private static final String SELECT_ALL_EMPLOYEES = "select * from employee_details";
	private static final String DELETE_EMPLOYEE = "delete from employee_details where employee_id = ?";
	private static final String UPDATE_EMPLOYEE = "Update employee_details set name = ?,salary = ? where employee_id = ?";
	private static final String SELECT_ONE_EMPLOYEE = "select * from employee_details where employee_id = ?";
    
	@Override
	public boolean addNewEmployee(Employee employee) {
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, user, password);
			preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE);
			preparedStatement.setInt(1, employee.getEmployeeId());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setDouble(3, employee.getSalary());
			int insertCount = preparedStatement.executeUpdate();
			if (insertCount > 0) {
				return true;

			}

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public List<Employee> getAllEmployees() {
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, user, password);
			preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES);
			resultSet = preparedStatement.executeQuery();
			employeeList = new ArrayList<>();
			while (resultSet.next()) {
				int employeeId = resultSet.getInt("employee_id");
				String name = resultSet.getString("name");
				double salary = resultSet.getDouble("salary");
				Employee employee = new Employee(employeeId, name, salary);
				employeeList.add(employee);

			}
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return employeeList;
	}

	@Override
	public boolean deleteEmployeeByEmployeeId(int employeeId) {

		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, user, password);
			preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE);
			preparedStatement.setInt(1, employeeId);
//			preparedStatement.setInt(1, employee.getEmployeeId());
//			preparedStatement.setString(2, employee.getName());
//			preparedStatement.setDouble(3, employee.getSalary());
			int insertCount = preparedStatement.executeUpdate();
			if (insertCount > 0) {
				return true;

			}

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return false;
	}

	public boolean updateEmployee(Employee employee) {
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, user, password);
			preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE);
			preparedStatement.setInt(3, employee.getEmployeeId());
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setDouble(2, employee.getSalary());
			int insertCount = preparedStatement.executeUpdate();
			if (insertCount > 0) {
				return true;

			}

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public Employee getEmployeeByEmployeeId(int employeeId) {
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, user, password);
			preparedStatement = connection.prepareStatement(SELECT_ONE_EMPLOYEE);
			preparedStatement.setInt(1, employeeId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int empId = resultSet.getInt("employee_id");
				String name = resultSet.getString("name");
				double salary = resultSet.getDouble("salary");
				Employee employee = new Employee(empId, name, salary);
				return employee;

			}
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return null;
	}

}
