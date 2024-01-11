package com.ci.cricket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	
	private Connection connection = null;

	public Connection getConnection() throws SQLException {
		
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cricketDB", "root", "");
		return connection;
	}
	
	
	public void closeConnection() throws SQLException {
		
		connection.close();
	}
	
	
	
}
