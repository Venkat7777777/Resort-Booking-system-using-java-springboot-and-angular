package com.examly.springapp.model;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

 
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;
 
 
    private int rating;
    private String comment;
    private Date dateCreated;
   
 
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
 
    @ManyToOne
    @JoinColumn(name = "resort_id")
    private Resort resort;
 
    public Review() {
    }
 
    public Review(int reviewId, int rating, String comment, Date dateCreated, User user, Resort resort) {
        this.reviewId = reviewId;
        this.rating = rating;
        this.comment = comment;
        this.dateCreated = dateCreated;
        this.user = user;
        this.resort = resort;
    }
 
    public int getReviewId() {
        return reviewId;
    }
 
    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }
 
    public int getRating() {
        return rating;
    }
 
    public void setRating(int rating) {
        this.rating = rating;
    }
 
    public String getComment() {
        return comment;
    }
 
    public void setComment(String comment) {
        this.comment = comment;
    }
 
    public Date getDateCreated() {
        return dateCreated;
    }
 
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
 
    public User getUser() {
        return user;
    }
 
    public void setUser(User user) {
        this.user = user;
    }
 
    public Resort getResort() {
        return resort;
    }
 
    public void setResort(Resort resort) {
        this.resort = resort;
    }
 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + reviewId;
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Review other = (Review) obj;
        if (reviewId != other.reviewId)
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "Review [reviewId=" + reviewId + ", rating=" + rating + ", comment=" + comment + ", dateCreated="
                + dateCreated + ", user=" + user + ", resort=" + resort + "]";
    }
 
//  
//    @JoinColumn(name = "booking_id")
//    private Booking booking;
 
}
 
