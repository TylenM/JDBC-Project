package com.cognixia.jump.jdbc.ems.models;

import java.util.List;

public class Address {

	private int address_id;
	private String address;
	private String state;
	
	public Address(int address_id, String address, String state) {
		super();
		this.address_id = address_id;
		this.address = address;
		this.state = state;
	}
	
	public int getAddress_id() {
		return address_id;
	}
	
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
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
	
	public static void tableView(List<Address> addressList) {
		System.out.println("\nADDRESS TABLE:\n");
		System.out.println(" =======================================================================");
		System.out.println("| address_id	| address					| state	|");
		System.out.println(" =======================================================================");
		for(Address add: addressList) {
			System.out.println(printAddress(add));
			System.out.println(" -----------------------------------------------------------------------");
		}
		System.out.println("");
	}
	
	public static void tableSingleDepartment(Address address) {
		System.out.println("\nADDRESS TABLE:\n");
		System.out.println(" =======================================================================");
		System.out.println("| address_id	| address					| state	|");
		System.out.println(" =======================================================================");
		System.out.println(printAddress(address));
		System.out.println(" -----------------------------------------------------------------------");
		System.out.println("");
	}
	
	private static String printAddress(Address address) {
		String newString = "| " + address.getAddress_id() + "		| " + address.getAddress();
		if(address.getAddress().length() < 30) {
			newString += "			| ";
		} else if(address.getAddress().length() < 35) {
			newString += "		| ";
		} else {
			newString += "	| ";
		}
		newString += address.getState() + "	|";
		return newString;
	}
}
