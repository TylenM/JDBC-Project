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

public class CompanyRunner {
	
	private static CompanyDAO cDAO = new CompanyImp();
	private static DepartmentDAO dDAO = new DepartmentImp();
	private static EmployeeDAO eDAO = new EmployeeImp();
	private static Scanner scan = new Scanner(System.in);
	
	public static void companyUpdate(Company comp) {
		Company.tableSingleDepartment(comp);
		
		System.out.println("Pick an option (A, B, or C):");
		System.out.println("------------------------");
		System.out.println("A - Edit Company Name.");
		System.out.println("B - Return to Company Table.");
		System.out.println("C - Return to Main Menu.");
		
		String newStr = scan.nextLine();
		
		while(!(newStr.equalsIgnoreCase("A") || newStr.equalsIgnoreCase("B") || newStr.equalsIgnoreCase("C"))) {
			System.out.println("You have entered in: " + newStr + "\nPick an option (A, B, or C):");
			newStr = scan.nextLine();
		}
		
		int id = comp.getCompany_id();
		String name = comp.getName();
		
		if(newStr.equalsIgnoreCase("A")) {
			System.out.println("Enter the Company's Name: ");
			name = scan.nextLine();
			// NEEDS TO BE UNIQUE
		} else if(newStr.equalsIgnoreCase("B")) {
			Company.tableView(cDAO.getAllCompanies());
			Main.crudOption("company");
		} else if(newStr.equalsIgnoreCase("C")) {
			Main.mainMenu();
		}
		
		comp = new Company(
				id,
				name
		);
				
		cDAO.addCompany(comp);
		companyUpdate(comp);
	}
	
	public static void companyAdd() {
		Company comp = null;
		
		System.out.println("Enter the Company's Name: ");
		String name = scan.nextLine();
		
		comp = new Company(
				-1,
				name
		);
		
		if(cDAO.addCompany(comp)) {
			Company.tableView(cDAO.getAllCompanies());
			Main.crudOption("company");
		}
		companyAdd();
	}
	
	public static void companyRemove() {
		System.out.println("Enter in the id of the company you would like to delete: ");
		int id = InputValidation.validInterger();
		if(cDAO.deleteCompany(id)) {
			System.out.println("Company was deleted.");
		} else {
			System.out.println("Company was not deleted.");
		}
		Company.tableView(cDAO.getAllCompanies());
		Main.crudOption("company");
	}
	
	public static void companyListDepartments(int id) {
		Department.tableView(dDAO.getAllDepartmentInCompany(id));
		Main.crudOption("company");
	}
	
	public static void companyListEmployees(int id) {
		
	}
}
