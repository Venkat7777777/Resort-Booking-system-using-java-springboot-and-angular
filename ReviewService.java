package com.examly.springapp.service;
import java.util.List;
 
import com.examly.springapp.model.Booking;
import com.examly.springapp.model.Review;
 
public interface ReviewService {
    public List<Review> getAllReviews();
    public Review addReview(Review review);
    // public List<Review> getReviewsByUserId(Long userId);
    List<Review>getReviewsByResortId(Long resortId);
}
 
