package com.flamingo.flightbookings.Flamingo.Flights.Booking.dto;

import com.flamingo.flightbookings.Flamingo.Flights.Booking.entities.Passengers;

import java.util.List;


// These DTO classes are used to get required data from client side easily
public class CreateReservationRequest {

    private String flightId;

    private int noOfSeats;
    List<Passengers> pList;

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public List<Passengers> getpList() {
        return pList;
    }

    public void setpList(List<Passengers> pList) {
        this.pList = pList;
    }
}
