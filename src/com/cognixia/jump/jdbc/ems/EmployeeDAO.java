package com.cognixia.jump.jdbc.ems;

import java.util.List;

public interface EmployeeDAO {
	
	public List<Employees> getAllEmployees();
	
	public Department getEmployeeById(int deptId);
	
	public Department getEmployeeByName(String deptName) throws DepartmentNotFoundException;
	
	public boolean addEmployee(Department dept);
	
	public boolean deleteEmployee(int deptId);
	
	public boolean updateEmployee(Department dept);

}
