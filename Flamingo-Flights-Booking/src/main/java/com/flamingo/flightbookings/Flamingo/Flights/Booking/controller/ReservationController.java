package com.flamingo.flightbookings.Flamingo.Flights.Booking.controller;

import com.flamingo.flightbookings.Flamingo.Flights.Booking.dto.CreateReservationRequest;
import com.flamingo.flightbookings.Flamingo.Flights.Booking.dto.UpdateReservationRequest;
import com.flamingo.flightbookings.Flamingo.Flights.Booking.entities.FlightsData;
import com.flamingo.flightbookings.Flamingo.Flights.Booking.entities.Reservations;
import com.flamingo.flightbookings.Flamingo.Flights.Booking.services.FlightDataServices;
import com.flamingo.flightbookings.Flamingo.Flights.Booking.services.NextSequenceService;
import com.flamingo.flightbookings.Flamingo.Flights.Booking.services.PassengerServices;
import com.flamingo.flightbookings.Flamingo.Flights.Booking.services.ReservationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ReservationController
{
    // Domestic Flights : 8% GST
    private float additionalTaxes = 0.08f;
    @Autowired
    private ReservationServices reservationServices;

    @Autowired
    private NextSequenceService nextSequenceService;
    @Autowired
    private FlightDataServices flightDataServices;

    @Autowired
    private PassengerServices passengerServices;

    @GetMapping("/reservation/amount/{id}")
    public float getReservationAmount(@PathVariable int id)
    {
        float amt = reservationServices.getReservationById(id).getFlightBooked().getAmount();
        int seatBooked = reservationServices.getReservationById(id).getNoOfSeats();
        float applicableTax = amt * additionalTaxes;
        float totalAmt = (amt + applicableTax) * seatBooked;
        System.out.println("Total Amount" + totalAmt);
        return totalAmt;
    }

    @GetMapping("/reservation/{id}")
    public Reservations getReservation(@PathVariable int id)
    {
        return reservationServices.getReservationById(id);
    }

    @RequestMapping(value = "/reservation", method = RequestMethod.POST)
    @Transactional
    public Reservations saveReservation(@RequestBody CreateReservationRequest reservationsData) {
        FlightsData flight = flightDataServices.getFlightById(reservationsData.getFlightId());
        float amount = flight.getAmount() * reservationsData.getNoOfSeats();
        float applicableTax = amount * additionalTaxes;
        float totalAmt = amount + applicableTax;
        flight.setAmount(totalAmt);
        System.out.println("Total Amount" + totalAmt);
        Reservations reservation = new Reservations();
        reservation.setReservationId(nextSequenceService.getNextSequence("customSequences"));
        reservation.setFlightBooked(flight);
        reservation.setPassengersList(reservationsData.getpList());
        reservation.setNoOfSeats(reservationsData.getNoOfSeats());
        reservation.setNoOfBags(0);
        System.out.println("Save Reservation F ID" +reservationsData.getFlightId());
        System.out.println("Save Reservation pList" +reservationsData.getpList());
        reservation.setCheckIn(false);
        System.out.println("Save Reservation Seats" +reservationsData.getNoOfSeats());
        System.out.println("Reservation Data" +reservation);

        return reservationServices.confirmReservation(reservation);

        }

    @PutMapping(value = "/reservation")
    public Reservations updateReservation(@RequestBody UpdateReservationRequest request) {
        System.out.println("ID : "+request.getId()+"Bags : " + request.getNumberOfBags() +"Check in :"+ request.isCheckIn());
        Reservations reservation = reservationServices.getReservationById(request.getId());
        reservation.setNoOfBags(request.getNumberOfBags());
        reservation.setCheckIn(request.isCheckIn());
        return reservationServices.confirmReservation(reservation);
    }
    }
