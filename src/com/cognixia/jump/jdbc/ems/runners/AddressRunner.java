package com.cognixia.jump.jdbc.ems.runners;

import java.util.Scanner;

import com.cognixia.jump.jdbc.ems.InputValidation;
import com.cognixia.jump.jdbc.ems.Main;
import com.cognixia.jump.jdbc.ems.implementations.AddressImp;
import com.cognixia.jump.jdbc.ems.implementations.EmployeeImp;
import com.cognixia.jump.jdbc.ems.interfaces.AddressDAO;
import com.cognixia.jump.jdbc.ems.interfaces.EmployeeDAO;
import com.cognixia.jump.jdbc.ems.models.Address;
import com.cognixia.jump.jdbc.ems.models.Department;
import com.cognixia.jump.jdbc.ems.models.Employee;

public class AddressRunner {
	
	private static AddressDAO aDAO = new AddressImp();
	private static EmployeeDAO eDAO = new EmployeeImp();
	private static Scanner scan = new Scanner(System.in);
	
	public static void addressUpdate(Address add) {
		Address.tableSingleDepartment(add);
		
		System.out.println("Pick an option (A, B, C, or D):");
		System.out.println("------------------------");
		System.out.println("A - Edit Address.");
		System.out.println("B - Edit State.");
		System.out.println("C - Return to Address Table.");
		System.out.println("D - Return to Main Menu.");
		
		String newStr = scan.nextLine();
		
		while(!(newStr.equalsIgnoreCase("A") || newStr.equalsIgnoreCase("B") || newStr.equalsIgnoreCase("C") || newStr.equalsIgnoreCase("D"))) {
			System.out.println("You have entered in: " + newStr + "\nPick an option (A, B, C, or D):");
			newStr = scan.nextLine();
		}
		
		int id = add.getAddress_id();
		String address = add.getAddress();
		String state = add.getState();
		
		if(newStr.equalsIgnoreCase("A")) {
			System.out.println("Enter an Address (Just street and city): ");
			address = scan.nextLine();
		} else if(newStr.equalsIgnoreCase("B")) {
			System.out.println("Enter a State (2 letters): ");
			state = scan.nextLine();
		} else if(newStr.equalsIgnoreCase("C")) {
			Address.tableView(aDAO.getAllAddresses());
			Main.crudOption("address");
		} else if(newStr.equalsIgnoreCase("D")) {
			Main.mainMenu();
		}
		
		add = new Address(
				id,
				address,
				state
		);
		aDAO.updateAddress(add);
		addressUpdate(add);
	}
	
	public static void addressAdd() {
		Address add = null;
		
		System.out.println("Enter an Address (Just street and city): ");
		String address = scan.nextLine();
		
		System.out.println("Enter a State (2 letters): ");
		String state = scan.nextLine();
		
		add = new Address(
				-1,
				address,
				state
		);
				
		if(aDAO.addAddress(add)) {
			Address.tableView(aDAO.getAllAddresses());
			Main.crudOption("address");
		}
		addressAdd();
	}
	
	public static void addressRemove() {
		System.out.println("Enter in the id of the address you would like to delete: ");
		int id = InputValidation.validInterger();
		if(aDAO.deleteAddress(id)) {
			System.out.println("Address was deleted.");
		} else {
			System.out.println("Address was not deleted.");
		}
		Address.tableView(aDAO.getAllAddresses());
		Main.crudOption("address");
	}
	
	public static void addressListEmployees(int id) {
		Employee.tableView(eDAO.getAllAddressesForEmployee(id));
		Main.crudOption("address");
	}
}
