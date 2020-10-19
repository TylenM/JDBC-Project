package com.cognixia.jump.jdbc.ems.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.cognixia.jump.jdbc.ems.implementations.*;
import com.cognixia.jump.jdbc.ems.models.Company;

class CompanyImpTest {

	CompanyImp compImp = new CompanyImp();
	String addedString = "TESTING 1,2";
	String editName = "TEsting 112";
	
	@Before
	void testAddCompany() {
		Company dummy = new Company(22, addedString);
		boolean b = compImp.addCompany(dummy);
		assertTrue(b);	
	}
	@Test
	void testFindAll() {
		List<Company> arr = compImp.findall();
		assertNotNull(arr);
	}
	@Test 
	void findByName() {
		Company c = compImp.findOneByName(addedString);
		assertEquals(c.getName(), addedString);
	}
	@Test
	void testEditCompany() {
		Company editToThis = new Company(compImp.findOneByName(addedString).getId(),editName);
		boolean b = compImp.updateCompany(editToThis);
		assertTrue(b);
	}
	@After
	void testDeleteCompany() {
		Company lastestCompany = compImp.findOneByName(editName);
		boolean b = compImp.deleteCompany(lastestCompany);
		assertTrue(b);
	}
	
//	@Test
//	void testDeleteCompanyById() {
//		int lastestCompanyId = compImp.findall().get(compImp.findall().size() - 1).getId();
//		boolean b = compImp.deleteCompanyById(lastestCompanyId);
//		assertTrue(b);
//	}

}
