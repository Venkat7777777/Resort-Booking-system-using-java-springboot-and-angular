package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Booking;
import com.examly.springapp.repository.BookingRepo;

@Service

public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepo bookingRepo;

    @Override
    public Booking getBookingById(Long id) {
        
    Booking booking=bookingRepo.findById(id).orElse(null);
    if(booking==null){
    return null;
    //Exception
    
    }else{
    
      return booking;
    }
    
    }

    @Override
    public List<Booking> getBookingsByUserId(Long userId) {
    
    
    return    bookingRepo.findByUser_UserId(userId);

        
        }
        
    

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();

    }

    @Override
    public Booking addBooking(Booking booking) {
       
      return bookingRepo.save(booking);
    }

    @Override
    public Boolean deleteBooking(Long id) {
        Booking booking=bookingRepo.findById(id).orElse(null);

        if(booking==null){
        return false;
        //Exception
        }else{
        
        bookingRepo.delete(booking);
        return true;
        
        }
        
    }

    @Override
    public Booking updateBookingStatus(Long id, String newStatus) {
     Booking booking=bookingRepo.findById(id).orElse(null);
    if(booking==null){
     return null;
     //Exception
    }else{

    booking.setStatus(newStatus);
    bookingRepo.save(booking);
    return booking;
    }   
    }


    
}
