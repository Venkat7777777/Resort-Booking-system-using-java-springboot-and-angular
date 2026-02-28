package com.examly.springapp.repository;
 
import java.util.List;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.examly.springapp.model.Resort;
import com.examly.springapp.model.Review;
 
@Repository
public interface ReviewRepo extends JpaRepository<Review,Integer>{
 
    List<Review> findByResort(Resort resort);
    void deleteByResort(Resort resort);
   
}