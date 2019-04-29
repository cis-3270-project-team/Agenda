package programBackbone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Method {
	
	public static void insertIntoDatabase(User u1) {
		// find out if it is a Customer
		if (u1 instanceof Customer) {
			Customer c1 = (Customer) u1;
			
			// establish a connection
			Connection conn = getConnection();
			
			// make an insert statement for the customer
			String insertUser = "INSERT INTO user(user_email, firstname, lastname, address, zipcode, username, "
					+ "password, ssn, security_question, secutity_answer) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			try {
				PreparedStatement preState = conn.prepareStatement(insertUser);
				
				// fill in the variables with the customers info
				preState.setString(1, c1.getEmail());
				preState.setString(2, c1.getFirstName());
				preState.setString(3, c1.getLastName());
				preState.setString(4, c1.getAddress());
				preState.setInt(5, c1.getZip());
				preState.setString(6, c1.getUserName());
				preState.setString(7, c1.getPassword());
				preState.setInt(8, c1.getsSN());
				preState.setString(9, c1.getSecurityQuestion());
				preState.setString(10, c1.getSecurityAnswer());
				
				// send the info to the database
				preState.executeUpdate();
				
				//close the connection
				conn.close();
						
				
			}catch (Exception e) {
				System.out.println("Exception in insert into database method");
				System.out.println(e);
			}
			
		}
		//find out if user is an Admin
		if (u1 instanceof Admin) {
			Admin a1 = (Admin) u1;
			
			// establish a connection
			Connection conn = getConnection();
			
			// make an insert statement for the admin
			String insertUser = "INSERT INTO user(user_email, firstname, lastname, username, "
					+ "password, security_question, secutity_answer) values (?, ?, ?, ?, ?, ?, ?)";
			
			try {
				PreparedStatement preState = conn.prepareStatement(insertUser);
				
				// fill in the variables with the customers info
				preState.setString(1, a1.getEmail());
				preState.setString(2, a1.getFirstName());
				preState.setString(3, a1.getLastName());
				preState.setString(4, a1.getUserName());
				preState.setString(5, a1.getPassword());
				preState.setString(6, a1.getSecurityQuestion());
				preState.setString(7, a1.getSecurityAnswer());
				
				// send the info to the database
				preState.executeUpdate();
				
				//close the connection
				conn.close();
		
			}catch (Exception e) {
				System.out.println("Exception in insert into database method");
				System.out.println(e);
			}
		
		}
	}

	public static User login(String userN, String pass) {
		
		try {
			User u1 = selectFromDatabeas(userN, pass);
			
			if (u1 instanceof Customer) {
				Customer c1 = (Customer) u1;
				return c1;
			}
			if (u1 instanceof Admin) {
				Admin a1 = (Admin) u1;
				return a1;
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	
	public static Connection getConnection() {
		
		try {
	//		String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/demo";
			String name = "root";
			String pass = "toor";
	//		Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, name, pass);
			
			System.out.println("connected to database");
			
			return conn;
			
		}catch(NullPointerException npe) {
			System.out.println("database not found");
		}
		catch(Exception e) {
			
		}
		finally {
			System.out.println("after the connection");
		}
		
		return null;
	}
	
}
