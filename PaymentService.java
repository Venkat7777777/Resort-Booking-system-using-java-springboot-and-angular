package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Payment;
import com.examly.springapp.repository.PaymentRepo;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    public List<Payment> getPayments(){
        return paymentRepo.findAll();
    }

    public Payment getById(Long id){
        return paymentRepo.findById(id).orElse(null);
        //exception
    }
    public Payment addPayment(Payment payment ){
        return paymentRepo.save(payment);
    }
    
}
