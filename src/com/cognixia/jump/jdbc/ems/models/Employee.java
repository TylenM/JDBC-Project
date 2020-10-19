package com.cognixia.jump.jdbc.ems.models;

import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cognixia.jump.jdbc.ems.implementations.EmployeeImp;
import com.cognixia.jump.jdbc.ems.interfaces.EmployeeDAO;

public class Employee {
	
	private int employee_id;
	private String first_name;
	private String last_name;
	private Date date_of_birth;
	private String email;
	private String phone;
	private double salary;
	private int department_id;
	private int address_id;
	private int company_id;
	
	private static EmployeeDAO eDAO = new EmployeeImp();
	
	public Employee(int employee_id, String first_name, String last_name, Date date_of_birth, String email,
			String phone, double salary, int department_id, int address_id, int company_id) {
		super();
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.date_of_birth = date_of_birth;
		this.email = email;
		this.phone = phone;
		this.salary = salary;
		this.department_id = department_id;
		this.address_id = address_id;
		this.company_id = company_id;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", date_of_birth=" + date_of_birth + ", email=" + email + ", phone=" + phone + ", salary=" + salary
				+ ", department_id=" + department_id + ", address_id=" + address_id + ", company_id=" + company_id
				+ "]";
	}
	
	public static void tableView() {
		System.out.println("\nEMPLOYEE TABLE:\n");
		System.out.println(" =======================================================================================================================================================================================");
		System.out.println("| employee_id	| first_name	| last_name	| date_of_birth	| email					| phone		| salary	| department_id	| address_id	| company_id	|");
		System.out.println(" =======================================================================================================================================================================================");
		for(Employee emp: eDAO.getAllEmployees()) {
			System.out.println(printEmployee(emp));
			System.out.println(" ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}
		System.out.println("");
	}
	
	public static void tableViewSingleEmployee(Employee emp) {
		System.out.println("\nEMPLOYEE TABLE:\n");
		System.out.println(" =======================================================================================================================================================================================");
		System.out.println("| employee_id	| first_name	| last_name	| date_of_birth	| email					| phone		| salary	| department_id	| address_id	| company_id	|");
		System.out.println(" =======================================================================================================================================================================================");
		System.out.println(printEmployee(emp));
		System.out.println(" ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("");
	}
	
	private static String printEmployee(Employee emp) {
		String newString = "| " + emp.getEmployee_id() + "		| " + emp.getFirst_name();
		if(emp.getFirst_name().length() < 6) {
			newString += "		| " + emp.getLast_name();
		} else {
			newString += "	| " + emp.getLast_name();
		}
		if(emp.getLast_name().length() < 6) {
			newString += "		| " + emp.getDate_of_birth() + "	| " + emp.getEmail();
		} else {
			newString += "	| " + emp.getDate_of_birth() + "	| " + emp.getEmail();
		}
		if(emp.getEmail().length() < 14) {
			newString += "				| ";
		} else if(emp.getEmail().length() < 22) {
			newString += "			| ";
		} else if(emp.getEmail().length() < 30) {
			newString += "		| ";
		} else {
			newString += "	| ";
		}
		newString += emp.getPhone() + "	| " + emp.getSalary();
		if(emp.getSalary() < 1000) {
			newString  += "		| ";
		} else {
			newString  += "	| ";
		}
		newString += emp.getDepartment_id() + "		| " + emp.getAddress_id() + "		| " + emp.getCompany_id() + "		|";
		return newString;
	}
	
	
}
