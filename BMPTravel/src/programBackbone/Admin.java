package programBackbone;

import database.DBMethod;

public class Admin extends User {
	
		private int accountType = 1;
		
	public Admin(){
		
	}
	
	public Admin(String firstN, String lastN, String userN, String email){
		super(firstN, lastN, userN, email);
		
	}
		
	public Admin(String firstN, String lastN, String userN, String pass, String email, String securityQ, String securityA){
		super(firstN, lastN, userN, pass, email, securityQ, securityA);
	}
	
	public int getAccountType() {
		return accountType;
	}
	
	public void register(Admin a1) {
		
			DBMethod.registerUser(a1);
	}
	
}
