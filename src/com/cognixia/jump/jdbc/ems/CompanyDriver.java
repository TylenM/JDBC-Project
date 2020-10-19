package com.cognixia.jump.jdbc.ems;

import com.cognixia.jump.jdbc.ems.implementations.CompanyImp;
import com.cognixia.jump.jdbc.ems.interfaces.CompanyDAO;
import com.cognixia.jump.jdbc.ems.models.Company;

public class CompanyDriver {

	static CompanyDAO comDAO = new CompanyImp();
	public static void main(String[] args) {
		//listAll();
		//findCompany7();
		//findCompanyApple();
	}
	
	/**
	 * 
	 */
	public static void listAll() {
		for (Company company : comDAO.findall()) {
			System.out.println(company);
		}
	}
	
	public static void findCompany7() {
		System.out.println(comDAO.findOneById(7));
	}


	public static void findCompanyApple() {
		System.out.println(comDAO.findOneByName("Apple"));
	}
	
	public static void addSomeComp(String name) {
		Company comp = new Company(0, name);
		boolean b = comDAO.addCompany(comp);
		if(b) {
			System.out.println("was Added!");
			listAll();
		} else {
			System.out.println("could not add");
		}
	}
	
	
	public static void updateLastes(String updateName) {
		int lastCompId = comDAO.findall().get(comDAO.findall().size()-1).getId();
		Company comp = new Company(lastCompId, updateName);
		boolean b = comDAO.updateCompany(comp);
		if(b) {
			System.out.println("was updated!");
			listAll();
		} else {
			System.out.println("could not update");
		}
	}
	

}
