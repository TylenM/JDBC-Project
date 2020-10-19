package com.cognixia.jump.jdbc.ems.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.jdbc.ems.Address;
import com.cognixia.jump.jdbc.ems.ConnectionManager;
import com.cognixia.jump.jdbc.ems.interfaces.AddressDAO;
import com.cognixia.jump.jdbc.exceptions.AddressNotFoundException;

public class AddressImp implements AddressDAO{
	
	private Connection conn = ConnectionManager.getConnection();

	@Override
	public List<Address> getAllAddresses() {
			
		List<Address> addressList = new ArrayList<>();
			
			
		try (PreparedStatement pstmt = conn.prepareStatement("select * from address");
				ResultSet rs = pstmt.executeQuery(); ) {
				
			while(rs.next()) {
					
				int id = rs.getInt("address_id");
				String name = rs.getString("address");
				String state = rs.getString("state");
					
				Address address = new Address(id, name, state);
					
					addressList.add(address);
					
			}
				
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			
			return addressList;
		}
	@Override
	public Address getAddressById(int id) {
		
		ResultSet rs = null;
		
		try(PreparedStatement pstmt = conn.prepareStatement("select * from address where address_id = ?")) {
			
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				int address_id = rs.getInt("address_id");
				String name = rs.getString("address");
				String state = rs.getString("state");
				
				Address address= new Address(address_id, name, state);
				
				return address;
			}
			
		} catch(SQLException e) {
			
		} finally {
			
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public Address getAddressByState(String state) {
		
		ResultSet rs = null;
		
		try(PreparedStatement pstmt = conn.prepareStatement("select * from address where state = ?")) {
			
			pstmt.setString(1, state);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				int address_id = rs.getInt("address_id");
				String name = rs.getString("address");
				String address_state = rs.getString("state");
				
				Address address= new Address(address_id, name, address_state);
				
				return address;
			}
			
		} catch(SQLException e) {
			
		} finally {
			
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	@Override
	public Address getAddressByName(String address) throws AddressNotFoundException {
		ResultSet rs = null;

		try (PreparedStatement pstmt = conn.prepareStatement("select * from address where address = ?")) {

			pstmt.setString(1, address);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				int id = rs.getInt("address_id");
				String address_name = rs.getString("address");
				String state = rs.getString("state");
				
				Address a1= new Address(id, address_name, state);
				
				return a1;
			}

		} catch (SQLException e) {

		} finally {

			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		throw new AddressNotFoundException(address);
	}

	@Override
	public boolean addAddress(Address address) {
		
		try(PreparedStatement pstmt = conn.prepareStatement("insert into address values(?,?,?)")) {
			
			pstmt.setInt(1, address.getId());
			pstmt.setString(2, address.getAddress());
			pstmt.setString(3, address.getState());
			
			int count = pstmt.executeUpdate();
			
			if(count > 0) {
				return true;
			}
			
		} catch(SQLException e) {
			//e.printStackTrace();
			
		} 
		
		return false;
	}
	
	@Override
	public boolean deleteAddress(int id) {
		
		try(PreparedStatement pstmt = conn.prepareStatement("delete address where address_id = ?")) {
			
			pstmt.setInt(1, id);
			
			int count = pstmt.executeUpdate();
			
			if(count > 0) {
				return true;
			}
			
		} catch(SQLException e) {
			
		}
		
		return false;
	}

	@Override
	public boolean updateAddress(Address address) {
		
		try(PreparedStatement pstmt = conn.prepareStatement("update address set address = ?, state = ? where address_id = ?")) {
			
			pstmt.setString(1, address.getAddress());
			pstmt.setString(2, address.getState());
			pstmt.setInt(2, address.getId());
			
			int count = pstmt.executeUpdate();
			
			if(count > 0) {
				return true;
			}
			
		} catch(SQLException e) {
			
		}	
		
		return false;
	}
	
	public void closeConnection() throws SQLException {
		conn.close();
	}
}