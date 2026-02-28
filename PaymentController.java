package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Payment;
import com.examly.springapp.service.PaymentService;

@RestController
@CrossOrigin(origins = "https://8081-eebeaebbeccaababacfcbfebecfedabaadcb.premiumproject.examly.io/")
public class PaymentController {

@Autowired
private PaymentService paymentService;

@GetMapping("api/payment")
public ResponseEntity<?> getAllPayments(){
    return ResponseEntity.status(HttpStatus.OK).body(paymentService.getPayments());
}
    
@GetMapping("api/payment/{id}")
public ResponseEntity<?> getPaymentById(@PathVariable Long id){
    return ResponseEntity.status(HttpStatus.OK).body(paymentService.getById(id));
}

@PostMapping("api/payment")
public ResponseEntity<?> addPayment(@RequestBody Payment payment){
    return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.addPayment(payment));
}
}

