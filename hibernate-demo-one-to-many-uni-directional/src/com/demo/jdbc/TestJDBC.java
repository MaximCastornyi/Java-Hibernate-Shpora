package com.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-04-one-to-many-uni";
		String user = "root";
		String password = "08082006";
		
		try {
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("Connection Works");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
