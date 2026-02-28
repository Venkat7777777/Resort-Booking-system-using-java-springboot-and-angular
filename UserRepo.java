package com.examly.springapp.repository;
 
import java.util.Optional;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.examly.springapp.model.User;
 
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
 
   Optional<User> findByUsername(String username);
   Optional<User> findByEmailOrUsername(String email,String username);
   Optional<User> findByUserRole(String userRole);
   
}