package com.cognixia.jump.jdbc.ems.interfaces;

import java.util.List;

import com.cognixia.jump.jdbc.ems.models.*;

public interface DepartmentDAO {

	public List<Department> getAllDepartments();
	public Department getDepartmentById(int depId);
	public Department getDepartmentByName(String depName);
	public boolean addDepartment(Department dept);
	public boolean deleteDepartment(int depId);
	public boolean updateDepartment(Department dept);
	
	public List<Department> getAllDepartmentInCompany(int id);
}
