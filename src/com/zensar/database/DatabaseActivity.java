package com.zensar.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseActivity {
	static Connection con=ConnectionFactory.getConnection();

	public static void main(String[] args) {
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from employee");
			while (rs.next()) {
				System.out.println("Id:"+rs.getInt("empNo")+"\tName:"+rs.getString("name")+"\tSalary:"+rs.getInt("sal"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
