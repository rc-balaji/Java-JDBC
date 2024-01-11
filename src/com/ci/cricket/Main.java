package com.ci.cricket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class Main {

	public static void main(String[] args) {
		Connection connection = null;
		try {


			Statement statement = connection.createStatement();
			
			String queryString1 = "INSERT INTO cricketDB.PlayerTable "
					+ "(name, totalRuns,average,highestScore) VALUES "
					+ "('RaM',30483,48.5,200),"
					+ "('Sachin',30483,48.5,200),"
					+ "('Sam',30483,48.5,200)";
			
			String queryString2 = "SELECT * from cricketDB.PlayerTable";
			
			
			System.out.println("ID\t\tName\t\t\tHS\t\tAverage");
			
			boolean res = statement.executeUpdate(queryString1)==1?true:false;
			
			if(res) {
				System.out.println("Successfully Insert!!!!");
			}else {
				System.out.println("Failed Insert!!!!");
				
			}
			ResultSet result = statement.executeQuery(queryString2);
			
			while(result.next()) {
				System.out.printf("%s\t\t%s\t%s\t\t%s\n",""+result.getInt("id"),""+result.getString("name"),""+result.getInt("highestScore"),""+result.getFloat("average"));
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}

	}

}
