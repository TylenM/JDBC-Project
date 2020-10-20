package com.cognixia.jump.jdbc.ems.models;

import java.util.List;

public class Department {

	private int department_id;
	private String name;
	private double budget;
	private String phone_extension;
	private int company_id;
	
	public Department(int department_id, String name, double budget, String phone_extension, int company_id) {
		super();
		this.department_id = department_id;
		this.name = name;
		this.budget = budget;
		this.phone_extension = phone_extension;
		this.company_id = company_id;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public String getPhone_extension() {
		return phone_extension;
	}

	public void setPhone_extension(String phone_extension) {
		this.phone_extension = phone_extension;
	}

	public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
		
	public static void tableView(List<Department> deptList) {
		System.out.println("\nDEPARTMENT TABLE:\n");
		System.out.println(" =======================================================================================================");
		System.out.println("| department_id	| name				| budget 	| phone_extension	| company_id	|");
		System.out.println(" =======================================================================================================");
		for(Department dept: deptList) {
			System.out.println(printDepartment(dept));
			System.out.println(" -------------------------------------------------------------------------------------------------------");
		}
		System.out.println("");
	}
	
	public static void tableSingleDepartment(Department dept) {
		System.out.println("\nDEPARTMENT TABLE:\n");
		System.out.println(" =======================================================================================================");
		System.out.println("| department_id	| name				| budget 	| phone_extension	| company_id	|");
		System.out.println(" =======================================================================================================");
		System.out.println(printDepartment(dept));
		System.out.println(" -------------------------------------------------------------------------------------------------------");
		System.out.println("");
	}
	
	private static String printDepartment(Department dept) {
		String newString = "| " + dept.getDepartment_id() + "		| " + dept.getName();
		if(dept.getName().length() < 6) {
			newString += "				| ";
		} else if(dept.getName().length() < 15) {
			newString += "			| ";
		} else {
			newString += "	| ";
		}
		newString += dept.getBudget();
		if(dept.getBudget() < 1000) {
			newString += "		| ";
		} else {
			newString += "	| ";
		}
		newString += dept.getPhone_extension() + "			| " + dept.getCompany_id() + "		|";
		return newString;
	}
}
