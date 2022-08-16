package com.mindgate.main;

import java.util.List;
import java.util.Scanner;

import com.mindgate.pojo.Employee;
import com.mindgate.service.EmployeeService;
import com.mindgate.service.EmployeeServiceInterface;

public class EmployeeCRUDMain {
	public static void main(String[] args) {
		EmployeeServiceInterface employeeServiceInterface = new EmployeeService();
		int choice;
		String ContinueChoice;
		int EmployeeId;
		String name  ;
		double salary;
		Scanner scanner = new Scanner(System.in);
		List<Employee> AllEmployees;
		do {
			System.out.println("1. Add New Employee");
			System.out.println("2. Update Employee");
			System.out.println("3. Delete Employee");
			System.out.println("4. Select One Employee");
			System.out.println("5. Select All Employees");
			System.out.println("Enter Your Choice ::");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Employee Id");
				EmployeeId = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter Name");
				name = scanner.nextLine();
				scanner.nextLine();
				
				System.out.println("Enter Salary");
				salary = scanner.nextDouble();
				
				
				Employee employee = new Employee(EmployeeId, name, salary);
				
				boolean result = employeeServiceInterface.addNewEmployee(employee);
				if (result) {
					System.out.println("Insert Successfull");}
					else {
						System.out.println("Insert Failed");
					}
			
				break;
			case 2:
			 {
					System.out.println("set name to");
					name = scanner.nextLine();
					scanner.nextLine();

					System.out.println("emp id");
					EmployeeId = scanner.nextInt();
					scanner.nextLine();

					result = employeeServiceInterface.updateEmployee(name, EmployeeId);

					if (result) {
						System.out.println("update succesfull");
					} else {
						System.out.println("update failed");
					}
					break;

				}

			case 5:
				AllEmployees = employeeServiceInterface.getAllEmployees();
				for (Employee e : AllEmployees) {
					System.out.println(e);	
				}
				break;
			case 3:
				System.out.println("Enter Employee Id");
				EmployeeId = scanner.nextInt();
				result = employeeServiceInterface.deleteEmployeeByEmployeeId(EmployeeId);
				if (result) {
					System.out.println("Delete Successfull");
					
				}else {
					System.out.println("Delete Failed");
				}
				break;

			default:
				System.out.println("Invalid choice");
				break;
			}
			System.out.println("Do you want to Continue ?");
			ContinueChoice = scanner.next();
			
		} while (ContinueChoice.equals("yes"));
	
	}

}
