package programBackbone;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import userInterface.AlertBox;

public class Method {
	
	//used to check if the String contains only numbers
	public static boolean isInt(String number) {
		
		int length = number.length();
		
		for (int t = 0; t > length; t++) {
			if(number.charAt(t) > 9 || number.charAt(t) < 0) {
				return false;
			}
		}
		
		return true;
	}
	
	//used to register a new User (Customer only right now)
	public static void registerUser(User u1) {
		
		// find out if it is a Customer (admin option is below)
		if (u1 instanceof Customer) {
			Customer c1 = (Customer) u1;
			
			// establish a connection with the database
			Connection conn = getConnection();
			
			// make an insert statement for the customer's information
			String insertUser = "INSERT INTO user(user_email, firstname, lastname, address, zipcode, state, username, "
					+ "password, ssn, security_question, security_answer, accounttype) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			try {//create the statement that inserts the Customer's information into the database
				PreparedStatement preState = conn.prepareStatement(insertUser);
				
				// fill in the variables with the Customer's info
				preState.setString(1, c1.getEmail());
				preState.setString(2, c1.getFirstName());
				preState.setString(3, c1.getLastName());
				preState.setString(4, c1.getAddress());
				preState.setInt(5, c1.getZip());
				preState.setString(6, c1.getState());
				preState.setString(7, c1.getUserName());
				preState.setString(8, c1.getPassword());
				preState.setInt(9, c1.getsSN());
				preState.setString(10, c1.getSecurityQuestion());
				preState.setString(11, c1.getSecurityAnswer());
				preState.setInt(12, c1.getAccountType());
				
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
					
				while (results.next()) {
					// keep only what is needed to create a User instance for the program to use
					String email = results.getString("user_email");
					String userName = results.getString("username");
					String firstName = results.getString("firstname");
					String lastName = results.getString("lastname");
					int accountType = results.getInt("accounttype");
					
				
					// find out if the user is an admin or customer, then make an instance of the class
					if (accountType == 1) {
						Admin a1 = new Admin(firstName, lastName, userName, email);
						
						//close the database connection
						conn.close();
					
						return a1;
					}
				
					else {
						Customer c1 = new Customer(firstName, lastName, userName, email);
						
						//close the database connection
						conn.close();
					
						return c1;
					}
				}
			}
			catch (SQLException sqle) {
				System.out.println(sqle);
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
	public static ObservableList<Flights> searchFlights() { 
		
		//make an ObservableList to store more then one flight
		ObservableList<Flights> flights = FXCollections.observableArrayList();
		
		try {
			// connect to the database
			Connection conn = Method.getConnection();
			
			//unknown statement for unknown reasons (to be looked into)
			Statement Stmt = conn.createStatement();
			
			//select from the database
			ResultSet result = Stmt.executeQuery("select * from flights");
			
			//loop until there are no more flights that match the query
			while(result.next()) {
				
				//get the information on a single flight
				String airline = result.getString("airline");
				String origin_city = result.getString("origin_city");
				String destination_city = result.getString("destination_city");
				int flightCapacity = result.getInt("capactiy");
				int seats_available = result.getInt("seats_available");
				int flightNumber = result.getInt("numberflight");
				Date departure_date = result.getDate("departure_date");
				Date arrivalDate = result.getDate("arrival_date");
				String departure_time = result.getString("departure_time");
				String arrival_time = result.getString("arrival_time");
				int isFilled = result.getInt("isfull");
				
				boolean isFull;
				
				if (isFilled > 0) {
					isFull = true;
				}
				else {
					isFull = false;
				}
				//make a flight instance with the information
				Flights f1 = new Flights(airline, origin_city, destination_city, flightCapacity, seats_available, flightNumber,
							departure_date, arrivalDate, departure_time, arrival_time, isFull);
			
				// add the new flight to the flight ArrayList
				flights.add(f1);
			}
			//return the ArrayList full of flights
			return flights;
			
		}//a broad catch if anything else goes wrong
		catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return null;
	}

	// used to make sure the flight is not already booked by the user
	public static boolean isBooked(User u1, Flights f1) {
		
		
		int flightID = f1.getFlightNumber();
		
		String user = u1.getEmail();
		
		try {
			
			Connection conn = getConnection();
		
			String searchStr = "SELECT user_name FROM ticket WHERE user_email = ? AND flightid = ?";
		
			PreparedStatement preparedSearch = conn.prepareStatement(searchStr);
		
			preparedSearch.setString(1, user);
			preparedSearch.setInt(2, flightID);
		
			ResultSet result = preparedSearch.executeQuery();
		
			String exists = null;
			while(result.isBeforeFirst()) {
				
				exists = result.getString("user_name");
			}
			
			if (exists != null) {
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// used to make sure the new user entered all the needed information
	public static boolean checkRegistry(String first, String last,String user, String pass, String email, String question, String answer,
										String address, String state, String zip, String ssn) {
		if(first.length() == 0) {
			AlertBox.display("First Name", "You Must Enter a Name for \"First Name\"");
			return false;
		}
		
		if(last.length() == 0) {
			AlertBox.display("Last Name", "You Must Enter a Name for \"Last Name\"");
			return false;
		}
		if (user.length() == 0) {
			AlertBox.display("User Name", "You Must Enter a Name for \"User Name\"");
			return false;
		}
			
		if (userNameExists(user) || user.length() == 0) {
			AlertBox.display("User Name", "The User Name You Entered Already Exists");
			return false;
		}
		
		
	//	if (!validPass(pass)) {
	//		AlertBox.display("Invalid Password", "Your Password Must Match or Surpass our Requirments");
	//		return false;
	//	}
		
		if (email.length() == 0) {
			AlertBox.display("E-Mail", "You must Enter an E-Mail Address for \"E-Mail\"");
			return false;
		}
		
		if (emailExists(email)) {
			AlertBox.display("E-Mail", "The User E-Mail You Entered Already Exists");
			return false;
		}
		
		if (question.equalsIgnoreCase("Select a Question")) {
			AlertBox.display("Security Question", "You Must Pick a Question");
			return false;
		}
		
		if (answer.length() == 0) {
			AlertBox.display("Security Answer", "You Must Enter Something for the Answer\nThis is for Your Own Good");
			return false;
		}
		
		if (address.length() == 0) {
			AlertBox.display("Address", "You Must Enter an Address for \"Address\"");
			return false;
		}
		
		if (state.length() == 0) {
			AlertBox.display("State", "You Must Enter a State for \"State\"");
			return false;
		}
		
		if (!isInt(zip) || zip.length() == 0) {
			AlertBox.display("Zip Code", "You Must Enter a valid Zip Code for \"Zip Code\"");
			return false;
		}
		
		if (!isInt(ssn) || ssn.length() != 9) {
			AlertBox.display("Social Security Number", "You Must Enter a valid Social Security Number for \"Social Security Number\"");
			return false;
		}
		
		
		return true;
	}

	// used to make sure the email is unique in the database
 	public static boolean emailExists(String email) {
		
		try {
			Connection conn = getConnection();
			
			String searchStr = "SELECT user_email FROM user WHERE user_email = ?";
			
			PreparedStatement preparedSearch = conn.prepareStatement(searchStr);
			
			preparedSearch.setString(1, email);
			
			ResultSet result = preparedSearch.executeQuery();
			
		//	String exists = null;
			while(result.next()) {
				
		//		exists  = result.getString("user_email");		
				return true;
			}
			
		//	if (exists != null) {
		//		return true;
		//	}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
 // used to make sure the user name is unique in the database
	public static boolean userNameExists(String userName) {
		
		try {
			Connection conn = getConnection();
			
			String searchStr = "SELECT username FROM user WHERE username = ?";
			
			PreparedStatement preparedSearch = conn.prepareStatement(searchStr);
			
			preparedSearch.setString(1, userName);
			
			ResultSet result = preparedSearch.executeQuery();
			
			String exists = null;
			while(result.next()) {
				
				exists  = result.getString("username");				
			}
			
			if (exists != null) {
				return true;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public static boolean bookFlight(User u1, ObservableList<Flights> flights) {
		
		Flights f1 = (Flights) flights;
		
		isBooked(u1, f1);
		
		int seats = checkSeats(f1);
		
		if(seats > 0) {
			seats -= 1;
			if(book(u1, f1, seats)) {
				return true;
			}
		}
		return false;
	}

	private static boolean book(User u1, Flights f1, int seats) {

		Connection conn = getConnection();
		
		String bookStr = "INSERT INTO ticket(User_email, numberflight) VALUES (?, ?)";
		
		String markFlightsStr = "UPDATE flights SET seats_available = ? WHERE numberflight = ?";
		
	
		
		try {
			
			PreparedStatement preBook = conn.prepareStatement(bookStr);
			PreparedStatement preMarkFlights = conn.prepareStatement(markFlightsStr);
			
			preBook.setString(1, u1.getEmail());
			preBook.setInt(2, f1.getFlightNumber());
			
			preMarkFlights.setInt(1, seats);
			preMarkFlights.setInt(1, f1.getFlightNumber());
			
			preBook.executeUpdate();
			preMarkFlights.executeUpdate();
			
			conn.close();
			
			return true;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private static int checkSeats(Flights f1) {

		Connection conn = getConnection();
		
		String seatsStr = "SELECT seats_available FROM flights WHERE numberflight = ?";
		
		try {
			PreparedStatement preSeats = conn.prepareStatement(seatsStr);
		
			preSeats.setInt(1, f1.getFlightNumber());
			
			ResultSet set = preSeats.executeQuery();
			
			while(set.next()) {
				
				int seats_available = Integer.parseInt(set.getString("seats_available"));
				
				return seats_available;
			}
			
		}
		catch(NullPointerException npe) {
			AlertBox.display("Problem", "The Flight You Are Trying To Book Does Not Seem To Exist");
			npe.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	public static Flights makeFlight(String airline, String originCity, String destinationCity, String flightCapacityStr, 
			String flightNumberStr, String departureDateStr, String arrivalDateStr, String departureTime, String arrivalTime, 
			String seatsAvailableStr, CheckBox isFilledBox) {
		
		int flightCapacity = 0, seatsAvailable = 0, flightNumber = 0;
		
		boolean isFilled;
		
		Date departureDate = null, arrivalDate = null;
		
		if (isInt(flightCapacityStr)){
			flightCapacity = Integer.parseInt(flightCapacityStr);
		}
		
		if (isInt(seatsAvailableStr)) {
			seatsAvailable = Integer.parseInt(seatsAvailableStr);
		}
		
		if (isInt(flightNumberStr)) {
			flightNumber = Integer.parseInt(flightNumberStr);
		}
		
		if (isFilledBox.isSelected()) {
			isFilled = true;
		}
		else {
			isFilled = false;
		}
		
		try {
		departureDate = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(departureDateStr);
		
		arrivalDate = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(arrivalDateStr);
		}
		catch (Exception dateE) {
			AlertBox.display("Problem", "You may have formated the dates incorrectly\nInput = \" " + arrivalDateStr + "\" and \"" + 
					departureDateStr + "\"\n \t It should be in a dd/mm/yyyy format");
		}
		
		Flights f1 = new Flights(airline, originCity, destinationCity, flightCapacity, seatsAvailable, flightNumber, 
				departureDate, arrivalDate, departureTime, arrivalTime, isFilled);
	
		return f1;
	}

	public static boolean addFlight(Flights f1) {
		
		Connection conn = getConnection();
		
		String addFlightStr = "INSERT INTO flights(numberflight, airline, origin_city, destination_city, departure_time,"
				+ " arrival_time, departure_date, arrival_date, capactiy, seats_available, seats_occupied, isfull) VALUSE"
				+ " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement preAddFlight = conn.prepareStatement(addFlightStr);
			
			preAddFlight.setInt(1, f1.getFlightNumber());
			preAddFlight.setString(2, f1.getAirline());
			preAddFlight.setString(3, f1.getOriginCity());
			preAddFlight.setString(4, f1.getDestinationCity());
			preAddFlight.setString(5, f1.getDepartureTime());
			preAddFlight.setString(6, f1.getArrivalTime());
			preAddFlight.setDate(7, (Date) f1.getDepartureDate());
			preAddFlight.setDate(8, (Date) f1.getArrivalDate());
			preAddFlight.setInt(9, f1.getFlightCapacity());
			preAddFlight.setInt(10, f1.getSeatsAvailable());
			preAddFlight.setInt(11,f1.getFlightCapacity() - f1.getSeatsAvailable());
			preAddFlight.setBoolean(12, f1.getIsFilled());
			
			preAddFlight.executeUpdate();
			
			conn.close();
			
			return true;
			
		}
		catch (Exception e) {
			AlertBox.display("Problem", "There was a problem putting the new flight into the database");
			e.printStackTrace();
		}
		return false;
	}

	
	public static boolean removeFlight(ObservableList<Flights> flight) {
		
		Flights f1 = (Flights) flight;
		
		Connection conn = getConnection();
		
		String removeFlightStr = "REMOVE FROM flights WHERE numberflight = ?";
		
		try {
			PreparedStatement removeFlight = conn.prepareStatement(removeFlightStr);
			
			removeFlight.setInt(1, f1.getFlightNumber());
			
			removeFlight.executeUpdate();
			
			conn.close();
			
			return true;
		}
		catch (Exception e) {
			AlertBox.display("Problem", "There was a problem removing the flight from the database");
			e.printStackTrace();
		}
		return false;
	}
}
