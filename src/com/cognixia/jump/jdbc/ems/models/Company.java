package com.cognixia.jump.jdbc.ems.models;

import java.util.List;

public class Company {

	private int company_id;
	private String name;
	
	public Company(int company_id, String name) {
		super();
		this.company_id = company_id;
		this.name = name;
	}
	
	public int getCompany_id() {
		return company_id;
	}
	
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void tableView(List<Company> compList) {
		System.out.println("\nCOMPANY TABLE:\n");
		System.out.println(" =======================================");
		System.out.println("| company_id	| name			|");
		System.out.println(" =======================================");
		for(Company comp: compList) {
			System.out.println(printCompany(comp));
			System.out.println(" ---------------------------------------");
		}
		System.out.println("");
	}
	
	public static void tableSingleDepartment(Company comp) {
		System.out.println("\nCOMPANY TABLE:\n");
		System.out.println(" =======================================");
		System.out.println("| company_id	| name				|");
		System.out.println(" =======================================");
		System.out.println(printCompany(comp));
		System.out.println(" ---------------------------------------");
		System.out.println("");
	}
	
	private static String printCompany(Company comp) {
		String newString = "| " + comp.getCompany_id() + "		| " + comp.getName();
		if(comp.getName().length() < 6) {
			newString += "			|";
		} else if(comp.getName().length() < 14) {
			newString += "		|";
		} else {
			newString += "	|";
		}
		return newString;
	}
	
}
