package com.infosys.jdbc_prepared_statement_crud.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class LaptopConnection {
	public static Connection getLaptopConnection() {
		try {
			//step-1 load/register driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			//step-2 create connection
			String url = "jdbc:mysql://localhost:3306/jdbc-a5";
			String user = "root";
			String pass = "root";
			
			return DriverManager.getConnection(url, user, pass);
		} catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		
	}
}
