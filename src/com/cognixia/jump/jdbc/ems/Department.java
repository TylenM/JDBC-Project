package com.cognixia.jump.jdbc.ems;

public class Department {
	
	// create attributes that match columns in table
	private int id;
	private String name;
	private String phone;
	
	public Department() {
		this(-1, "N/A", "N/A");
	}
	
	public Department(int id, String name, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}
	
}
