package com.examly.springapp.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Booking;
import com.examly.springapp.model.Resort;
import com.examly.springapp.model.Review;
import com.examly.springapp.repository.ResortRepo;
import com.examly.springapp.repository.ReviewRepo;
 
@Service
public class ReviewServiceImpl implements ReviewService{
 
    @Autowired
    private ReviewRepo reviewRepo;

    @Autowired
    private ResortRepo resortRepo;
 
    @Override
    public List<Review> getAllReviews() {
        return reviewRepo.findAll();
    }
 
    @Override
    public Review addReview(Review review) {
        return reviewRepo.save(review);
    }
 
    // @Override
    // public List<Review> getReviewsByUserId(Long userId) {
    //     List<Review> reviewList = reviewRepo.getReviewsByUserId(userId);
    //     if(reviewList==null){
    //         return null;
    //         //Exception
    //     }else{
    //         return reviewList;
    //     }
    // }
 
    @Override
    public List<Review> getReviewsByResortId(Long resortId) {
     Resort resort=resortRepo.findById(resortId).orElse(null);
     return reviewRepo.findByResort(resort);
    }
}
 
