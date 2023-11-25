package com.flamingo.flightbookings.Flamingo.Flights.Booking.services;

import com.flamingo.flightbookings.Flamingo.Flights.Booking.entities.FlightsData;
import com.flamingo.flightbookings.Flamingo.Flights.Booking.repository.FlightDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class FlightDataServices
{
    @Autowired
    private FlightDataRepository flightDataRepository;

    public FlightsData getFlightById(String flightId)
    {
        return flightDataRepository.findById(flightId).get();
    }

    public List<FlightsData> getAllFlight()
    {
        return flightDataRepository.findAll();
    }

    public List<FlightsData> getFlightsOnDate(String source, String destination, String date)
    {
        return flightDataRepository.searchFlights(source, destination, date);
    }
    public List<FlightsData> getFlightsOnDate2(String source, String destination, Date date2)
    {
        return flightDataRepository.searchFlightsDate2(source, destination, date2);
    }

    public FlightsData addFlightData(FlightsData flightsData)
    {
        return flightDataRepository.save(flightsData);
    }


}
