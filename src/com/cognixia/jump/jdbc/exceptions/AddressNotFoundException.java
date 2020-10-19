package com.cognixia.jump.jdbc.exceptions;

public class AddressNotFoundException extends Exception{

	private static final long serialVersionUID = 1647360787994923664L;
		
	public AddressNotFoundException(String address) {
		super("Address " + address + " was not found." );
	}
	
}
