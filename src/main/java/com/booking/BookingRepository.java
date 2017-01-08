package com.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Chiranjeevi on 1/3/2017.
 */
@Repository
public interface BookingRepository extends JpaRepository<HotelBooking,Long>{

    List<HotelBooking> findByPricePerNightLessThan(double price);
}
