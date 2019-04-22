package Objects;

import java.security.PrivateKey;
import java.util.Date;
import java.util.Time;

public class Flights {

    Private String airline;
    Private String originCity;
    Private String destinationCityl;
    Private int flightCapacity;
    Private int flightNumber;
    Private Date departureDate;
    Private Date arrivalDate;
    Private Time departureTiume;
    Private Time arrivalTime;
    Private Time TimeStamp;
    Private Boolean isFilled;

    public Flights() {

    }

    public Flights(String airline, String originCity, String destinationCity, int flightCapacity, int flightNumber, Date departureDate, Date arrivalDate, Time departureTime, Time arrivalTime) 
    {
    	Super();
    	this.airline = airline;
    	this.originCity = originCity;
        this.destinationCity = destinationCity;
        this.flightCapacity = flightCapacity;
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.arrivalTime = arrivalTime
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }


    public String getairline(){
       return airline;
    }
    
    public void setAirline(String airline) {
        this.airline = airline;
    }
    
    public String getoriginCity() {
        return originCity;
    }
    
    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }
    
    public String getdestinationCity() {
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
    
    public Date
