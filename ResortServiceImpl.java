package com.examly.springapp.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.examly.springapp.model.Booking;
import com.examly.springapp.model.Resort;
import com.examly.springapp.model.Review;
import com.examly.springapp.repository.BookingRepo;
import com.examly.springapp.repository.ResortRepo;
import com.examly.springapp.repository.ReviewRepo;
 
@Service
public class ResortServiceImpl implements ResortService{
 
 
    @Autowired
    private BookingRepo bookingRepo;
 
    @Autowired
    private ReviewRepo reviewRepo;

    @Autowired
    private ResortRepo resortRepo;
   
 
    @Override
    public Resort addResort(Resort resort) {
        return resortRepo.save(resort);
    }
 
    @Override
    public List<Resort> getAllResorts() {
       return resortRepo.findAll();
    }
 
    @Override
    public Resort updateResort(Long id, Resort resort) {
        Resort existedResort=resortRepo.findById(id).orElse(null);//exception need to be done
        if(existedResort==null){
            return null;
        }else{
            existedResort.setResortName(resort.getResortName());//updating the existedresort
            existedResort.setResortLocation(resort.getResortLocation());
            existedResort.setResortImageUrl(resort.getResortImageUrl());
            existedResort.setResortAvailableStatus(resort.getResortAvailableStatus());
            existedResort.setPrice(resort.getPrice());
            existedResort.setDescription(resort.getDescription());
            existedResort.setCapacity(resort.getCapacity());
            resortRepo.save(existedResort);
            return existedResort;
        }
     
    }
 
    @Override
    public Resort deleteResort(Long id) {  
        //----ensure if that resort not have any bookings-----
               //find list of  bookings with that given resort 
               //if list size == 0:
                    //deleteByResort in reviewRepo
                    //deleteByResort in resortRepo
              //else raise an exception


              Resort r = resortRepo.findById(id).orElse(null);
              if(r!=null){
                List<Booking> bookingList = bookingRepo.findByResort(r);
                if(bookingList.size()==0){
                    reviewRepo.deleteByResort(r);
                    resortRepo.delete(r);
                    return r;
                }
                else{
                    r.setResortAvailableStatus("unavailable");
                    resortRepo.save(r);
                    //throw exception->These resorts have user booking. Coundnt delete!!
                    return r;
                }
              }
              else{
                //throw exception->Resort not found
                return null;
                
              }
    }
 
    @Override
    public Resort getResortId(Long id) {
       return resortRepo.findById(id).orElse(null);//exception has to be add
    }
   
}
 
 
