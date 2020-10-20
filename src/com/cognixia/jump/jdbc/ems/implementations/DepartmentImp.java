package com.cognixia.jump.jdbc.ems.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.jdbc.ems.ConnectionManager;
import com.cognixia.jump.jdbc.ems.interfaces.DepartmentDAO;
import com.cognixia.jump.jdbc.ems.models.Department;
import com.cognixia.jump.jdbc.ems.models.Employee;

public class DepartmentImp implements DepartmentDAO {
	
	private Connection conn = ConnectionManager.getConnection();

	@Override
	public List<Department> getAllDepartments() {
		List<Department> deptList = new ArrayList<>();
		
		try (PreparedStatement pstmt = conn.prepareStatement("select * from department");
				ResultSet rs = pstmt.executeQuery(); ) {
			
			while(rs.next()) {
				
				int id = rs.getInt("department_id");
				String name = rs.getString("name");
				double budget = rs.getDouble("budget");
				String phone = rs.getString("phone_extension");
				int companyId = rs.getInt("company_id");
				
				Department dept = new Department(id, name, budget, phone, companyId);
				
				deptList.add(dept);
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return deptList;
	}

	@Override
	public Department getDepartmentById(int depId) {
		ResultSet rs = null;
		
		try(PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM department WHERE department_id = ?");) {
			
			pstmt.setInt(1, depId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt("department_id");
				String name = rs.getString("name");
				double budget = rs.getDouble("budget");
				String phone = rs.getString("phone_extension");
				int companyId = rs.getInt("company_id");
				
				Department dept = new Department(id, name, budget, phone, companyId);
				
				return dept;
			}
		} catch(SQLException e) {
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
	public Department getDepartmentByName(String depName) {
		ResultSet rs = null;
		
		try(PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM department WHERE name = ?");) {
			
			pstmt.setString(1, depName);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt("department_id");
				String name = rs.getString("name");
				double budget = rs.getDouble("budget");
				String phone = rs.getString("phone_extension");
				int companyId = rs.getInt("company_id");
				
				Department dept = new Department(id, name, budget, phone, companyId);
				
				return dept;
			}
		} catch(SQLException e) {
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
	public boolean addDepartment(Department dept) {
		try(PreparedStatement pstmt = conn.prepareStatement("INSERT INTO department(department_id, company_id, name, phone_extension, budget) VALUES(null, ?, ?, ?, ?);")) {
			
			pstmt.setInt(1, dept.getCompany_id());
			pstmt.setString(2, dept.getName());
			pstmt.setString(3, dept.getPhone_extension());
			pstmt.setDouble(4, dept.getBudget());
			
			if(pstmt.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Department Name and Company already exits, please enter unique values.");
		}
		return false;
	}

	@Override
	public boolean deleteDepartment(int depId) {
		try(PreparedStatement pstmtDept = conn.prepareStatement("DELETE FROM department WHERE department_id = ?");
			PreparedStatement pstmtEmp = conn.prepareStatement("DELETE FROM employee WHERE department_id = ?");) {
			
			pstmtDept.setInt(1, depId);
			pstmtEmp.setInt(1, depId);
			
			pstmtEmp.executeUpdate();
			int count = pstmtDept.executeUpdate();
			
			if(count > 0) {
				return true;
			}
			
		} catch(SQLException e) {
			System.out.println("Department with the id: " + depId + " was not deleted.");
		} 
		return false;
	}

	@Override
	public boolean updateDepartment(Department dept) {
		try(PreparedStatement pstmt = conn.prepareStatement("update department set name = ?, phone_extension = ?, budget = ?, company_id = ? where department_id = ?")){
			
			pstmt.setString(1, dept.getName());
			pstmt.setString(2, dept.getPhone_extension());
			pstmt.setDouble(3, dept.getBudget());
			pstmt.setInt(4, dept.getCompany_id());
			pstmt.setInt(5, dept.getDepartment_id());
			
			int count = pstmt.executeUpdate();
			
			if(count > 0) {
				return true;
			}
			
		} catch(SQLException e) {
			System.out.println("Department with the id: " + dept.getDepartment_id() + " was not updated. Check for duplicate name or company_id.");
		} 
		return false;
	}

	@Override
	public List<Department> getAllDepartmentInCompany(int id) {
		List<Department> deptList = new ArrayList<>();
		ResultSet rs = null;
		
		try (PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM department WHERE company_id = ?");) {
			
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				int deptId = rs.getInt("department_id");
				String name = rs.getString("name");
				double budget = rs.getDouble("budget");
				String phone = rs.getString("phone_extension");
				int companyId = rs.getInt("company_id");
				
				Department dept = new Department(deptId, name, budget, phone, companyId);
				
				deptList.add(dept);
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return deptList;
	}
	
	
}
