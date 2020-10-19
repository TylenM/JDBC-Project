package com.cognixia.jump.jdbc.ems;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cognixia.jump.jdbc.ems.exceptions.PhoneNumberException;

public class InputValidation {
	
	private static Scanner scan = new Scanner(System.in);
	
	public static int validInterger() {
		while(true) {
			try {
				int newInt = scan.nextInt();
				if(newInt > 0) {
					return newInt;					
				} else {
					System.out.println("Enter a positive integer: ");
				}
			} catch(InputMismatchException ex) {
				System.out.println("Enter a valid integer: ");
				scan.nextLine();
			}
		}
	}
	
	public static double validDouble() {
		while(true) {
			try {
				double newDouble = scan.nextDouble();
				if(newDouble > 0) {
					return newDouble;					
				} else {
					System.out.println("Enter a positive double:");
				}
			} catch(InputMismatchException ex) {
				System.out.println("Enter a valid double: ");
				scan.nextLine();
			}
		}
	}
	
	public static String isValidPhoneNumber() throws PhoneNumberException {
		
		while(true) {
			String reggie = "[0-9]{3}-[0-9]{3}-[0-9]{4}";
			Pattern pattern = Pattern.compile(reggie);
			String s = scan.nextLine();
			Matcher matchy = pattern.matcher(s);
			
			if(matchy.matches()) {
				return s;
			} else {
				throw new PhoneNumberException(s);
			}
		}
	}
	
	public static String isValidDate() {
		while(true) {
			try {
				String newDate = scan.nextLine();
				DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.US);
				f = f.withResolverStyle(ResolverStyle.SMART);
			    LocalDateTime ld = LocalDate.parse(newDate , f).atStartOfDay();
			    return newDate;
			} catch (DateTimeParseException  e) {
			    System.out.println("Date needs to be in proper format (yyyy-mm-DD) Please enter a new date:");
			}
		}
	}
	
	public static String isValidEmail() {
		while(true) {
			System.out.println("Please enter a valid email address: (example@gmail.com)");
			String reggie = "[a-zA-z0-9]+@[a-zA-z0-9]+\\.[a-z]{2,}";
			Pattern pattern = Pattern.compile(reggie);
			String email = scan.nextLine();
			Matcher matchy = pattern.matcher(email);
			if(matchy.matches()) {
				return email;
			}
		}
	}
}
