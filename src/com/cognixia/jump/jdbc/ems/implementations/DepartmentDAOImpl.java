package com.cognixia.jump.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.jdbc.connection.ConnManagerWithProps;

public class DepartmentDAOImpl implements DepartmentDAO {
	
	private Connection conn = ConnManagerWithProps.getConnection();

	@Override
	public List<Department> getAllDepartments() {
		
		List<Department> deptList = new ArrayList<>();
		
		
		try (PreparedStatement pstmt = conn.prepareStatement("select * from department");
				ResultSet rs = pstmt.executeQuery(); ) {
			
			while(rs.next()) {
				
				int id = rs.getInt("dept_id");
				String name = rs.getString("dept_name");
				String phone = rs.getString("dept_phone");
				
				Department dept = new Department(id, name, phone);
				
				deptList.add(dept);
				
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return deptList;
	}

	@Override
	public Department getDepartmentById(int deptId) {
		
		ResultSet rs = null;
		
		try(PreparedStatement pstmt = conn.prepareStatement("select * from department where dept_id = ?")) {
			
			pstmt.setInt(1, deptId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				int id = rs.getInt("dept_id");
				String name = rs.getString("dept_name");
				String phone = rs.getString("dept_phone");
				
				Department dept = new Department(id, name, phone);
				
				return dept;
			}
			
		} catch(SQLException e) {
			
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
	public Department getDepartmentByName(String deptName) throws DepartmentNotFoundException {
		ResultSet rs = null;

		try (PreparedStatement pstmt = conn.prepareStatement("select * from department where dept_name = ?")) {

			pstmt.setString(1, deptName);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				int id = rs.getInt("dept_id");
				String name = rs.getString("dept_name");
				String phone = rs.getString("dept_phone");

				Department dept = new Department(id, name, phone);

				return dept;
			}

		} catch (SQLException e) {

		} finally {

			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		throw new DepartmentNotFoundException(deptName);
	}

	@Override
	public boolean addDepartment(Department dept) {
		
		try(PreparedStatement pstmt = conn.prepareStatement("insert into department values(null,?,?)")) {
			
			pstmt.setString(1, dept.getName());
			pstmt.setString(2, dept.getPhone());
			
			int count = pstmt.executeUpdate();
			
			if(count > 0) {
				return true;
			}
			
		} catch(SQLException e) {
			//e.printStackTrace();
			
		} 
		
		return false;
	}



}
