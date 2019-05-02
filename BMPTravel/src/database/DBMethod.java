package database;

import java.sql.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import programBackbone.Method;

public class DBMethod {

	// backup of the Flight table format, data is in a different method
	public static void createFlightTable() {
		try {
			Connection conn = Method.getConnection();
			
			PreparedStatement create = conn.prepareStatement("CREATE TABLE IF NOT EXISTS flight(id int NOT NULL, numberflight int, "
					+ "airline varchar(30), origin_city varchar(30), destination_city varchar(30), departure_time varchar(30), "
					+ "arrival_time varchar(30), departure_date date, arrival_date date, capactiy int, seats_available int, "
					+ "seats_occupied int, isfull int, PRIMARY KEY(id))");
				
			create.executeUpdate();
			
			conn.close();
			
		}catch (NullPointerException npe) {
			System.out.println(npe);
			System.out.println("something went wrong with create table");
		}
		catch (Exception e) {
			System.out.println(e);
			System.out.println("problem caught by exception");
		}
		finally {
			System.out.println("Done");
		}
		
		
	}
	
	// backup of the User table format, data is in a different method
	public static void createUserTable() {
		try {
			Connection conn = Method.getConnection();
			
			PreparedStatement create = conn.prepareStatement("CREATE TABLE IF NOT EXISTS user(user_email varchar(40) NOT NULL PRIMARY KEY, "
					+ "firstname varchar(30), lastname varchar(30), address varchar(30), zipcode int(5), username varchar(30), "
					+ "password varchar(15), ssn varchar(9), security_question varchar(90), security_answer varchar(90),accounttype int(1))");
			
			
		create.executeUpdate();
		
		conn.close();
		
		}catch (NullPointerException npe) {
			System.out.println(npe);
			System.out.println("something went wrong with create table");
		}
		catch (Exception e) {
			System.out.println(e);
			System.out.println("problem caught by exception");
		}
		finally {
			System.out.println("Done");
		}
		
	}
	
	// backup of the Ticket table format
	public static void createTicketTable() {
		try {
			Connection conn = Method.getConnection();
			
			PreparedStatement create = conn.prepareStatement("CREATE TABLE IF NOT EXISTS ticket(User_email varchar(40), flightid int(6), "
					+ "PRIMARY KEY (user_email, flightid))");
			
			create.executeUpdate();
			
			conn.close();
			
		}catch (NullPointerException npe) {
			System.out.println(npe);
			System.out.println("something went wrong with create table");
		}
		catch (Exception e) {
			System.out.println(e);
			System.out.println("problem caught by exception");
		}
		finally {
			System.out.println("Done");
			}
		
		
	}
	
	// backup of the Flight table format, data is in a different method
	public static void fillUserTable() {
	try {
		//establish a connection with the database
		Connection conn = Method.getConnection();
			
		//prepare a statement for the data
		PreparedStatement fill = conn.prepareStatement("INSERT INTO user(user_email, firstname, lastname, address, zipcode, username,"
				+ " password, ssn, security_question, security_answer, accounttype) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
		//fill in the variables for the first set
		fill.setString(1, "veronica2004@hotmail.com");
		fill.setString(2, "Yvonne");
		fill.setString(3, "Baughn");
		fill.setString(4, "3693 Yorkie Lane, Brunswick");
		fill.setInt(5,  31520);
		fill.setString(6, "retta_bali1977");
		fill.setString(7, "Zaa9ki5ieg");
		fill.setString(8,  "912777696");
		fill.setString(9, "What was the name of your first stuffed animal");
		fill.setString(10, "Lammy");
		fill.setInt(11, 0);
			
		//send the data to the database
		fill.executeUpdate();
		
		//fill in the variables for the second set
		fill.setString(1, "arvel1983@gmail.com");
		fill.setString(2, "Helen");
		fill.setString(3, "Alderman");
		fill.setString(4, "3154 Mount Olive Road");
		fill.setInt(5,  30303);
		fill.setString(6, "lucas_hintz");
		fill.setString(7, "shei5eiW9moh");
		fill.setString(8,  "678807220");
		fill.setString(9, "In what city or town did your mother and father meet");
		fill.setString(10, "Lilburn");
		fill.setInt(11, 0);
		
		//send the data to the database
		fill.executeUpdate();
		
		//fill in the variables for the third set
		fill.setString(1, "laverne_damo@hotmail.com");
		fill.setString(2, "Carl");
		fill.setString(3, "Oliver");
		fill.setString(4, "4050 Junior Avenue");
		fill.setInt(5,  30097);
		fill.setString(6, "mishalq8");
		fill.setString(7, "aith8Iete2Y");
		fill.setString(8,  "404672243");
		fill.setString(9, "Where were you when you had your first kiss");
		fill.setString(10, "Movie theater");
		
		//send the data to the database
		fill.executeUpdate();
		
		//fill in the variables for the fourth set
		fill.setString(1, "cecelia.considi@hotmail.com");
		fill.setString(2, "Blanca");
		fill.setString(3, "Ross");
		fill.setString(4, "1597 D Street");
		fill.setInt(5,  48302);
		fill.setString(6, "sirmuja");
		fill.setString(7, "Hee0JeeGo");
		fill.setString(8,  "586567213");
		fill.setString(9, "In what city or town was your first job");
		fill.setString(10, "Los Angeles");
		
		//send the data to the database
		fill.executeUpdate();
		
		//fill in the variables for the fifth set
		fill.setString(1, "deondre1999@yahoo.com");
		fill.setString(2, "William");
		fill.setString(3, "Gorman");
		fill.setString(4, "908 Brown Avenue");
		fill.setInt(5,  29607);
		fill.setString(6, "lysanne.tr1971");
		fill.setString(7, "Oofai6kah");
		fill.setString(8,  "864982131");
		fill.setString(9, "In what city or town was your first job");
		fill.setString(10, "Hometown");
		
		//send the data to the database
		fill.executeUpdate();
		
		//fill in the variables for the sixth set
		fill.setString(1, "te1995@gmail.com");
		fill.setString(2, "Christine");
		fill.setString(3, "Carter");
		fill.setString(4, "2380 Locust Street,");
		fill.setInt(5, 31701);
		fill.setString(6, "dimondedsword");
		fill.setString(7, "AeQuigail9qu");
		fill.setString(8,  "229691298");
		fill.setString(9, "In what city or town did your mother and father meet");
		fill.setString(10, "London");
		
		//send the data to the database
		fill.executeUpdate();
		
		//fill in the variables for the seventh set
		fill.setString(1, "mattie1976@hotmail.com");
		fill.setString(2, "Lucile");
		fill.setString(3, "Raper");
		fill.setString(4, "225 Sharon Lane");
		fill.setInt(5,  46544);
		fill.setString(6, "margarita.1975");
		fill.setString(7, "Iejoon9Iet9");
		fill.setString(8,  "574291805");
		fill.setString(9, "What was the name of your first stuffed animal");
		fill.setString(10, "Big Bear");
		
		//send the data to the database
		fill.executeUpdate();
		
		//fill in the variables for the eighth set
		fill.setString(1, "marilou_jer@hotmail.com");
		fill.setString(2, "Ronald");
		fill.setString(3, "Notron");
		fill.setString(4, "3015 Badger Pond Lane");
		fill.setInt(5,  33607);
		fill.setString(6, "hook");
		fill.setString(7, "aw8HeiPhei");
		fill.setString(8,  "707377325");
		fill.setString(9, "In what city or town did your mother and father meet");
		fill.setString(10, "At Sea");
		
		//send the data to the database
		fill.executeUpdate();
		
		//fill in the variables for the ninth set
		fill.setString(1, "isadore_kri5@gmail.com");
		fill.setString(2, "Susan");
		fill.setString(3, "Crist");
		fill.setString(4, "959 Hiddenview Drive");
		fill.setInt(5,  19108);
		fill.setString(6, "reta");
		fill.setString(7, "Ohtahru3");
		fill.setString(8,  "215954621");
		fill.setString(9, "Where were you when you had your first kiss");
		fill.setString(10, "Behind the 12th grade cabin");
		
		//send the data to the database
		fill.executeUpdate();
		
		//fill in the variables for the tenth set
		fill.setString(1, "cleve2014@hotmail.com");
		fill.setString(2, "Steven");
		fill.setString(3, "McLean");
		fill.setString(4, "937 Winding Way");
		fill.setInt(5, 20904);
		fill.setString(6, "NerdinhoPlayer");
		fill.setString(7, "le6yo2aiT3oh");
		fill.setString(8,  "401668699");
		fill.setString(9, "In what city or town was your first job");
		fill.setString(10, "Albany, New York");
		
		//send the data to the database
		fill.executeUpdate();
		
		//fill in the variables for the first admin set
		fill.setString(1, "pfowler2@student.gsu.edu");
		fill.setString(2, "Peter");
		fill.setString(3, "Fowler");
		fill.setString(4, "null");
		fill.setInt(5,  0);
		fill.setString(6, "pfowler2");
		fill.setString(7, "AdminPass123");
		fill.setString(8,  "null");
		fill.setString(9, "In what city or town was your first job");
		fill.setString(10, "Atlanta");
		fill.setInt(11, 1);
		
		//send the data to the database
		fill.executeUpdate();
			
		System.out.println("worked");
			
		//close the connection to the database
		conn.close();
		
		}
		catch (NullPointerException npe) {
			System.out.println(npe);
			System.out.println("something went wrong with create table");
		}
		catch (Exception e) {
			System.out.println(e);
			System.out.println("problem caught by exception");
		}
		finally {
			System.out.println("Done");
			
		}
	}

	public static void fillFlightTable() {
		try {
			//establish a connection with the database
			Connection conn = Method.getConnection();
			
			//prepare a statement for the data
			PreparedStatement fill = conn.prepareStatement("INSERT INTO flight(id, numberflight, airline, origin_city, destination_city,"
					+ " departure_time, arrival_time, departure_date, arrival_date, capactiy, seats_available, seats_occupied, isfull)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			//fill in the values for the data
			fill.setInt(1, 0001);
			fill.setInt(2, 001);
			fill.setString(3, "Delta");
			fill.setString(4, "Atlanta");
			fill.setString(5, "New York");
			fill.setString(6, "7:00 am");
			fill.setString(7, "9:17 am");
			fill.setDate(8, Date.valueOf("2019-5-26"));
			fill.setDate(9, Date.valueOf("2019-5-26"));
			fill.setInt(10, 15);
			fill.setInt(11, 15);
			fill.setInt(12, 0);
			fill.setBoolean(13, false);
	
			//send the information to the database
			fill.executeUpdate();
			
			//close the connection to the database
			conn.close();
			
		}catch (NullPointerException npe) {
			System.out.println(npe);
			System.out.println("something went wrong with create table");
		}
		catch (Exception e) {
			System.out.println(e);
			System.out.println("problem caught by exception");
		}
		finally {
			System.out.println("Done");
			}
		}
}
