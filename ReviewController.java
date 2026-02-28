package com.examly.springapp.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
 
 
import com.examly.springapp.model.Review;
import com.examly.springapp.service.ReviewService;
 
 
@RestController
 
@CrossOrigin(origins="https://8081-eebeaebbeccaababacfcbfebecfedabaadcb.premiumproject.examly.io/")
 
public class ReviewController {
 
    @Autowired
    private ReviewService reviewService;
 
    @GetMapping("/api/review")
    public ResponseEntity<?> getAllReviews(){
        return ResponseEntity.status(HttpStatus.OK).body(reviewService.getAllReviews());
    }
 
    @PostMapping("/api/review")
    public ResponseEntity<?> addReview(@RequestBody Review review){
        if(review == null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Review not found");
        }else{
            return ResponseEntity.status(HttpStatus.CREATED).body(reviewService.addReview(review));
        }    
    }
   
    // @GetMapping("/api/review/user/{userId}")
    // public ResponseEntity<?> findReviewsByUserId(@RequestParam Long userId){
    //     return ResponseEntity.status(HttpStatus.OK).body(reviewService.getReviewsByUserId(userId));
    // }

    @GetMapping("/api/review/{resortId}")
    public ResponseEntity<?> getReviewsByResortId(@PathVariable Long resortId){
        return ResponseEntity.status(HttpStatus.OK).body(reviewService.getReviewsByResortId(resortId));
    }
}
 