package com.cognixia.jump.jdbc.ems.runners;

import java.util.Scanner;

import com.cognixia.jump.jdbc.ems.InputValidation;
import com.cognixia.jump.jdbc.ems.Main;
import com.cognixia.jump.jdbc.ems.implementations.CompanyImp;
import com.cognixia.jump.jdbc.ems.implementations.DepartmentImp;
import com.cognixia.jump.jdbc.ems.implementations.EmployeeImp;
import com.cognixia.jump.jdbc.ems.interfaces.CompanyDAO;
import com.cognixia.jump.jdbc.ems.interfaces.DepartmentDAO;
import com.cognixia.jump.jdbc.ems.interfaces.EmployeeDAO;
import com.cognixia.jump.jdbc.ems.models.Company;
import com.cognixia.jump.jdbc.ems.models.Department;
import com.cognixia.jump.jdbc.ems.models.Employee;

public class DepartmentRunner {

	private static DepartmentDAO dDAO = new DepartmentImp();
	private static CompanyDAO cDAO = new CompanyImp();
	private static EmployeeDAO eDAO = new EmployeeImp();
	private static Scanner scan = new Scanner(System.in);
	
	public static void departmentUpdate(Department dept) {
		Department.tableSingleDepartment(dept);
		
		System.out.println("Pick an option (A, B, C, D, E, or F):");
		System.out.println("------------------------");
		System.out.println("A - Edit Name.");
		System.out.println("B - Edit Budget.");
		System.out.println("C - Edit Phone Extension.");
		System.out.println("D - Edit Company.");
		System.out.println("E - Return to Company Table.");
		System.out.println("F - Return to Main Menu.");
		
		String newStr = scan.nextLine();
		
		while(!(newStr.equalsIgnoreCase("A") || 
				newStr.equalsIgnoreCase("B") || 
				newStr.equalsIgnoreCase("C") || 
				newStr.equalsIgnoreCase("D") || 
				newStr.equalsIgnoreCase("E") || 
				newStr.equalsIgnoreCase("F"))) {
			
			System.out.println("You have entered in: " + newStr + "\nPick an option (A, B, C, D, E, or F):");
			newStr = scan.nextLine();
		}
		
		int id = dept.getDepartment_id();
		String name = dept.getName();
		double budget = dept.getBudget();
		String phoneExtension = dept.getPhone_extension();
		int compId = dept.getCompany_id();
		
		if(newStr.equalsIgnoreCase("A")) {
			System.out.println("Enter the Department's Name: ");
			name = scan.nextLine();
		} else if(newStr.equalsIgnoreCase("B")) {
			System.out.println("Enter the budget: ");
			budget = InputValidation.validDouble();
		} else if(newStr.equalsIgnoreCase("C")) {
			while(true) {
				System.out.println("Enter the phone extension: ");
				phoneExtension = scan.nextLine();
				if(phoneExtension.matches("[0-9]{3}")) {
					break;
				}
			}
		} else if(newStr.equalsIgnoreCase("D")) {
			Company.tableView(cDAO.getAllCompanies());
			while(true) {
				System.out.println("Pick a company id in the list above: ");
				compId = InputValidation.validInterger();
				if(cDAO.getCompanyById(compId) != null) {
					break;
				}
			}
		} else if(newStr.equalsIgnoreCase("E")) {
			Department.tableView(dDAO.getAllDepartments());
			Main.crudOption("department");
		} else if(newStr.equalsIgnoreCase("F")) {
			Main.mainMenu();
		}
			
		dept = new Department(
				id,
				name,
				budget,
				phoneExtension,
				compId
		);
		
		dDAO.updateDepartment(dept);
		departmentUpdate(dept);
	}

	public static void departmentAdd() {
		Department dept = null;
		
		System.out.println("Enter the Department's Name: ");
		String name = scan.nextLine();
		
		System.out.println("Enter the budget: ");
		double budget = InputValidation.validDouble();
		
		String phoneExtension = "";
		while(true) {
			System.out.println("Enter the phone extension: ");
			phoneExtension = scan.nextLine();
			if(phoneExtension.matches("[0-9]{3}")) {
				break;
			}
		}
		
		Company.tableView(cDAO.getAllCompanies());
		int compId = -1;
		while(true) {
			System.out.println("Pick a company id in the list above: ");
			compId = InputValidation.validInterger();
			if(cDAO.getCompanyById(compId) != null) {
				break;
			}
		}
		
		dept = new Department(
				compId,
				name,
				budget,
				phoneExtension,
				compId
		);
		
		if(dDAO.addDepartment(dept)) {
			Department.tableView(dDAO.getAllDepartments());
			Main.crudOption("department");
		}
		departmentAdd();
	}
	
	public static void departmentRemove() {
		System.out.println("Enter in the id of the department you would like to delete: ");
		int id = InputValidation.validInterger();
		if(dDAO.deleteDepartment(id)) {
			System.out.println("Department was deleted.");
		} else {
			System.out.println("Department was not deleted.");
		}
		Department.tableView(dDAO.getAllDepartments());
		Main.crudOption("department");
	}
	
	public static void departmentListEmployees(int id) {
		Employee.tableView(eDAO.getAllEmployeesInDeptWithId(id));
		Main.crudOption("department");
	}
	
}
