package com.cognixia.jump.jdbc.ems.interfaces;

import java.util.List;

import com.congnixia.jump.jdbc.dao.Department;

public interface DepartmentDAO {

	/**
	 * read all
	 * @return
	 */
	public List<Department> getAllDepartments();
	/**
	 * get one, find by id
	 * @param depId
	 * @return 
	 */
	public Department getDepartmentById(int depId);
	/**
	 * get one, find by name
	 * 
	 * returns one Department that we searched for by name
	 * since they are all unique
	 * @param depName
	 * @return
	 */
	public Department getDepartmentByName(String depName); // if we threw instead of caught
	// you would have to add the throws 
	/**
	 * add 
	 * returns the department that was just inserted
	 * @return
	 */
	public boolean addDepartment(Department dept);
	
	/**
	 * delete by id
	 * @param depId
	 * @return
	 */
	public boolean deleteDepartment(int depId);
	
	/**
	 * update by department
	 * @param dept
	 * @return
	 */
	public boolean updateDepartment(Department dept);
	 
	/**
	  *update by id 
	  * @param deptId
	  * @return
	  */
	public boolean updateDepartment(int deptId);

	public List<Employees> allEmployeesInDep()l
	
	
	
}
