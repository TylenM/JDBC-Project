package com.cognixia.jump.jdbc.ems;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.jdbc.ems.ConnManagerWithProps;

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

	@Override
	public boolean deleteDepartment(int deptId) {
		
		try(PreparedStatement pstmt = conn.prepareStatement("delete from department where dept_id = ?")) {
			
			pstmt.setInt(1, deptId);
			
			int count = pstmt.executeUpdate();
			
			if(count > 0) {
				return true;
			}
			
		} catch(SQLException e) {
			//e.printStackTrace();
			
		} 
		
		return false;
	}
	@Override
	public boolean updateDepartment(Department dept) {
		
		
		try(PreparedStatement pstmt = conn.prepareStatement("update department set dept_id = ?, dept_name = ?, dept_phone = ?")){
			
//			pstmt.setInt(1, 20000);
//			pstmt.setString(2, "NewName");
//			pstmt.setString(3, "0987654321");
			
//			dept.setId(20000);
//			dept.setName("NewName");
//			dept.setPhone("0987654321");
			
			pstmt.setInt(1, dept.getId());
			pstmt.setString(2, dept.getName());
			pstmt.setString(3, dept.getPhone());
			
			int count = pstmt.executeUpdate();
			
			if(count > 0) {
				return true;
			}
			
		} catch(SQLException e) {
			//e.printStackTrace();
			
		} 
		
		return false;
	}
		
	
	public void closeConnection() throws SQLException {
		conn.close();
	}

}
