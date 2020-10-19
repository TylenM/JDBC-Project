package com.cognixia.jump.jdbc.ems.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cognixia.jump.jdbc.ems.Address;
import com.cognixia.jump.jdbc.ems.implementations.AddressImp;
import com.cognixia.jump.jdbc.ems.interfaces.AddressDAO;

class AddressImpTest {

	private AddressDAO addressDAO = new AddressImp();
	
	@Test
	void getAllAddresses() {
		assertNotEquals(null, addressDAO.getAllAddresses());
	}
	
	@Test
	void getAddressById() {
		assertEquals(null, addressDAO.getAddressById(200));
	}
	
	@Test
	void getAddressByState() {

	}
	
	@Test
	void getAddressByName() {
	}
	
	@Test
	void addAddress() {

	}
	
	@Test
	void deleteAddress() {
	}
	
	@Test
	void updateAddress() {
		
	}

}
