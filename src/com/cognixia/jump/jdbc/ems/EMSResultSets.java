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
			  ResultSet rs = stmt.executeQuery("select * from employee");){

			
			System.out.println("\n\nEmployees");
			System.out.println("------------------------");
			
			while(rs.next()) {
				
				int employee_id = rs.getInt("employee_id");
				String name =  rs.getString("first_name") + " " + rs.getString("last_name");
				Date dob = rs.getDate("date_of_birth");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				Double salary = rs.getDouble("salary");
				int department_id = rs.getInt("department_id");
				int address_id = rs.getInt("address_id");
				int company_id = rs.getInt("comapny_id");
				
				System.out.println("ID: " + employee_id + " || Name: " + name + " || Date of Birth: " + dob + " || Email: " + email + " || Phone: " + phone + " || Phone: " + salary + " || Department ID: " + department_id + " || Address ID: " + address_id + " || Company ID: " + company_id);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
