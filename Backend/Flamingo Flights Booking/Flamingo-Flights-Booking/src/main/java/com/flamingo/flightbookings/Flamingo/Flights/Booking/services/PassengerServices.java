package com.flamingo.flightbookings.Flamingo.Flights.Booking.services;

import com.flamingo.flightbookings.Flamingo.Flights.Booking.entities.Passengers;
import com.flamingo.flightbookings.Flamingo.Flights.Booking.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerServices
{
    @Autowired
    private PassengerRepository passengerRepository;

    public void addPassenger(Passengers passenger)
    {
        passengerRepository.save(passenger);
    }

    public void addAllPassenger(List<Passengers> passengers)
    {
        passengerRepository.saveAll(passengers);
    }
}
