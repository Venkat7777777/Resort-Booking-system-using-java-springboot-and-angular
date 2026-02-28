package com.examly.springapp.repository;
 
import java.util.List;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.examly.springapp.model.Booking;
import com.examly.springapp.model.Resort;
 
@Repository
public interface BookingRepo extends JpaRepository<Booking,Long>{
 
   List<Booking> findByUser_UserId(Long userId);
   List<Booking> findByResort(Resort resort);
   
}
