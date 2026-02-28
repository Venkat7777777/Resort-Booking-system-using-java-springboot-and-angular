package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.Booking;

public interface BookingService {

    Booking getBookingById(Long id);

    List<Booking>  getBookingsByUserId(Long userId);

    List<Booking> getAllBookings();

    Booking addBooking(Booking booking);

    Boolean deleteBooking(Long id);

    Booking updateBookingStatus(Long id,String newStatus);

    
    
}

