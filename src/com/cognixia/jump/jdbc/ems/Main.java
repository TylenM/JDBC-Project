package com.cognixia.jump.jdbc.ems;


import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.cognixia.jump.jdbc.ems.exceptions.PhoneNumberException;
import com.cognixia.jump.jdbc.ems.implementations.AddressImp;
import com.cognixia.jump.jdbc.ems.implementations.CompanyImp;
import com.cognixia.jump.jdbc.ems.implementations.DepartmentImp;
import com.cognixia.jump.jdbc.ems.implementations.EmployeeImp;
import com.cognixia.jump.jdbc.ems.interfaces.AddressDAO;
import com.cognixia.jump.jdbc.ems.interfaces.CompanyDAO;
import com.cognixia.jump.jdbc.ems.interfaces.DepartmentDAO;
import com.cognixia.jump.jdbc.ems.interfaces.EmployeeDAO;
import com.cognixia.jump.jdbc.ems.models.Address;
import com.cognixia.jump.jdbc.ems.models.Company;
import com.cognixia.jump.jdbc.ems.models.Department;
import com.cognixia.jump.jdbc.ems.models.Employee;
import com.cognixia.jump.jdbc.ems.runners.AddressRunner;
import com.cognixia.jump.jdbc.ems.runners.CompanyRunner;
import com.cognixia.jump.jdbc.ems.runners.DepartmentRunner;
import com.cognixia.jump.jdbc.ems.runners.EmployeeRunner;

public class Main {
	
	private static Scanner scan = new Scanner(System.in);
	
	private static EmployeeDAO eDAO = new EmployeeImp();
	private static DepartmentDAO dDAO = new DepartmentImp();
	private static AddressDAO aDAO = new AddressImp();
	private static CompanyDAO cDAO = new CompanyImp();

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
			Employee.tableView(eDAO.getAllEmployees());
			crudOption("employee");
		} else if(newStr.equalsIgnoreCase("B")) {
			Department.tableView(dDAO.getAllDepartments());
			crudOption("department");
		} else if(newStr.equalsIgnoreCase("C")) {
			Company.tableView(cDAO.getAllCompanies());
			crudOption("company");
		} else if(newStr.equalsIgnoreCase("D")) {
			Address.tableView(aDAO.getAllAddresses());
			crudOption("address");
		} else if(newStr.equalsIgnoreCase("E")) {
			System.out.println("THANK YOU FOR USING THIS APPLICATION!!!");
			System.exit(0);
		}
		return;
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
			System.out.println("D - List all the employees with this " + option + ".");
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
				List<Employee> empList = eDAO.getAllEmployees();
				if(empList.size() == 0) {
					System.out.println("INFO: There are no employees to view.");
					Employee.tableView(empList);
					crudOption("employee");
				}
				while(true) {
					System.out.println("Enter in the id of the person to view or edit");
					int empId = InputValidation.validInterger();
					Employee emp = eDAO.getEmployeeById(empId);
					if(emp != null) {
						EmployeeRunner.employeeUpdate(emp);											
					}
				}
			} else if(newStr.equalsIgnoreCase("B")) {
				if(cDAO.getAllCompanies() == null) {
					System.out.println("A company needs to exist to add an employee.");
				} else if(dDAO.getAllDepartments() == null) {
					System.out.println("A department needs to exist to add an employee.");
				} else if(aDAO.getAllAddresses() == null) {
					System.out.println("An address needs to exist to add an employee ");
				} else {
					EmployeeRunner.employeeAdd();					
				}
			} else if(newStr.equalsIgnoreCase("C")) {
				EmployeeRunner.employeeRemove();
			} else if(newStr.equalsIgnoreCase("D")) {
				mainMenu();
			}
		} else if(option.equals("department")) {
			if(newStr.equalsIgnoreCase("A")) {
				List<Department> deptList = dDAO.getAllDepartments();
				if(deptList.size() == 0) {
					System.out.println("INFO: There are no departments to view.");
					Department.tableView(deptList);
					crudOption("department");
				}
				while(true) {
					System.out.println("Enter in the id of the department to view or edit");
					int deptId = InputValidation.validInterger();
					Department dept = dDAO.getDepartmentById(deptId);
					if(dept != null) {
						DepartmentRunner.departmentUpdate(dept);										
					}
				}
			} else if(newStr.equalsIgnoreCase("B")) {
				DepartmentRunner.departmentAdd();
			} else if(newStr.equalsIgnoreCase("C")) {
				DepartmentRunner.departmentRemove();
			} else if(newStr.equalsIgnoreCase("D")) {
				List<Department> deptList = dDAO.getAllDepartments();
				if(deptList.size() == 0) {
					System.out.println("INFO: There are no departments to view.");
					Department.tableView(deptList);
					crudOption("department");
				}
				while(true) {
					System.out.println("Enter in the id of the department to view or edit");
					int deptId = InputValidation.validInterger();
					Department dept = dDAO.getDepartmentById(deptId);
					if(dept != null) {
						DepartmentRunner.departmentListEmployees(deptId);										
					}
				}
			} else if(newStr.equalsIgnoreCase("E")) {
				mainMenu();
			}
		} else if(option.equals("address")) {
			if(newStr.equalsIgnoreCase("A")) {
				List<Address> addList = aDAO.getAllAddresses();
				if(addList.size() == 0) {
					System.out.println("INFO: There are no addresses to view.");
					Address.tableView(addList);
					crudOption("address");
				}
				while(true) {
					System.out.println("Enter in the id of the address to view or edit");
					int addId = InputValidation.validInterger();
					Address add = aDAO.getAddressById(addId);
					if(add != null) {
						AddressRunner.addressUpdate(add);									
					}
				}
			} else if(newStr.equalsIgnoreCase("B")) {
				AddressRunner.addressAdd();
			} else if(newStr.equalsIgnoreCase("C")) {
				AddressRunner.addressRemove();
			} else if(newStr.equalsIgnoreCase("D")) {
				List<Address> addList = aDAO.getAllAddresses();
				if(addList.size() == 0) {
					System.out.println("INFO: There are no address to view.");
					Address.tableView(addList);
					crudOption("address");
				}
				while(true) {
					System.out.println("Enter in the id of the address to view or edit");
					int addId = InputValidation.validInterger();
					Address add = aDAO.getAddressById(addId);
					if(add != null) {
						AddressRunner.addressListEmployees(addId);								
					}
				}
			} else if(newStr.equalsIgnoreCase("E")) {
				mainMenu();
			}
		} else {
			if(newStr.equalsIgnoreCase("A")) {
				List<Company> compList = cDAO.getAllCompanies();
				if(compList.size() == 0) {
					System.out.println("INFO: There are no companies to view.");
					Company.tableView(compList);
					crudOption("company");
				}
				while(true) {
					System.out.println("Enter in the id of the company to view or edit");
					int compId = InputValidation.validInterger();
					Company comp = cDAO.getCompanyById(compId);
					if(comp != null) {
						CompanyRunner.companyUpdate(comp);								
					}
				}
			} else if(newStr.equalsIgnoreCase("B")) {
				CompanyRunner.companyAdd();
			} else if(newStr.equalsIgnoreCase("C")) {
				CompanyRunner.companyRemove();
			} else if(newStr.equalsIgnoreCase("D")) {
				List<Company> compList = cDAO.getAllCompanies();
				if(compList.size() == 0) {
					System.out.println("INFO: There are no companies to view.");
					Company.tableView(compList);
					crudOption("company");
				}
				while(true) {
					System.out.println("Enter in the id of the company to view or edit");
					int compId = InputValidation.validInterger();
					Company comp = cDAO.getCompanyById(compId);
					if(comp != null) {
						CompanyRunner.companyListDepartments(compId);									
					}
				}
			} else if(newStr.equalsIgnoreCase("E")) {
//				CompanyRunner.companyListEmployees();
			} else if(newStr.equalsIgnoreCase("F")) {
				mainMenu();
			}
		}
	}
}
