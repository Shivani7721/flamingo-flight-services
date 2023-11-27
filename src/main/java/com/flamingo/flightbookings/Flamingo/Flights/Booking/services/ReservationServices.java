package com.flamingo.flightbookings.Flamingo.Flights.Booking.services;

import com.flamingo.flightbookings.Flamingo.Flights.Booking.entities.Reservations;
import com.flamingo.flightbookings.Flamingo.Flights.Booking.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServices
{
    @Autowired
    private ReservationRepository reservationRepository;

    public Reservations confirmReservation(Reservations reservations)
    {
        return reservationRepository.save(reservations);
    }

    public Reservations getReservationById(int id)
    {
        return reservationRepository.findById(id).get();
    }
    public float getReservationAmount(float amount, int noOfSeats)
    {
        return amount * noOfSeats;
    }
}
