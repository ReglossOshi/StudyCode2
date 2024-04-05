package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {
	private static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String USER = "jsp";
	private static final String PASSWORD = "123456";
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
	}	
}