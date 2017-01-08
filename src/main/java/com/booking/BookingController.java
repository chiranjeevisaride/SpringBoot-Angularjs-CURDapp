package com.booking;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Chiranjeevi on 1/2/2017.
 */
@RestController
@RequestMapping(value = "/bookings")
@Api(name="Hotel Booking API", description = "Provides a list of methods that manage hotel booking", stage = ApiStage.RC)
public class BookingController {

    private BookingRepository bookingRepository;

    @Autowired
    public BookingController(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiMethod(description = "Get all hotel bookings from the database")
    public List<HotelBooking> getAll(){
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/affordable/{price}", method = RequestMethod.GET)
    @ApiMethod(description = "Get all Affordable hotel bookings where Price Per Night is less than provided value")
    public  List<HotelBooking> getAffortable(@ApiPathParam(name="price") @PathVariable double price){
    return  bookingRepository.findByPricePerNightLessThan(price);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes="application/json")
    @ApiMethod(description="Create a hotel booking and save it to the database")
    public List<HotelBooking> createBooking(@RequestBody HotelBooking hotelBooking){
        System.out.print("Inside Controller");
    bookingRepository.save(hotelBooking);
    return  bookingRepository.findAll();
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.POST)
    @ApiMethod(description = "Remove the hotel booking with the provided ID from the database")
    public List<HotelBooking> deleteBooking(@ApiPathParam(name="id") @PathVariable long id){
        bookingRepository.delete(id);
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public HotelBooking editBooking(@PathVariable long id){
        return bookingRepository.findOne(id);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST, consumes="application/json")
    public void editBooking(@RequestBody HotelBooking booking){
        bookingRepository.save(booking);
        //return bookingRepository.findAll();
    }
}
