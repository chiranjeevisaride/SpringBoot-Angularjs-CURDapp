package com.booking;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Chiranjeevi on 1/2/2017.
 */
@Entity
public class HotelBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String hotelName;
    private double pricePerNight;
    public int noOfNights;

    public HotelBooking(){}

    public HotelBooking(String hotelName, double pricePerNight, int noOfNights) {
        this.hotelName = hotelName;
        this.pricePerNight = pricePerNight;
        this.noOfNights = noOfNights;
    }

    public long getId() { return id; }

    public String getHotelName() {
        return hotelName;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public int getNoOfNights() {
        return noOfNights;
    }

    public double getTotalPrice(){
        return pricePerNight*noOfNights;
    }

}
