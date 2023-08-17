package com.flamingo.flightbookings.Flamingo.Flights.Booking.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Reservations")
public class Reservations
{
    @Id
    private int reservationId;
    private boolean checkIn;
    private int noOfSeats;

    private int noOfBags;

    private List<Passengers> passengersList;

    @DBRef
    private FlightsData flightBooked;

    public Reservations() {
    }

    public Reservations(int reservationId, boolean checkIn, int noOfSeats, int noOfBags, List<Passengers> passengersList, FlightsData flightBooked) {
        this.reservationId = reservationId;
        this.checkIn = checkIn;
        this.noOfSeats = noOfSeats;
        this.noOfBags = noOfBags;
        this.passengersList = passengersList;
        this.flightBooked = flightBooked;
    }

    public int getNoOfBags() {
        return noOfBags;
    }

    public void setNoOfBags(int noOfBags) {
        this.noOfBags = noOfBags;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public boolean isCheckIn() {
        return checkIn;
    }

    public void setCheckIn(boolean checkIn) {
        this.checkIn = checkIn;
    }

    public int getNoOfSeats() {
        return this.noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public List<Passengers> getPassengersList() {
        return passengersList;
    }

    public void setPassengersList(List<Passengers> passengersList) {
        this.passengersList = passengersList;
    }

    public FlightsData getFlightBooked() {
        return flightBooked;
    }

    public void setFlightBooked(FlightsData flightBooked) {
        this.flightBooked = flightBooked;
    }

    @Override
    public String toString() {
        return "Reservations{" +
                "reservationId=" + reservationId +
                ", checkIn=" + checkIn +
                ", noOfSeats=" + noOfSeats +
                ", noOfBags=" + noOfBags +
                ", passengersList=" + passengersList +
                ", flightBooked=" + flightBooked +
                '}';
    }
}
