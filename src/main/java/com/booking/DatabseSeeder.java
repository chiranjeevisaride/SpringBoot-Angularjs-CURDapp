package com.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chiranjeevi on 1/3/2017.
 */
@Component
public class DatabseSeeder implements CommandLineRunner {

    private BookingRepository bookingRepository;

    @Autowired
    public  DatabseSeeder(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<HotelBooking> bookings = new ArrayList<HotelBooking>();
        bookings = new ArrayList<>();
        bookings.add(new HotelBooking("Marriot", 200.50,3));
        bookings.add(new HotelBooking("Novotel", 100.40,5));
        bookings.add(new HotelBooking("Taj", 150.50,7));
        bookingRepository.save(bookings);
    }
}
