package com.cognixia.jump.jdbc.ems.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.jdbc.ems.ConnectionManager;
import com.cognixia.jump.jdbc.ems.interfaces.EmployeeDAO;
import com.cognixia.jump.jdbc.ems.models.Employee;

public class EmployeeImp implements EmployeeDAO {

	private Connection conn = ConnectionManager.getConnection();

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> empList = new ArrayList<>();
		
		try(PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employee");
			ResultSet rs = pstmt.executeQuery();) {
			
			while(rs.next()) {
				Employee emp = new Employee(
						rs.getInt("employee_id"), 
						rs.getString("first_name"), 
						rs.getString("last_name"), 
						rs.getDate("date_of_birth"), 
						rs.getString("email"), 
						rs.getString("phone"), 
						rs.getDouble("salary"), 
						rs.getInt("department_id"), 
						rs.getInt("address_id"), 
						rs.getInt("company_id")
				);
				empList.add(emp);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return empList;
	}

	@Override
	public List<Employee> getEmployeeByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEmployee(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
