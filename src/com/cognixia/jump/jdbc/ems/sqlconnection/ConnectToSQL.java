package com.cognixia.jump.jdbc.ems.sqlconnection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectToSQL {

	// sinlgeton 
	private static Connection connect;
	
	private static void makeConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("----Registered Driver!");
			
			Properties props = new Properties();
			props.load(new FileInputStream("resource/config.properties"));
			

			String url = props.getProperty("url");
			String username = props.getProperty("username");
			String password = props.getProperty("password");

			connect = DriverManager.getConnection(url, username, password);
			System.out.println("Connected");
			
		} catch (SQLException e) {
			System.err.println("could not make connection");
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * this just checks if the singleton object has been connected
	 * 
	 * @return Connection object
	 */
	public static Connection getConnection() {
		if (connect == null) {
			makeConnection();
		}
		return connect;
	}
}
