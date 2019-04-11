package programBackbone;

public class Customer extends User {

	String address;
	
	String state;
	
	int zip;
	
	int sSN;
	
	Customer(){
		
	}
	
	Customer(String firstN, String lastN, String userN, String pass, String email, String securityQ, String address, String state, int zip, int sSN){
		super(firstN, lastN, userN, pass, email, securityQ);
		this.address = address;
		this.state = state;
		this.zip = zip;
		this.sSN = sSN;
	}
	
	@Override
	public String getPassword() { // use to give the user their password when they forget only if they have securityAnswer
		// details unknown
		
		return super.getPassword();
	}
	
	@Override
	public void bookFlight() { // use to register a user (and friends) on a flight
		// details unknown
		
	}
	
	@Override
	public void removeFlight() { // use to remove a booking from a flight
		// details unknown
	}
}
