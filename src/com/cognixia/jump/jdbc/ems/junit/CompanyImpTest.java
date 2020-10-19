package com.cognixia.jump.jdbc.ems.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.cognixia.jump.jdbc.ems.implementations.*;
import com.cognixia.jump.jdbc.ems.models.Company;

class CompanyImpTest {

	CompanyImp compImp = new CompanyImp();

	@Test
	void testFindAll() {
		List<Company> arr = new ArrayList<Company>();
		
	}
	@Test
	void testAddCompany() {
		Company dummy = new Company(22, "Dummy 1");
		boolean b = compImp.addCompany(dummy);
		assertTrue(b);	
	}
	

}
