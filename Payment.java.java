package com.examly.springapp.model;
import java.util.Date;
 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
 
@Entity
public class Payment {
 
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private  Long id;
   
   private String userName;
 
   private String resortName;
 
   private Long totalPrice;
 
   private Date currDate;
 
   private String token;
 
public Payment() {
}
 
@Override
public String toString() {
    return "Payment [id=" + id + ", userName=" + userName + ", resortName=" + resortName + ", totalPrice=" + totalPrice
            + ", currDate=" + currDate + ", token=" + token + "]";
}
 
@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
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
    Payment other = (Payment) obj;
    if (id == null) {
        if (other.id != null)
            return false;
    } else if (!id.equals(other.id))
        return false;
    return true;
}
 
public Payment(Long id, String userName, String resortName, Long totalPrice, Date currDate, String token) {
    this.id = id;
    this.userName = userName;
    this.resortName = resortName;
    this.totalPrice = totalPrice;
    this.currDate = currDate;
    this.token = token;
}
 
public Long getId() {
    return id;
}
 
public void setId(Long id) {
    this.id = id;
}
 
public String getUserName() {
    return userName;
}
 
public void setUserName(String userName) {
    this.userName = userName;
}
 
public String getResortName() {
    return resortName;
}
 
public void setResortName(String resortName) {
    this.resortName = resortName;
}
 
public Long getTotalPrice() {
    return totalPrice;
}
 
public void setTotalPrice(Long totalPrice) {
    this.totalPrice = totalPrice;
}
 
public Date getCurrDate() {
    return currDate;
}
 
public void setCurrDate(Date currDate) {
    this.currDate = currDate;
}
 
public String getToken() {
    return token;
}
 
public void setToken(String token) {
    this.token = token;
}
 
   
 
   
 
}