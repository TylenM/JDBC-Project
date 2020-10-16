package com.cognixia.jump.jdbc.ems;

import java.io.File;
import java.util.List;

public class DepartmentDAOFile implements DepartmentDAO {
	
	private File myFile = new File("department.csv");

	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department getDepartmentById(int deptId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department getDepartmentByName(String deptName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addDepartment(Department dept) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteDepartment(int deptId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDepartment(Department dept) {
		// TODO Auto-generated method stub
		return false;
	}

}
