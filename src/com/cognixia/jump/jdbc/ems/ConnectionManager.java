package com.cognixia.jump.jdbc.ems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static final String URL = "jdbc:mysql://localhost:3306/JDBC_EMS?serverTimezone=EST5EDT";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Root@123";
	
	private static Connection connection; // will be null at moment
	
	
	private static void makeConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Registered Driver");
			
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Connected.");
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	

	public static Connection getConnection() {

		if(connection == null) {
			makeConnection();
		}

		return connection;
	}

	public static void main(String[] args) {

		Connection conn = ConnectionManager.getConnection();
		
		//Connection other = BetterConnectionManager.getConnection();

		// work with connection manipulating database

		try {
			conn.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
