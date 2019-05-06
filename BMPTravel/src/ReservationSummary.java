import java.util.Date;

public class ReservationSummary {
	


		private String airline;	
		private String originCity;
		private String destinationCity;
		private String departureTime;
		private Date arrivalTime;
		private Date departureDate;
		private Date arrivalDate;
		 

		    public ReservationSummary(){
		    }

		    public ReservationSummary(String airline, String originCity, String destinationCity,Date departureDate, Date arrivalDate, Date departureTime, Date arrivalTime){
		    
		    	this.airline = airline;
		    	this.destinationCity= destinationCity;
		    	this.originCity = originCity;
		    	this.departureDate = departureDate;
		    	this.departureDate = departureTime;
		    	this.arrivalTime = arrivalTime;
		    
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

			public String getDepartureTime() {
				return departureTime;
			}

			public void setDepartureTime(String departureTime) {
				this.departureTime = departureTime;
			}

			public Date getArrivalTime() {
				return arrivalTime;
			}

			public void setArrivalTime(Date arrivalTime) {
				this.arrivalTime = arrivalTime;
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
	}
		       
		       

		    
