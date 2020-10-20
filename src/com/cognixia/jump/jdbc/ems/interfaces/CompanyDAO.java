package com.cognixia.jump.jdbc.ems.interfaces;

import java.util.List;

import com.cognixia.jump.jdbc.ems.models.Company;
import com.cognixia.jump.jdbc.ems.models.Department;
import com.cognixia.jump.jdbc.ems.models.Employee;

public interface CompanyDAO {

	public List<Company> getAllCompanies();
	public Company getCompanyById(int id);
	public Company getCompanyByName(String name);
	public boolean addCompany(Company comp);
	public boolean updateCompany(Company comp);
	public boolean deleteCompany(int id);
	
	public List<Department> allDepartmentsInCompany(Company company);
	public List<Employee> allEmployeesInCompanyWithAddressOutput(Company company);
}
