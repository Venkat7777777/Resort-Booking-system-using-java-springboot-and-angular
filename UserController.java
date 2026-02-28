package com.examly.springapp.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
 
import com.examly.springapp.configuration.JwtUtils;
import com.examly.springapp.dto.JwtResponse;
import com.examly.springapp.dto.MessageDto;
import com.examly.springapp.model.User;
import com.examly.springapp.service.UserService;
import com.examly.springapp.repository.UserRepo;
import java.util.Optional;
 
@RestController
@CrossOrigin(origins =  "https://8081-eebeaebbeccaababacfcbfebecfedabaadcb.premiumproject.examly.io")
public class UserController {
 
   @Autowired
    private UserService userService;
 
    @Autowired
    private UserRepo userRepo;
 
    @Autowired
    private JwtUtils jwtService;
 
    @Autowired
    private AuthenticationManager authenticationManager;
 
    @Autowired
    PasswordEncoder passwordEncoder;
 
 
    @PostMapping("/api/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        System.out.println("************Register : "+user);
        userService.registerUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(true);
    }
 
    @PostMapping("/api/login")
    public ResponseEntity<?> AuthenticateAndGetToken(@RequestBody User user){
        JwtResponse jwtResponse = null;
        Optional<User> optUser = userRepo.findByUsername(user.getUsername());
        if(optUser.isPresent()){
            User existingUser = optUser.get();
            if(passwordEncoder.matches(user.getPassword(),existingUser.getPassword())){
                jwtResponse = new JwtResponse();
                jwtResponse.setToken(jwtService.GenerateToken(existingUser.getUsername()));
                jwtResponse.setUserId(existingUser.getUserId());
                jwtResponse.setUserRole(existingUser.getUserRole());
                System.out.println("Login response  :");
                System.out.println(jwtResponse);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username");
        }
       
        return  ResponseEntity.status(HttpStatus.OK).body(jwtResponse);
    }
 
    @GetMapping("/api/welcome")
    public ResponseEntity<?> welcomeEndPoint(){
        MessageDto res = new MessageDto();
        res.message = "Welcome to this application";
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
 
    @GetMapping("/api/user")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<?> userEndPoint(){
        MessageDto res = new MessageDto();
        res.message = "User endpoint accessed";
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
   
    @GetMapping("/api/admin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> adminEndPoint(){
        MessageDto res = new MessageDto();
        res.message = "Admin endpoint accessed";
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
 
   
}