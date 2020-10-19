package com.cognixia.jump.jdbc.ems.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.cognixia.jump.jdbc.ems.implementations.*;
import com.cognixia.jump.jdbc.ems.models.Company;


@TestMethodOrder(OrderAnnotation.class)
class CompanyImpTest {

	CompanyImp compImp = new CompanyImp();
	String addedString = "Something";
	String editName = "some!!";
	
	@Test
	@Order(1)
	void testAddCompany() {
		boolean b = compImp.addCompany(new Company(22, addedString));
		assertTrue(b);	
	}
	@Test
	@Order(2)
	void testFindAll() {
		assertNotNull(compImp.findall());
	}
	@Test 
	@Order(3)
	void findByName() {
		Company c = compImp.findOneByName(addedString);
		assertEquals(c.getName(), addedString);
	}
	@Test
	@Order(4)
	void testEditCompany() {
		Company editToThis = compImp.findOneByName(addedString);
		editToThis.setName(editName);
		boolean b = compImp.updateCompany(editToThis);
		assertTrue(b);
	}
	@Test
	@Order(5)
	void testDeleteCompany() {
		Company lastestCompany = compImp.findOneByName(editName);
		boolean b = compImp.deleteCompany(lastestCompany);
		assertTrue(b);
	}
	

}
