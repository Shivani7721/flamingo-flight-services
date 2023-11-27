package com.flamingo.flightbookings.Flamingo.Flights.Booking.repository;

import com.flamingo.flightbookings.Flamingo.Flights.Booking.entities.Passengers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends MongoRepository<Passengers, Integer> {
}
