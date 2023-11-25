package com.flamingo.flightbookings.Flamingo.Flights.Booking.repository;

import com.flamingo.flightbookings.Flamingo.Flights.Booking.entities.FlightsData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FlightDataRepository extends MongoRepository<FlightsData, String>
{
    @Query("{'source' : :#{#source}, 'destination' : :#{#destination}, 'journeyDate' : :#{#journeyDate}}")
    List<FlightsData> searchFlights(@Param("source") String source, @Param("destination") String destination, @Param("journeyDate") String journeyDate );

    @Query("{'source' : :#{#source}, 'destination' : :#{#destination}, 'date2' : :#{#date2}}")
    List<FlightsData> searchFlightsDate2(@Param("source") String source, @Param("destination") String destination, @Param("date2") Date date2 );

}
