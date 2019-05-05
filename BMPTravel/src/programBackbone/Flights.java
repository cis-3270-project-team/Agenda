package programBackbone;


import java.util.Date;


public class Flights {

	public static void main(String[]args){
		
	}
    private String airline;			
    private String originCity;		
    private String destinationCity;	
    private int flightCapacity;		
    private int flightNumber;		
    private Date departureDate;		
    private Date arrivalDate;		
    private String departureTime;	
    private String arrivalTime;		
    private int seatsAvailable;		
    private Boolean isFilled;		

    public Flights() {

    }

    public Flights(String airline, String originCity, String destinationCity, int flightCapacity, int seats_available, int flightNumber, 
    		Date departureDate, Date arrivalDate, String departureTime, String arrivalTime, boolean isFilled) 
    {
    	this.airline = airline;
    	this.originCity = originCity;
        this.destinationCity = destinationCity;
        this.flightCapacity = flightCapacity;
        this.seatsAvailable = seats_available;
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.isFilled = isFilled;
        
    }

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getOriginCity() {
		return originCity;
	}

	public void setOriginCity(String originCity) {
		this.originCity = originCity;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public int getFlightCapacity() {
		return flightCapacity;
	}

	public void setFlightCapacity(int flightCapacity) {
		this.flightCapacity = flightCapacity;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Boolean getIsFilled() {
		return isFilled;
	}

	public void setIsFilled(Boolean isFilled) {
		this.isFilled = isFilled;
	}

	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	@Override
	public String toString() {
		return "Flights [airline=" + airline + ", originCity=" + originCity
				+ ", destinationCity=" + destinationCity + ", flightCapacity="
				+ flightCapacity + ", flightNumber=" + flightNumber
				+ ", departureDate=" + departureDate + ", arrivalDate="
				+ arrivalDate + ", departureTime=" + departureTime
				+ ", arrivalTime=" + arrivalTime + ", isFilled=" + isFilled
				+ ", getAirline()=" + getAirline() + ", getOriginCity()="
				+ getOriginCity() + ", getDestinationCity()="
				+ getDestinationCity() + ", getFlightCapacity()="
				+ getFlightCapacity() + ", getFlightNumber()="
				+ getFlightNumber() + ", getDepartureDate()="
				+ getDepartureDate() + ", getArrivalDate()=" + getArrivalDate()
				+ ", getDepartureTime()=" + getDepartureTime()
				+ ", getArrivalTime()=" + getArrivalTime() + ", getIsFilled()="
				+ getIsFilled() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}
    
