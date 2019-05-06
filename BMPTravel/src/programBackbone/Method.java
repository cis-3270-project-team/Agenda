package programBackbone;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import database.DBMethod;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import userInterface.AlertBox;
import userInterface.ForgotPasswordNext;
import userInterface.ForgotPasswordPage;
import userInterface.HomePage;
import userInterface.HomepageAdmin;
import userInterface.MainMenu;
import userInterface.RegisterWindow;
import userInterface.SearchOutbound;
import userInterface.SearchReturnFlights;
import userInterface.UpdateFlightsTable;

public class Method {

	public static void mainMenu(Stage window) {
		
		MainMenu main = new MainMenu();
		try {
			main.start(window);
		}
		catch(Exception e2) {
			e2.printStackTrace();
		}
	}
	
	public static Object register(Stage window) {

		RegisterWindow registerwindow = new RegisterWindow(); 

		try {
			registerwindow.start(window);
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void forgotStage1 (Stage window) {
		
		try {
			ForgotPasswordPage forgotPage = new ForgotPasswordPage();
			
			forgotPage.start(window);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void forgotStage2 (Stage window) {
		
		ForgotPasswordNext next = new ForgotPasswordNext();

		try { 
			next.start(window);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void homepageAdmin(Stage window, Admin a1) {
		HomepageAdmin homepage = new HomepageAdmin();
		
		try {
			homepage.start(window, a1);
		}
		catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	public static void updateTable(Stage window, Admin a1) {
		
		UpdateFlightsTable updateTable = new UpdateFlightsTable();

		try {
		
			updateTable.start(window, a1);
			
		}
		catch(Exception ufte) {
			System.out.println(ufte);
			ufte.printStackTrace();
		}
	}
	
	public static void searchReturn(Stage window, User u1) {
		
		SearchReturnFlights searchReturn = new SearchReturnFlights();
		
		try {
			searchReturn.start(window, u1);
		}
		catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	public static void searchFlights(Stage window, User u1) {
		
		SearchOutbound searchFlights = new SearchOutbound();
		
		try {
			searchFlights.start(window, u1);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void homepage(Stage window, User u1) {
		
		HomePage homepage = new HomePage();
		try {
			homepage.start(window, u1);
		}
		catch(Exception exc) {
			System.out.println(exc);
			exc.printStackTrace();
		}
	}
	
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
			
		if (DBMethod.userNameExists(user) || user.length() == 0) {
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
		
		if (DBMethod.emailExists(email)) {
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

	
	public static boolean bookFlight(User u1, ObservableList<Flights> flights) {
		
		Flights f1 = (Flights) flights;
		
		DBMethod.isBooked(u1, f1);
		
		int seats = DBMethod.checkSeats(f1);
		
		if(seats > 0) {
			seats -= 1;
			if(DBMethod.book(u1, f1, seats)) {
				return true;
			}
		}
		return false;
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

}
