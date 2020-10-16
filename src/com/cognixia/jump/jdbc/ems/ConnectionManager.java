package com.cognixia.jump.jdbc.ems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

	private static Connection connection = null;
	
	private static void makeConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Registered Driver.");
			
			Properties props = new Properties();
			props.load(new FileInputStream("resources/config.properties"));
			
			connection = DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"), props.getProperty("password"));
			System.out.println("Connection Established");
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
		System.out.println("Hello");
	}

}
