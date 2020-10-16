package com.cognixia.jump.jdbc.ems;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.cognixia.jump.jdbc.ems.ConnectionManager;

public class StatementsExample {
	
	public static void main(String[] args) {
		
		try {
			Connection conn = ConnectionManager.getConnection();
			
			Statement stmt = conn.createStatement();
			
			int count = stmt.executeUpdate("update employee set salary = 55000 where employee_id = 10000");
			
			System.out.println("Statement updated " + count + " row(s)");
			
			
			// close connections
			stmt.close();
			conn.close();
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
