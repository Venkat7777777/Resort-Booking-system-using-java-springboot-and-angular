package com.examly.springapp.service;
 
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
 
import com.examly.springapp.exceptions.UserExistException;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepo;
 
@Service
public class UserServiceImpl implements UserService {
 
    @Autowired
    private UserRepo userRepo;
 
    @Autowired
    private PasswordEncoder passwordEncoder;
 
    public boolean registerUser(User user){
        User existUser = userRepo.findByUsername(user.getUsername()).orElse(null);
        if(existUser != null){
            throw new UserExistException();
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepo.save(user);
        return true;
       
    }
    public User getUserId(long userId){
        Optional<User> optional=userRepo.findById(userId);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }
   
}