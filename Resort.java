package com.examly.springapp.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Resort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long resortId;

    private String resortName;
    private String resortImageUrl;
    private String resortLocation;
    private String resortAvailableStatus;
    private Long price;
    private int capacity;
    private String description;
    private boolean isActive;

    public Resort(Long resortId, String resortName, String resortImageUrl, String resortLocation,
            String resortAvailableStatus, Long price, int capacity, String description, boolean isActive) {
        this.resortId = resortId;
        this.resortName = resortName;
        this.resortImageUrl = resortImageUrl;
        this.resortLocation = resortLocation;
        this.resortAvailableStatus = resortAvailableStatus;
        this.price = price;
        this.capacity = capacity;
        this.description = description;
        this.isActive = isActive;
    }
    
    

    public Resort() {
    }



    public boolean isActive() {
        return isActive;
    }

    

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    

    
    @Override
    public String toString() {
        return "Resort [resortId=" + resortId + ", resortName=" + resortName + ", resortImageUrl=" + resortImageUrl
                + ", resortLocation=" + resortLocation + ", resortAvailableStatus=" + resortAvailableStatus + ", price="
                + price + ", capacity=" + capacity + ", description=" + description + ", isActive=" + isActive + "]";
    }


    public Long getResortId() {
        return resortId;
    }
    public void setResortId(Long resortId) {
        this.resortId = resortId;
    }
    public String getResortName() {
        return resortName;
    }
    public void setResortName(String resortName) {
        this.resortName = resortName;
    }
    public String getResortImageUrl() {
        return resortImageUrl;
    }
    public void setResortImageUrl(String resortImageUrl) {
        this.resortImageUrl = resortImageUrl;
    }
    public String getResortLocation() {
        return resortLocation;
    }
    public void setResortLocation(String resortLocation) {
        this.resortLocation = resortLocation;
    }
    public String getResortAvailableStatus() {
        return resortAvailableStatus;
    }
    public void setResortAvailableStatus(String resortAvailableStatus) {
        this.resortAvailableStatus = resortAvailableStatus;
    }
    public Long getPrice() {
        return price;
    }
    public void setPrice(Long price) {
        this.price = price;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((resortId == null) ? 0 : resortId.hashCode());
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
        Resort other = (Resort) obj;
        if (resortId == null) {
            if (other.resortId != null)
                return false;
        } else if (!resortId.equals(other.resortId))
            return false;
        return true;
    }


}
