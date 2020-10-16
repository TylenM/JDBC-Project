package com.cognixia.jump.jdbc.ems;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.cognixia.jump.jdbc.ems.ConnectionManager;

public class EMSResultSets {
	
	public static void main(String[] args) {
		
		try ( Connection conn = ConnectionManager.getConnection();
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery("select * from employee");
			  Statement stmt2 = conn.createStatement();
			  ResultSet rs2 = stmt2.executeQuery("select * from department");
			  Statement stmt3 = conn.createStatement();
			  ResultSet rs3 = stmt3.executeQuery("select * from address");
			  Statement stmt4 = conn.createStatement();
			  ResultSet rs4 = stmt4.executeQuery("select * from company");){

			
			System.out.println("\n\nEmployees");
			System.out.println("------------------------");
			
			while(rs.next()) {
				
				int employee_id = rs.getInt("employee_id");
				String employee_name =  rs.getString("first_name") + " " + rs.getString("last_name");
				Date dob = rs.getDate("date_of_birth");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				Double salary = rs.getDouble("salary");
				int department_id = rs.getInt("department_id");
				int address_id = rs.getInt("address_id");
				int company_id = rs.getInt("company_id");
				
				System.out.println("ID: " + employee_id + " || Name: " + employee_name + " || Date of Birth: " + dob + " || Email: " + email + " || Phone: " + phone + " || Phone: " + salary + " || Department ID: " + department_id + " || Address ID: " + address_id + " || Company ID: " + company_id);
				
			}
			rs.close();
			
			System.out.println("\n\nDepartments");
			System.out.println("------------------------");
			while(rs2.next()) {
				
				int department_id = rs2.getInt("department_id");
				String department_name =  rs2.getString("name");
				Double budget = rs2.getDouble("budget");
				String ext = rs2.getString("phone_extension");
				
				System.out.println("ID: " + department_id + " || Name: " + department_name + " || Budget: " + budget + " || Phone Extension: " + ext);
				
			}
			
			rs2.close();
			
			System.out.println("\n\nAddress");
			System.out.println("------------------------");
			while(rs3.next()) {
				
				int address_id = rs3.getInt("address_id");
				String address =  rs3.getString("address");
				String state = rs3.getString("state");
				
				System.out.println("ID: " + address_id + " || Address: " + address + " || State: " + state);
				
			}
			
			rs3.close();
			
			System.out.println("\n\nCompany");
			System.out.println("------------------------");
			while(rs4.next()) {
	
				int company_id = rs4.getInt("company_id");
				String company_name =  rs4.getString("name");
				
				System.out.println("ID: " + company_id + " || Name: " + company_name);
				
			}

			rs4.close();
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
	}

}
