package com.cognixia.jump.jdbc.ems.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.jdbc.ems.interfaces.CompanyDAO;
import com.cognixia.jump.jdbc.ems.sqlconnection.ConnectToSQL;
import com.cognixia.jump.jdbc.ems.models.*;

public class CompanyImp implements CompanyDAO {

	private Connection conn = ConnectToSQL.getConnection();

	@Override
	public List<Company> findall() {
		List<Company> companies = new ArrayList<>();
		try (PreparedStatement pstmt = 
				conn.prepareStatement("SELECT * FROM company ORDER BY company_id");
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				int id = rs.getInt("company_id");
				String name = rs.getString("name");
				Company company = new Company(id, name);
				companies.add(company);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return companies;
	}

	@Override
	public Company findOneById(int id) {
		ResultSet rs = null;
		try (PreparedStatement pstmt = 
				conn.prepareStatement("SELECT * FROM company WHERE company_id = ?")) {
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int c_id = rs.getInt("company_id");
				String name = rs.getString("name");
				Company company = new Company(c_id, name);
				return company;
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
	public Company findOneByName(String name) {
		ResultSet rs = null;
		try (PreparedStatement pstmt = 
				conn.prepareStatement("SELECT * FROM company WHERE name = ?")) {
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int c_id = rs.getInt("company_id");
				String c_name = rs.getString("name");
				Company company = new Company(c_id, c_name);
				return company;
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
	public boolean addCompany(Company comp) {
		try (PreparedStatement pstmt = 
				conn.prepareStatement("INSERT INTO company VALUES(null,?)");) {
			pstmt.setString(1, comp.getName());
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateCompany(Company comp) {
		try (PreparedStatement pstmt = conn.prepareStatement("UPDATE company SET name = ? WHERE company_id = ?")) {
			pstmt.setString(1, comp.getName());
			pstmt.setInt(2, comp.getId());
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteCompany(Company comp) {
		try (PreparedStatement pstmt = conn.prepareStatement("DELETE FROM company WHERE company_id = ?")) {
			pstmt.setInt(1, comp.getId());
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteCompanyById(int id) {
		try (PreparedStatement pstmt = conn.prepareStatement("DELETE FROM company WHERE company_id = ?")) {
			pstmt.setInt(1, id);
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Department> allDepartmentsInCompany(Company company) {
		List<Department> departments = new ArrayList<>();
		try (PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM department WHERE company_id = ?");
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				int company_id = rs.getInt("company_id");
				int id = rs.getInt("department_id");
				double budget = rs.getDouble("budget");
				String name = rs.getString("name");
				String phone_extension = rs.getString("phone_extension");
				Department department = new Department(id, company_id, name, phone_extension, budget);
				departments.add(department);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return departments;
	}

	@Override
	public List<Employee> allEmployeesInCompanyWithAddressOutput(Company company) {
		List<Employee> employees = new ArrayList<>();
		try (PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employee "
				+ "LEFT JOIN address ON employee.address_id = address.address_id WHERE company_id = ?");
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				int id = rs.getInt("employee_id");
				double salary = rs.getDouble("salary");
				String name = rs.getString("first_name") + " " + rs.getString("last_name");
				String date_of_birth = rs.getString("date_of_birth");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				System.out.println(name  + " : " + address);
				Employee employee = new Employee();
				employees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return employees;
	}

}
