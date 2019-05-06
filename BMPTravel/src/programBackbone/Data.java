package programBackbone;

public class Data {

	Flights flight;
	
	User user;
	
	public Data() {
		
	}
	
	public Data(Flights flight) {
		this.flight = flight;
	}
	
	public Data(User user) {
		this.user = user;
	}
	
	public Data(Flights flight, User user) {
		this.flight = flight;
		this.user = user;
	}

	public Flights getFlight() {
		return flight;
	}

	public void setFlight(Flights flight) {
		this.flight = flight;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
