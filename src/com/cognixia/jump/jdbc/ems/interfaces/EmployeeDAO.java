package com.cognixia.jump.jdbc.ems.interfaces;

import java.util.List;

import com.cognixia.jump.jdbc.ems.models.Address;
import com.cognixia.jump.jdbc.ems.models.Employee;

public interface EmployeeDAO {
	
	public List<Employee> getAllEmployees();
	public List<Employee> getEmployeeByFirstName(String firstName);
	public Employee getEmployeeById(int id);
	public boolean addEmployee(Employee emp);
	public boolean deleteEmployee(int id);
	public boolean updateEmployee(Employee emp);
	
	public boolean checkEmployeeEmailExists(String email);
	public boolean checkEmployeePhoneExists(String phone);
	
	public List<Employee> getAllEmployeesInDeptWithId(int id);
	public List<Employee> getAllEmployeesInCompWithId(int id);
	
	public List<Employee> getAllAddressesForEmployee(int id);
}
