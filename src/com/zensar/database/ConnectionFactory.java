package com.zensar.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	static Connection con;
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}	
	public static Connection getConnection(){
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zensar","roshan","hibuddy");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void close(){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



}
