package com.examly.springapp.controller;
import org.springframework.web.bind.annotation.RestController;
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
import com.examly.springapp.model.Resort;
import com.examly.springapp.service.ResortServiceImpl;

@RestController
//write your link
@CrossOrigin(origins ="https://8081-eebeaebbeccaababacfcbfebecfedabaadcb.premiumproject.examly.io/")

public class ResortController {

    @Autowired
    private ResortServiceImpl resortservice;

    @PostMapping("/api/resort")
    public ResponseEntity<?>addResort(@RequestBody Resort resort){
        return ResponseEntity.status(HttpStatus.CREATED).body(resortservice.addResort(resort));
    }

    @GetMapping("/api/resort")
    public ResponseEntity<?>getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(resortservice.getAllResorts());
    }

    @GetMapping("/api/resort/{resortId}")
    public ResponseEntity<?>getById(@PathVariable Long resortId){
        return ResponseEntity.status(HttpStatus.OK).body(resortservice.getResortId(resortId));
    }

    @PutMapping("/api/resort/{resortId}")
    public ResponseEntity<?>updateResort(@PathVariable Long resortId,@RequestBody Resort resort){
        return ResponseEntity.status(HttpStatus.OK).body(resortservice.updateResort(resortId, resort));
    }

    @DeleteMapping("/api/resort/{resortId}")
    public ResponseEntity<?>deleteResort(@PathVariable Long resortId){
        // if(resortservice.deleteResort(resortId)){
            return ResponseEntity.status(HttpStatus.OK).body(resortservice.deleteResort(resortId));
        // }else{
        //     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Not Exist");
        // }
        
    }
     
}
