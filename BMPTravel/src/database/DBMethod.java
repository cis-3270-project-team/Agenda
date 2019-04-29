package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import programBackbone.Method;

public class DBMethod {

	public static void createFlightTable() {
		try {
			Connection conn = Method.getConnection();
			
			PreparedStatement create = conn.prepareStatement("CREATE TABLE IF NOT EXISTS flight(id int NOT NULL, numberflight int, "
					+ "airline varchar(30), origin_city varchar(30), destination_city varchar(30), departure_time varchar(30), "
					+ "arrival_time varchar(30), departure_date date, arrival_date date, capactiy int, seats_availavle int, "
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
	
	public static void createUserTable() {
		try {
			Connection conn = Method.getConnection();
			
			PreparedStatement create = conn.prepareStatement("CREATE TABLE IF NOT EXISTS user(user_email varchar(40) NOT NULL PRIMARY KEY, "
					+ "firstname varchar(30), lastname varchar(30), address varchar(30), zipcode int(5), username varchar(30), "
					+ "password varchar(15), ssn varchar(9), security_question varchar(90), security_answer varchar(90))");
			
			
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
}
