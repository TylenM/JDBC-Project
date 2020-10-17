package com.cognixia.jump.jdbc.ems.models;

public class Department {

	private int id;
	private int company_id;
	private String name;
	private String phone_extension;
	private double budget;
	public Department(int id, int company_id, String name, String phone_extension, double budget) {
		super();
		this.id = id;
		this.company_id = company_id;
		this.name = name;
		this.phone_extension = phone_extension;
		this.budget = budget;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getPhone_extension() {
		return phone_extension;
	}
	public void setPhone_extension(String phone_extension) {
		this.phone_extension = phone_extension;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", company_id=" + company_id + ", name=" + name + ", phone_extension="
				+ phone_extension + ", budget=" + budget + "]";
	}
	
	
	
	
}
