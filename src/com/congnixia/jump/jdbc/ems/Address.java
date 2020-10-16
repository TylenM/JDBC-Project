package com.congnixia.jump.jdbc.ems;

public class Address {

	private int id;
	private String address;
	private String state;
	public Address(int id, String address, String state) {
		super();
		this.id = id;
		this.address = address;
		this.state = state;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
