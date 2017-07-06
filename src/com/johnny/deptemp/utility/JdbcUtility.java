package com.johnny.deptemp.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtility {
	static final String Database_URL = "jdbc:mysql://localhost:3306/DEPTEMP_TEST";
	private static final String USER = "johnny";
	private static final String PW = "123";
	
	
	public static Connection getConnection() throws SQLException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		
		Connection conn = DriverManager.getConnection(Database_URL, USER, PW);
		return conn;
	}

}
