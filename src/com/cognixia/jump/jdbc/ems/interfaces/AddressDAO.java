package com.cognixia.jump.jdbc.ems.interfaces;

import java.util.List;

import com.cognixia.jump.jdbc.ems.models.Address;
import com.cognixia.jump.jdbc.exceptions.AddressNotFoundException;

public interface AddressDAO {
	
	public List<Address> getAllAddresses();
	public Address getAddressById(int id);
	public Address getAddressByState(String state);
	public Address getAddressByName(String address) throws AddressNotFoundException;
	public boolean addAddress(Address address);
	public boolean deleteAddress(int id);
	public boolean updateAddress(Address address);
}
