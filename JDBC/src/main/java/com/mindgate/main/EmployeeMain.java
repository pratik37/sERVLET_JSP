package com.mindgate.main;

import java.util.Scanner;

import com.mindgate.pojo.Employee;
import com.mindgate.service.EmployeeService;
import com.mindgate.service.EmployeeServiceInterface;

public class EmployeeMain {
	public static void main(String[] args) {
		EmployeeServiceInterface employeeServiceInterface = new EmployeeService();
		Scanner scanner =new Scanner(System.in);
		
		int EmployeeId;
		String name  ;
		double salary;
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
		
			
		}
	}
	

