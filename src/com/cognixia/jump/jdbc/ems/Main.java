package com.cognixia.jump.jdbc.ems;


import java.sql.Date;
import java.util.Scanner;

import com.cognixia.jump.jdbc.ems.exceptions.PhoneNumberException;
import com.cognixia.jump.jdbc.ems.implementations.EmployeeImp;
import com.cognixia.jump.jdbc.ems.interfaces.EmployeeDAO;
import com.cognixia.jump.jdbc.ems.models.Employee;

public class Main {
	
	private static Scanner scan = new Scanner(System.in);
	
	private static EmployeeDAO eDAO = new EmployeeImp();

	public static void main(String[] args) {
		
		mainMenu();
	}
	
	public static void mainMenu() {
		System.out.println("Pick an option (A, B, C, D, or E):");
		System.out.println("------------------------");
		System.out.println("A - View Employees");
		System.out.println("B - View Departments");
		System.out.println("C - View Companies");
		System.out.println("D - View Addresses");
		System.out.println("E - Exit Program");
		
		String newStr = scan.nextLine();
		
		while(!(newStr.equalsIgnoreCase("A") || newStr.equalsIgnoreCase("B") || newStr.equalsIgnoreCase("C") || newStr.equalsIgnoreCase("D") || newStr.equalsIgnoreCase("E"))) {
			System.out.println("You have entered in: " + newStr + "\nPlease enter in either A, B, C, D, or E:");
			newStr = scan.nextLine();
		}
		
		if(newStr.equalsIgnoreCase("A")) {
			Employee.tableView();
			crudOption("employee");
		} else if(newStr.equalsIgnoreCase("B")) {
			System.out.println("Viewing Departments");
			crudOption("department");
		} else if(newStr.equalsIgnoreCase("C")) {
			System.out.println("Viewing Companies");
			crudOption("company");
		} else if(newStr.equalsIgnoreCase("D")) {
			System.out.println("Viewing Addresses");
			crudOption("address");
		} else if(newStr.equalsIgnoreCase("E")) {
			System.out.println("THANK YOU FOR USING THIS APPLICATION!!!");
			System.exit(0);
		}
	}
	
	public static void crudOption(String option) {
		System.out.println("Pick an option (A, B, C, or D):");
		System.out.println("-------------------------------");
		System.out.println("A - View/Edit an " + option + ".");
		System.out.println("B - Add an " + option + ".");
		System.out.println("C - Remove an " + option + ".");
		if(option.equals("department")) {
			System.out.println("D - List all the employees in a " + option + ".");
			System.out.println("E - Return to main menu.");
		} else if(option.equals("company")) {
			System.out.println("D - List all the departments in the " + option + ".");
			System.out.println("E - List all the employees in the " + option + ".");
			System.out.println("F - Return to main menu.");
		} else if(option.equals("address")) {
			System.out.println("D - List all the employees this " + option + ".");
			System.out.println("E - Return to main menu.");
		} else {
			System.out.println("D - Return to main menu.");
		}
		
		String newStr = scan.nextLine();
		
		
		if(option.equals("employee")) {
			while(!(newStr.equalsIgnoreCase("A") || newStr.equalsIgnoreCase("B") || newStr.equalsIgnoreCase("C") || newStr.equalsIgnoreCase("D"))) {
				System.out.println("You have entered in: " + newStr + "\nPlease enter in either A, B, C, or D:");
				newStr = scan.nextLine();
			}
		} else if(option.equals("company")) {
			while(!(newStr.equalsIgnoreCase("A") || newStr.equalsIgnoreCase("B") || newStr.equalsIgnoreCase("C") || newStr.equalsIgnoreCase("D") || newStr.equalsIgnoreCase("E") || newStr.equalsIgnoreCase("F"))) {
				System.out.println("You have entered in: " + newStr + "\nPlease enter in either A, B, C, D, E, or F:");
				newStr = scan.nextLine();
			}
		} else {
			while(!(newStr.equalsIgnoreCase("A") || newStr.equalsIgnoreCase("B") || newStr.equalsIgnoreCase("C") || newStr.equalsIgnoreCase("D") || newStr.equalsIgnoreCase("E"))) {
				System.out.println("You have entered in: " + newStr + "\nPlease enter in either A, B, C, D, or E:");
				newStr = scan.nextLine();
			}
		}
		
		
		if(option.equals("employee")) {
			if(newStr.equalsIgnoreCase("A")) {
				if(eDAO.getAllEmployees().size() == 0) {
					System.out.println("INFO: There are no employees to view.");
					Employee.tableView();
					crudOption("employee");
				}
				while(true) {
					System.out.println("Enter in the id of the person to view or edit");
					int empId = InputValidation.validInterger();
					Employee emp = eDAO.getEmployeeById(empId);
					if(emp != null) {
						employeeUpdate(emp);											
					}
				}
			} else if(newStr.equalsIgnoreCase("B")) {
				// check to make sure department and company and address exits.
				employeeAdd();
			} else if(newStr.equalsIgnoreCase("C")) {
				// check to make sure employee exists.
				employeeRemove();
			} else if(newStr.equalsIgnoreCase("D")) {
				mainMenu();
			}
		} else if(option.equals("department")) {
			if(newStr.equalsIgnoreCase("A")) {
				departmentUpdate();
			} else if(newStr.equalsIgnoreCase("B")) {
				departmentAdd();
			} else if(newStr.equalsIgnoreCase("C")) {
				departmentRemove();
			} else if(newStr.equalsIgnoreCase("D")) {
				departmentListEmployees();
			} else if(newStr.equalsIgnoreCase("F")) {
				mainMenu();
			}
		} else if(option.equals("address")) {
			if(newStr.equalsIgnoreCase("A")) {
				addressUpdate();
			} else if(newStr.equalsIgnoreCase("B")) {
				addressAdd();
			} else if(newStr.equalsIgnoreCase("C")) {
				addressRemove();
			} else if(newStr.equalsIgnoreCase("D")) {
				addressListEmployees();
			} else if(newStr.equalsIgnoreCase("F")) {
				mainMenu();
			}
		} else {
			if(newStr.equalsIgnoreCase("A")) {
				companyUpdate();
			} else if(newStr.equalsIgnoreCase("B")) {
				companyAdd();
			} else if(newStr.equalsIgnoreCase("C")) {
				companyRemove();
			} else if(newStr.equalsIgnoreCase("D")) {
				companyListDepartments();
			} else if(newStr.equalsIgnoreCase("E")) {
				companyListEmployees();
			} else if(newStr.equalsIgnoreCase("F")) {
				mainMenu();
			}
		}
	}
	
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
		System.out.println("I - Edit Company.");
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
		int companyId = emp.getCompany_id();
		
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
			System.out.println("Enter employee's department id: ");
			deptId = InputValidation.validInterger();
		} else if(newStr.equalsIgnoreCase("H")) {
			System.out.println("Enter employee's address id: ");
			addressId = InputValidation.validInterger();
		} else if(newStr.equalsIgnoreCase("I")) {
			System.out.println("Enter employee's company id: ");
			companyId = InputValidation.validInterger();
		} else if(newStr.equalsIgnoreCase("J")) {
			Employee.tableView();
			crudOption("employee");
		} else if(newStr.equalsIgnoreCase("K")) {
			mainMenu();
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
				addressId, 
				companyId
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
		
		System.out.println("Enter employee's department id: ");
		int deptId = InputValidation.validInterger();
		
		System.out.println("Enter employee's address id: ");
		int addressId = InputValidation.validInterger();
		
		System.out.println("Enter employee's company id: ");
		int companyId = InputValidation.validInterger();
		
		emp = new Employee(
				-1, 
				firstName, 
				lastName, 
				Date.valueOf(dateOfBirth), 
				email, 
				phone, 
				salary, 
				deptId,
				addressId, 
				companyId
		);
		
		if(eDAO.addEmployee(emp)) {
			Employee.tableView();
			crudOption("employee");
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
		Employee.tableView();
		crudOption("employee");
	}
	
	public static void departmentUpdate() {
		
	}
	
	public static void departmentAdd() {
		
	}
	
	public static void departmentRemove() {
		
	}
	
	public static void departmentListEmployees() {
		
	}
	
	public static void addressUpdate() {
		
	}
	
	public static void addressAdd() {
		
	}
	
	public static void addressRemove() {
		
	}
	
	public static void addressListEmployees() {
		
	}
	
	public static void companyUpdate() {
		
	}
	
	public static void companyAdd() {
		
	}
	
	public static void companyRemove() {
		
	}
	
	public static void companyListDepartments() {
		
	}
	
	public static void companyListEmployees() {
		
	}
}
