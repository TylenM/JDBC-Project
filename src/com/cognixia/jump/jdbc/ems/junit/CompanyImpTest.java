package com.cognixia.jump.jdbc.ems.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.cognixia.jump.jdbc.ems.implementations.*;
import com.cognixia.jump.jdbc.ems.models.Company;

class CompanyImpTest {

	CompanyImp compImp = new CompanyImp();
	String addedString = "WHATEVER 1,2";
	String editName = "WHATEVER 112";
	
	@Test
	void testAddCompany() {
		boolean b = compImp.addCompany(new Company(22, addedString));
		assertTrue(b);	
	}
	@Test
	void testFindAll() {
		assertNotNull(compImp.getAllCompanies());
	}
	@Test 
	void findByName() {
		Company c = compImp.getCompanyByName(addedString);
		System.out.println("c" + c);
		assertEquals(c.getName(), addedString);
	}
	@Test
	void testEditCompany() {
		Company editToThis = compImp.getCompanyByName(addedString);
		editToThis.setName(editName);
		boolean b = compImp.updateCompany(editToThis);
		assertTrue(b);
	}
	@Test
	void testDeleteCompany() {
		Company lastestCompany = compImp.getCompanyByName(editName);
		boolean b = compImp.deleteCompany(lastestCompany.getCompany_id());
		assertTrue(b);
	}
	

}
