package programBackbone;

public class Customer extends User {

	private String address;
	
	private String state;
	
	private int zip;
	
	private int sSN;  
	
	private int accountType = 0;
	
	Customer(){
		
	}
	
	public Customer(String firstN, String lastN, String userN, String pass, String email, String securityQ, String securityA, String address, String state, int zip, int sSN){
		super(firstN, lastN, userN, pass, email, securityQ, securityA);
		this.address = address;
		this.state = state;
		this.zip = zip;
		this.sSN = sSN;
	}
	
	public Customer(String firstName, String lastName, String userName, String email) {
		super(firstName, lastName, userName, email);
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
	
	public int getAccountType() {
		return accountType;
	}
	
}
