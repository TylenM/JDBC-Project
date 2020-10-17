package com.cognixia.jump.jdbc.ems.implementations;

import java.util.List;

import com.cognixia.jump.jdbc.ems.interfaces.CompanyDAO;
import com.cognixia.jump.jdbc.ems.models.Company;
import com.cognixia.jump.jdbc.ems.models.Department;
import com.cognixia.jump.jdbc.ems.models.Employee;

public class CompanyImp implements CompanyDAO{

	@Override
	public List<Company> findall() {
		return null;
	}

	@Override
	public Company findOneById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Company findOneByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addCompany(Company comp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCompany(Company comp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCompany(Company comp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCompanyById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Department> allDepartmentsInCompany(Company company) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> allEmployeesInCompany(Company company) {
		// TODO Auto-generated method stub
		return null;
	}

}
