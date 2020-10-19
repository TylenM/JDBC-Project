package com.cognixia.jump.jdbc.ems.interfaces;

import java.util.List;

import com.cognixia.jump.jdbc.ems.Address;
import com.cognixia.jump.jdbc.exceptions.AddressNotFoundException;

public interface AddressDAO {

<<<<<<< HEAD
	/**
	 * find all 
	 * find all living at address
	 * find all by state aggragated
	 * 
	 * add one 
	 * 
	 * update all fields
	 * 
	 * delete
	 * 
	 */
=======
	public List<Address> getAllAddresses();
	
	public Address getAddressById(int id);
	
	public Address getAddressByState(String state);
	
	public Address getAddressByName(String address) throws AddressNotFoundException;
	
	public boolean addAddress(Address address);
	
	public boolean deleteAddress(int id);
	
	public boolean updateAddress(Address address);

>>>>>>> origin/Tylen-edits
}
