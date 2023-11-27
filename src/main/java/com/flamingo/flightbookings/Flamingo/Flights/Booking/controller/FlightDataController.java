package com.flamingo.flightbookings.Flamingo.Flights.Booking.controller;

import com.flamingo.flightbookings.Flamingo.Flights.Booking.entities.FlightsData;
import com.flamingo.flightbookings.Flamingo.Flights.Booking.services.FlightDataServices;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class FlightDataController
{
    @Autowired
    private FlightDataServices flightDataServices;

    @GetMapping("/")
    public String home()
    {
        return "Hey Welcome to Flamingo Home";
    }
    @GetMapping("/flights")
    public List<FlightsData> getAllFlights()
    {
        return flightDataServices.getAllFlight();
    }

    @GetMapping("/flights/{id}")
    public FlightsData getFlightById(@PathVariable String id)
    {
        return flightDataServices.getFlightById(id);
    }

    @GetMapping("/flights/{source}/{destination}/{journeyDate}")
    public List<FlightsData> getFlightByData(@PathVariable("source") String sourceLocation,@PathVariable("destination") String destinationLocation, @PathVariable("journeyDate") String journeyDate){
        return flightDataServices.getFlightsOnDate(sourceLocation, destinationLocation, journeyDate);
    }

    // Not working API : used "Date" datatype for journey date from client to server request
    @GetMapping("/flight2/{source}/{destination}/{date2}")
    public List<FlightsData> getFlightByData(@PathVariable("source") String sourceLocation,
                                             @PathVariable("destination") String destinationLocation,
                                             @PathVariable("date2") @DateTimeFormat(pattern="dd-MM-yyyy") Date date2)
    {
        System.out.println("********************************************");
        System.out.println("Here is your Flight Search Details ");
        System.out.println("List :"+ flightDataServices.getFlightsOnDate2(sourceLocation, destinationLocation, date2));
        System.out.println("Date :"+ date2);
        System.out.println("********************************************");
        return flightDataServices.getFlightsOnDate2(sourceLocation, destinationLocation, date2);
    }

    @PostMapping("/flight")
    public ResponseEntity<Void> addFlight(@RequestBody FlightsData flightData)
    {
        flightDataServices.addFlightData(flightData);
        return ResponseEntity.ok().build();
    }

}
