package com.flamingo.flightbookings.Flamingo.Flights.Booking.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "FlightData")
public class FlightsData
{
    @Id
    private String flightId;
    private String flightName;
    private String source;
    private String destination;
    private String journeyDate;
//    private Date date2;
    private String departureTime;
    private String arrivalTime;
    private float amount;

    public FlightsData() {
    }


    public FlightsData(String flightId, String flightName, String source, String destination, String journeyDate/*,Date date2*/, String departureTime, String arrivalTime, float amount) {
        this.flightId = flightId;
        this.flightName = flightName;
        this.source = source;
        this.destination = destination;
        this.journeyDate = journeyDate;
//        this.date2 = date2;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.amount = amount;
    }

//    public Date getDate2() {
//        return date2;
//    }
//
//    public void setDate2(Date date2) {
//        this.date2 = date2;
//    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(String journeyDate) {
        this.journeyDate = journeyDate;
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

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "FlightsData{" +
                "flightId='" + flightId + '\'' +
                ", flightName='" + flightName + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", journeyDate='" + journeyDate + '\'' +
             //   ", date2=" + date2 +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", amount=" + amount +
                '}';
    }
}
