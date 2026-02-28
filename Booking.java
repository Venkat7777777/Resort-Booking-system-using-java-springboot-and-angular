package com.examly.springapp.model;
 
import java.util.Date;
 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
 
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long bookingId;
 
    private int noOfPersons;
    private Date toDate;
    private Date fromDate;
    private double totalPrice;
    private String address;
    private String status;
    private  String token;
 
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
 
    @ManyToOne
    @JoinColumn(name = "resort_id")
    private Resort resort;
 
    @Override
    public String toString() {
        return "Booking [bookingId=" + bookingId + ", noOfPersons=" + noOfPersons + ", toDate=" + toDate + ", fromDate="
                + fromDate + ", totalPrice=" + totalPrice + ", address=" + address + ", status=" + status + ", token="
                + token + ", user=" + user + ", resort=" + resort + "]";
    }
 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bookingId == null) ? 0 : bookingId.hashCode());
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
        Booking other = (Booking) obj;
        if (bookingId == null) {
            if (other.bookingId != null)
                return false;
        } else if (!bookingId.equals(other.bookingId))
            return false;
        return true;
    }
 
    public Booking() {
    }
 
    public Booking(Long bookingId, int noOfPersons, Date toDate, Date fromDate, double totalPrice, String address,
            String status, String token, User user, Resort resort) {
        this.bookingId = bookingId;
        this.noOfPersons = noOfPersons;
        this.toDate = toDate;
        this.fromDate = fromDate;
        this.totalPrice = totalPrice;
        this.address = address;
        this.status = status;
        this.token = token;
        this.user = user;
        this.resort = resort;
    }
 
    public Long getBookingId() {
        return bookingId;
    }
 
    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }
 
    public int getNoOfPersons() {
        return noOfPersons;
    }
 
    public void setNoOfPersons(int noOfPersons) {
        this.noOfPersons = noOfPersons;
    }
 
    public Date getToDate() {
        return toDate;
    }
 
    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
 
    public Date getFromDate() {
        return fromDate;
    }
 
    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }
 
    public double getTotalPrice() {
        return totalPrice;
    }
 
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
 
    public String getAddress() {
        return address;
    }
 
    public void setAddress(String address) {
        this.address = address;
    }
 
    public String getStatus() {
        return status;
    }
 
    public void setStatus(String status) {
        this.status = status;
    }
 
    public String getToken() {
        return token;
    }
 
    public void setToken(String token) {
        this.token = token;
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
 
 
   
}