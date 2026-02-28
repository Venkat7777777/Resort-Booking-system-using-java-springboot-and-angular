package com.examly.springapp.dto;
 
public class JwtResponse {
    private String token;
    private Long userId;
    private String userRole;
    private String username;
   
    public JwtResponse() {
    }
 
    public JwtResponse(String token, Long userId, String userRole, String username) {
        this.token = token;
        this.userId = userId;
        this.userRole = userRole;
        this.username = username;
    }
 
    public String getToken() {
        return token;
    }
 
    public void setToken(String token) {
        this.token = token;
    }
 
    public Long getUserId() {
        return userId;
    }
 
    public void setUserId(Long userId) {
        this.userId = userId;
    }
 
    public String getUserRole() {
        return userRole;
    }
 
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }    
 
   
 
    @Override
    public String toString() {
        return "JwtResponse [token=" + token + ", userId=" + userId +", userRole="+userRole+ "]";
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
}