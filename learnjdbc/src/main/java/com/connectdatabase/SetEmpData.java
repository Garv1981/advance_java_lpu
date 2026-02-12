package com.connectdatabase;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class SetEmpData {
	public static void main(String []args) {
		// Load the driver class 
		
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Class loaded");
			
			// to establish connection
			String url = "jdbc:postgresql://localhost:5433/college";
			String un = "postgres";
			String pwd = "root";
			try {
				Connection  connect = DriverManager.getConnection(url,un,pwd);
				System.out.println("connection created");
				String sql = "insert into employee values (3,'lallan','CSE')";
				
				//create stmt
				Statement stmt = connect.createStatement();
				stmt.execute(sql);
				connect.close();
				System.out.println("data inserted");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
