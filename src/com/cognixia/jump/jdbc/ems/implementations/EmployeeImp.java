package com.cognixia.jump.jdbc.ems.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import com.cognixia.jump.jdbc.ems.ConnectionManager;
import com.cognixia.jump.jdbc.ems.interfaces.EmployeeDAO;
import com.cognixia.jump.jdbc.ems.models.Employee;

public class EmployeeImp implements EmployeeDAO {
	
	private Connection conn = ConnectionManager.getConnection();

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> empList = new ArrayList<>();
		
		try(PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employee");
			ResultSet rs = pstmt.executeQuery();) {
			
			while(rs.next()) {
				Employee emp = new Employee(
						rs.getInt("employee_id"), 
						rs.getString("first_name"), 
						rs.getString("last_name"), 
						rs.getDate("date_of_birth"), 
						rs.getString("email"), 
						rs.getString("phone"), 
						rs.getDouble("salary"), 
						rs.getInt("department_id"), 
						rs.getInt("address_id")
				);
				empList.add(emp);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return empList;
	}

	@Override
	public List<Employee> getEmployeeByFirstName(String firstName) {
		ResultSet rs = null;
		List<Employee> empList = new ArrayList<>();
		
		try(PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employee WHERE first_name = ?");) {
			
			pstmt.setString(1, firstName);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Employee emp = new Employee(
						rs.getInt("employee_id"), 
						rs.getString("first_name"), 
						rs.getString("last_name"), 
						rs.getDate("date_of_birth"), 
						rs.getString("email"), 
						rs.getString("phone"),
						rs.getDouble("salary"),
						rs.getInt("department_id"),
						rs.getInt("address_id")
				); 
				empList.add(emp);
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
		return empList;
	}

	@Override
	public Employee getEmployeeById(int id) {
		ResultSet rs = null;
		
		try(PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employee WHERE employee_id = ?");) {
			
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				Employee emp = new Employee(
						rs.getInt("employee_id"), 
						rs.getString("first_name"), 
						rs.getString("last_name"), 
						rs.getDate("date_of_birth"), 
						rs.getString("email"), 
						rs.getString("phone"),
						rs.getDouble("salary"),
						rs.getInt("department_id"),
						rs.getInt("address_id")
				); 
				return emp;
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
	public boolean addEmployee(Employee emp) {
		try(PreparedStatement pstmt = conn.prepareStatement("INSERT INTO employee(employee_id, first_name, last_name, date_of_birth, email, phone, salary, department_id, address_id) VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?);")) {
			
			pstmt.setString(1, emp.getFirst_name());
			pstmt.setString(2, emp.getLast_name());
			pstmt.setDate(3, emp.getDate_of_birth());
			pstmt.setString(4, emp.getEmail());
			pstmt.setString(5, emp.getPhone());
			pstmt.setDouble(6, emp.getSalary());
			pstmt.setInt(7, emp.getDepartment_id());
			pstmt.setInt(8, emp.getAddress_id());
			
			if(pstmt.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteEmployee(int id) {
		try(PreparedStatement pstmt = conn.prepareStatement("delete from employee where employee_id = ?")) {
			
			pstmt.setInt(1, id);
			
			int count = pstmt.executeUpdate();
			
			if(count > 0) {
				return true;
			}
			
		} catch(SQLException e) {
			System.out.println("Employee with id: " + id + " was not deleted.");
		} 
		return false;
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		try(PreparedStatement pstmt = conn.prepareStatement("update employee set first_name = ?, last_name = ?, date_of_birth = ?, email = ?, phone = ?, salary = ?, department_id = ?, address_id = ? where employee_id = ?")){
			
			pstmt.setString(1, emp.getFirst_name());
			pstmt.setString(2, emp.getLast_name());
			pstmt.setDate(3, emp.getDate_of_birth());
			pstmt.setString(4, emp.getEmail());
			pstmt.setString(5, emp.getPhone());
			pstmt.setDouble(6, emp.getSalary());
			pstmt.setInt(7, emp.getDepartment_id());
			pstmt.setInt(8, emp.getAddress_id());
			pstmt.setInt(9, emp.getEmployee_id());
			
			int count = pstmt.executeUpdate();
			
			if(count > 0) {
				return true;
			}
			
		} catch(SQLException e) {
			System.out.println("Employee with id: " + emp.getEmployee_id() + " was not updated.");
			e.printStackTrace();
		} 
		return false;
	}

	@Override
	public boolean checkEmployeeEmailExists(String email) {
		ResultSet rs = null;
		
		try(PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employee WHERE email = ?");) {
			
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return true;
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
		return false;
	}

	@Override
	public boolean checkEmployeePhoneExists(String phone) {
		ResultSet rs = null;
		
		try(PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employee WHERE phone = ?");) {
			
			pstmt.setString(1, phone);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return true;
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
		return false;
	}

	@Override
	public List<Employee> getAllEmployeesInDeptWithId(int id) {
		List<Employee> empList = new ArrayList<>();
		ResultSet rs = null;
		
		try(PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employee where department_id = ?");) {
			
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Employee emp = new Employee(
						rs.getInt("employee_id"), 
						rs.getString("first_name"), 
						rs.getString("last_name"), 
						rs.getDate("date_of_birth"), 
						rs.getString("email"), 
						rs.getString("phone"), 
						rs.getDouble("salary"), 
						rs.getInt("department_id"), 
						rs.getInt("address_id")
				);
				empList.add(emp);
			}
			
		} catch(Exception e) {
			System.out.println("There are no employees in the department.");
		}
		return empList;
	}

	@Override
	public List<Employee> getAllEmployeesInCompWithId(int id) {
		List<Employee> empList = new ArrayList<>();
		ResultSet rs = null;
		
		try(PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employee where company_id = ?");) {
			
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Employee emp = new Employee(
						rs.getInt("employee_id"), 
						rs.getString("first_name"), 
						rs.getString("last_name"), 
						rs.getDate("date_of_birth"), 
						rs.getString("email"), 
						rs.getString("phone"), 
						rs.getDouble("salary"), 
						rs.getInt("department_id"), 
						rs.getInt("address_id")
				);
				empList.add(emp);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return empList;
	}

	@Override
	public List<Employee> getAllAddressesForEmployee(int id) {
		List<Employee> empList = new ArrayList<>();
		ResultSet rs = null;
		
		try(PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employee where address_id = ?");) {
			
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Employee emp = new Employee(
						rs.getInt("employee_id"), 
						rs.getString("first_name"), 
						rs.getString("last_name"), 
						rs.getDate("date_of_birth"), 
						rs.getString("email"), 
						rs.getString("phone"), 
						rs.getDouble("salary"), 
						rs.getInt("department_id"), 
						rs.getInt("address_id")
				);
				empList.add(emp);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return empList;
	}
	
}
