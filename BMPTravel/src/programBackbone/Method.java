package programBackbone;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Method {
	
	//used to register a new User (Customer only right now)
	public static void registerUser(User u1) {
		
		// find out if it is a Customer (admin option is below)
		if (u1 instanceof Customer) {
			Customer c1 = (Customer) u1;
			
			// establish a connection with the database
			Connection conn = getConnection();
			
			// make an insert statement for the customer's information
			String insertUser = "INSERT INTO user(user_email, firstname, lastname, address, zipcode, username, "
					+ "password, ssn, security_question, secutity_answer) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			try {//create the statement that inserts the Customer's information into the database
				PreparedStatement preState = conn.prepareStatement(insertUser);
				
				// fill in the variables with the Customer's info
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
						
				// a broad catch if anything goes wrong
			}catch (Exception e) {
				System.out.println("Exception in register User method");
				System.out.println(e);
			}
			
		}
		//find out if user is an Admin (Customer option is above)
		if (u1 instanceof Admin) {
			Admin a1 = (Admin) u1;
			
			// establish a connection with the database
			Connection conn = getConnection();
			
			// make an insert statement for the admin's information
			String insertUser = "INSERT INTO user(user_email, firstname, lastname, username, "
					+ "password, security_question, secutity_answer) values (?, ?, ?, ?, ?, ?, ?)";
			
			try {//create the statement that inserts the Admin's information into the database
				PreparedStatement preState = conn.prepareStatement(insertUser);
				
				// fill in the variables with the admin's info
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
		
				// a broad catch if anything goes wrong
			}catch (Exception e) {
				System.out.println("Exception in register User method");
				System.out.println(e);
			}
		
		}
	}

	//used to allow a User to login to the program
	public static User login(String userN, String pass) {
		
		// make sure the user name and password are not null
		if (userN != null && pass != null) {
			
		
			try {
				// establish a connection with the database
				Connection conn = getConnection();
				
				//create the statement that pulls the appropriate User information
				String loginStr = "SELECT * FROM user WHERE username = ? and password = ?";
				PreparedStatement preparedLogin = conn.prepareStatement(loginStr);
				
				// put in the values missing in the login statement above
				preparedLogin.setString(1, userN);
				preparedLogin.setString(2, pass);
				
				//execute the statement and get the results
				ResultSet results = preparedLogin.executeQuery();
					
				// keep only what is needed to create a User instance for the program to use
				String email = results.getString("user_email");
				String userName = results.getString("username");
				String firstName = results.getString("firstname");
				String lastName = results.getString("lastname");
				int accountType = results.getInt("accounttype");
					
				
				// find out if the user is an admin or customer, then make an instance of the class
				if (accountType == 1) {
					Admin a1 = new Admin(firstName, lastName, userName, email);
					
					return a1;
				}
				
				else {
					Customer c1 = new Customer(firstName, lastName, userName, email);
					
					return c1;
				}
			
			}// a broad catch if anything goes wrong
			catch (Exception e) {
				System.out.println(e);
			}
		}
		return null;
	}
	
	//used to connect to the database
	public static Connection getConnection() {
		
		try {
		//	the driver is not needed for the current version of JDK
	//		String driver = "com.mysql.jdbc.Driver";
	//		Class.forName(driver);
			String url = "jdbc:mysql://localhost:3306/demo";
			String name = "root";
			String pass = "toor";
			
			//The actual connection to the database 
			Connection conn = DriverManager.getConnection(url, name, pass);
			
			//lets the programmers know the connection has succeeded
			System.out.println("connected to database");
			
			//returns the connection to the caller 
			return conn;
			
			//A catch if the connection is not where the url says it should be
		}catch(NullPointerException npe) {
			System.out.println("database not found");
		
		}//a broad catch if anything else goes wrong
		catch(Exception e) {
			
		}
		
		//returns something if the try statement fails
		return null;
	}

	// used to get flights from the database
	public static ArrayList<Flights> SearchFlights(String cityA, String cityB) { 
		
		//make an ArrayList to store more then one flight
		ArrayList<Flights> flights = new ArrayList<>();
		
		try {
			// connect to the database
			Connection conn = Method.getConnection();
			
			//create the statement that pulls the appropriate Flights information
			String queryStr = "select * from flights where origin_city=? and destination_city=?";
			PreparedStatement preparedQuery = conn.prepareStatement(queryStr);
			
			// put in the values missing in the login statement above
			preparedQuery.setString(1, cityA);
			preparedQuery.setString(2, cityB);
			
			//pull the information from the database
			ResultSet result = preparedQuery.executeQuery();
			
			//loop until there are no more flights that match the query
			while(result.next()) {
				
				//get the information on a single flight
				String origin_city = result.getString("origin_city");
				String destination_city = result.getString("destination_city");
				String departure_time = result.getString("departure_time");
				Date departure_date = result.getDate("departure_date");
				int seats_available = result.getInt("seats_abailable");
				
				//make a flight instance with the information
				Flights f1 = new Flights(origin_city, destination_city, departure_date, departure_time, seats_available);
			
				// add the new flight to the flight ArrayList
				flights.add(f1);
			}
			//return the ArrayList full of flights
			return flights;
			
		}//a broad catch if anything else goes wrong
		catch (Exception e) {
			System.out.println(e);
		}
		//return null if something goes wrong
		return null;
	}
}
