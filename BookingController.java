package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Booking;
import com.examly.springapp.service.BookingService;

@RestController
@CrossOrigin(origins = "https://8081-eebeaebbeccaababacfcbfebecfedabaadcb.premiumproject.examly.io/")
public class BookingController {
    
@Autowired 
private BookingService bookingService;



@GetMapping("api/booking/{bookingId}")
public ResponseEntity<?> getBookingById(@PathVariable Long bookingId){
	 Booking booking=bookingService.getBookingById(bookingId);
        if(booking == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("error");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(booking);
        }
}

@GetMapping("/api/booking/user/{userId}")
public ResponseEntity<?> getBookingsByUserId(@PathVariable Long userId){
	return ResponseEntity.status(HttpStatus.OK).body(bookingService.getBookingsByUserId(userId));
}

 
@GetMapping("/api/booking")
public ResponseEntity<?> getAllBookings(){
	return ResponseEntity.status(HttpStatus.OK).body(bookingService.getAllBookings());
}

@PostMapping("/api/booking")
public ResponseEntity<?> addBooking(@RequestBody Booking booking){

    return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.addBooking(booking));
}

@DeleteMapping("api/booking/{bookingId}")
public ResponseEntity<?> deleteBooking(@PathVariable Long bookingId ){
    return ResponseEntity.status(HttpStatus.OK).body(bookingService.deleteBooking(bookingId));
}

@PutMapping("/api/booking/{bookingId}")
public ResponseEntity<?> updateBookingStatus(@PathVariable Long bookingId , @RequestBody Booking updatedBooking){
    return ResponseEntity.status(HttpStatus.OK).body(bookingService.updateBookingStatus(bookingId,updatedBooking.getStatus()));
}

 


}

