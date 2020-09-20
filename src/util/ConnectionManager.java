package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static final String url = "jdbc:postgresql://localhost:5433/RailwaySystem";
	private static final String user = "postgres";
	private static final String password = "tea1999";
		
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			System.out.println("Connection error "+ e);
			return null;
		}
	}
		
}