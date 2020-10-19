package com.cognixia.jump.jdbc.ems.exceptions;

public class PhoneNumberException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3323307865388610553L;

	private static String p;
	
	public PhoneNumberException(String phone) {
		super("Your phone number needs to look like this: ###-###-####");
		
		p = phone;
	}
}
