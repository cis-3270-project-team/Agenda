package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBMethod {

	public static Connection getConnection() throws Exception{
		
		try {
			String driver = "com.mysqul.jdbc.Driver";
			String url = "jdbc:" + oracle connection
			String username = username;
			String password = password;
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, username, password);
			
			return conn;
		}
		catch (Exception e) {
			System.out.println(e);
			
		}
		return null;	
	}
}
