package com.cognixia.jump.jdbc.ems.interfaces;

import java.util.List;

import com.cognixia.jump.jdbc.ems.models.Company;
import com.cognixia.jump.jdbc.ems.models.Department;
import com.cognixia.jump.jdbc.ems.models.Employee;

public interface CompanyDAO {

	/**
	 * find all 
	 * find one by name 
	 * find one by id
	 * add one
	 * update name
	 * delete all cascading 
	 */

	public List<Company> findall();
	public Company findOneById(int id);
	public Company findOneByName(String name);
	public boolean addCompany(Company comp);
	public boolean updateCompany(Company comp);
	public boolean deleteCompany(Company comp);
	public boolean deleteCompanyById(int id);
	
	public List<Department> allDepartmentsInCompany(Company company);
	public List<Employee> allEmployeesInCompany(Company company);
}
