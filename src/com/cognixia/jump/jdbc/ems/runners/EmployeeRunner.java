package com.cognixia.jump.jdbc.ems.runners;

import java.sql.Date;
import java.util.Scanner;

import com.cognixia.jump.jdbc.ems.InputValidation;
import com.cognixia.jump.jdbc.ems.Main;
import com.cognixia.jump.jdbc.ems.exceptions.PhoneNumberException;
import com.cognixia.jump.jdbc.ems.implementations.AddressImp;
import com.cognixia.jump.jdbc.ems.implementations.DepartmentImp;
import com.cognixia.jump.jdbc.ems.implementations.EmployeeImp;
import com.cognixia.jump.jdbc.ems.interfaces.AddressDAO;
import com.cognixia.jump.jdbc.ems.interfaces.DepartmentDAO;
import com.cognixia.jump.jdbc.ems.interfaces.EmployeeDAO;
import com.cognixia.jump.jdbc.ems.models.Department;
import com.cognixia.jump.jdbc.ems.models.Employee;

public class EmployeeRunner {
	
	private static EmployeeDAO eDAO = new EmployeeImp();
	private static AddressDAO aDAO = new AddressImp();
	private static DepartmentDAO dDAO = new DepartmentImp();
	private static Scanner scan = new Scanner(System.in);
	
	public static void employeeUpdate(Employee emp) {
		Employee.tableViewSingleEmployee(emp);
		
		System.out.println("Pick an option (A, B, C, D, E, F, G, H, I, J, or K):");
		System.out.println("------------------------");
		System.out.println("A - Edit First Name.");
		System.out.println("B - Edit Last Name.");
		System.out.println("C - Edit Date of Birth.");
		System.out.println("D - Edit Email.");
		System.out.println("E - Edit Phone Number.");
		System.out.println("F - Edit Salary.");
		System.out.println("G - Edit Department.");
		System.out.println("H - Edit Address.");
	
		System.out.println("J - Return to Employee Table.");
		System.out.println("K - Return to main menu.");
		
		String newStr = scan.nextLine();
		
		while(!(newStr.equalsIgnoreCase("A") || newStr.equalsIgnoreCase("B") || newStr.equalsIgnoreCase("C") || newStr.equalsIgnoreCase("D") || newStr.equalsIgnoreCase("E") || newStr.equalsIgnoreCase("F") || newStr.equalsIgnoreCase("G") || newStr.equalsIgnoreCase("H") || newStr.equalsIgnoreCase("I") || newStr.equalsIgnoreCase("J") || newStr.equalsIgnoreCase("K"))) {
			System.out.println("You have entered in: " + newStr + "\nPlease enter in either A, B, C, D, E, F, G, H, I, J, or K:");
			newStr = scan.nextLine();
		}
		
		String firstName = emp.getFirst_name();
		String lastName = emp.getLast_name();
		String dateOfBirth = emp.getDate_of_birth().toString();
		String email = emp.getEmail();
		String phone = emp.getPhone();
		double salary = emp.getSalary();
		int deptId = emp.getDepartment_id();
		int addressId = emp.getAddress_id();
		
		if(newStr.equalsIgnoreCase("A")) {
			System.out.println("Enter a First Name: ");
			firstName = scan.nextLine();
		} else if(newStr.equalsIgnoreCase("B")) {
			System.out.println("Enter a Last Name: ");
			lastName = scan.nextLine();
		} else if(newStr.equalsIgnoreCase("C")) {
			System.out.println("Enter employees Date of Birth (yyyy-mm-dd): ");
			dateOfBirth = InputValidation.isValidDate();		
		} else if(newStr.equalsIgnoreCase("D")) {
			email = InputValidation.isValidEmail();
			while(eDAO.checkEmployeeEmailExists(email)) {
				email = InputValidation.isValidEmail();
			}
		} else if(newStr.equalsIgnoreCase("E")) {
			phone = "";
			while(true) {
				try {
					System.out.println("Enter a phone number: ");
					phone = InputValidation.isValidPhoneNumber();
					while(eDAO.checkEmployeePhoneExists(phone)) {
						System.out.println("This number is in the database already. Please enter a new number: ");
						phone = InputValidation.isValidPhoneNumber();
					}
					break;
				} catch (PhoneNumberException e) {
					System.out.println(e.getMessage());
				}
			}
		} else if(newStr.equalsIgnoreCase("F")) {
			System.out.println("Enter employee's salary: ");
			salary = InputValidation.validDouble();
		} else if(newStr.equalsIgnoreCase("G")) {
			while(true) {
				System.out.println("Enter employee's department id: ");
				deptId = InputValidation.validInterger();
				if(eDAO.getEmployeeById(deptId) != null) {
					break;
				}
			}
		} else if(newStr.equalsIgnoreCase("H")) {
			while(true) {
				System.out.println("Enter employee's address id: ");
				addressId = InputValidation.validInterger();
				if(aDAO.getAddressById(addressId) != null) {
					break;
				}
			}
		} else if(newStr.equalsIgnoreCase("J")) {
			Employee.tableView(eDAO.getAllEmployees());
			Main.crudOption("employee");
		} else if(newStr.equalsIgnoreCase("K")) {
			Main.mainMenu();
		}
		emp = new Employee(
				emp.getEmployee_id(), 
				firstName, 
				lastName, 
				Date.valueOf(dateOfBirth), 
				email, 
				phone, 
				salary, 
				deptId,
				addressId
		);
		eDAO.updateEmployee(emp);
		employeeUpdate(emp);
	}
	
	public static void employeeAdd() {
		Employee emp = null;
		
		System.out.println("Enter a First Name: ");
		String firstName = scan.nextLine();
		
		System.out.println("Enter a Last Name: ");
		String lastName = scan.nextLine();
		
		System.out.println("Enter employees Date of Birth (yyyy-mm-dd): ");
		String dateOfBirth = InputValidation.isValidDate();		
		
		String email = InputValidation.isValidEmail();
		while(eDAO.checkEmployeeEmailExists(email)) {
			email = InputValidation.isValidEmail();
		}
		
		String phone ="";
		while(true) {
			try {
				System.out.println("Enter a phone number: ");
				phone = InputValidation.isValidPhoneNumber();
				while(eDAO.checkEmployeePhoneExists(phone)) {
					System.out.println("This number is in the database already. Please enter a new number: ");
					phone = InputValidation.isValidPhoneNumber();
				}
				break;
			} catch (PhoneNumberException e) {
				System.out.println(e.getMessage());
			}
		}
		
		System.out.println("Enter employee's salary: ");
		double salary = InputValidation.validDouble();
		
		int deptId = -1;
		while(true) {
			System.out.println("Enter employee's department id: ");
			deptId = InputValidation.validInterger();
			if(dDAO.getDepartmentById(deptId) != null) {
				break;
			}
		}
		
		int addressId = -1;
		while(true) {
			System.out.println("Enter employee's address id: ");
			addressId = InputValidation.validInterger();
			if(aDAO.getAddressById(addressId) != null) {
				break;
			}
		}
		
		emp = new Employee(
				-1, 
				firstName, 
				lastName, 
				Date.valueOf(dateOfBirth), 
				email, 
				phone, 
				salary, 
				deptId,
				addressId
		);
		
		if(eDAO.addEmployee(emp)) {
			Employee.tableView(eDAO.getAllEmployees());
			Main.crudOption("employee");
		}
		employeeAdd();
	}

	public static void employeeRemove() {
		System.out.println("Enter in the id of the employee you would like to delete: ");
		int id = InputValidation.validInterger();
		if(eDAO.deleteEmployee(id)) {
			System.out.println("Employee was deleted.");
		} else {
			System.out.println("Employee was not deleted.");
		}
		Employee.tableView(eDAO.getAllEmployees());
		Main.crudOption("employee");
	}
}
