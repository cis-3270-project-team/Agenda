package programBackbone;

public class Method {

	public Customer register(String firstN, String lastN, String userN, String pass, String email, 
								String securityQ, String address, String state, int zip, int sSN) {

		Customer c1 = new Customer(firstN, lastN,  userN, pass, email, securityQ, address, state, zip, sSN);
		
		try {
			insertIntoDatabase(c1);
			
			return c1;
		}
		catch (Exception e){
			System.out.println(e);
		}
		return null;
		
	}
	
	public User login(String userN, String pass) {
		
		try {
			User u1 = selectFromDatabeas(userN, pass);
		
			return u1;
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	
}
