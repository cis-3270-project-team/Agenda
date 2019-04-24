package programBackbone;

public class Customer extends User {

	private String address;
	
	private String state;
	
	private int zip;
	
	private int sSN;
	
	Customer(){
		
	}
	
	Customer(String firstN, String lastN, String userN, String pass, String email, String securityQ, String address, String state, int zip, int sSN){
		super(firstN, lastN, userN, pass, email, securityQ);
		this.address = address;
		this.state = state;
		this.zip = zip;
		this.sSN = sSN;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public int getsSN() {
		return sSN;
	}

	public void setsSN(int sSN) {
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
	public void removeFlight(Object flight) {// use to remove a booking from a flight
		// details unknown
		
	}

	@Override
	public Object getFlight() { // use to get flights from the database
		// details unknown
		return null;
	}


}
