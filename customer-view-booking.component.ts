import { Component, OnInit } from '@angular/core';
import { Booking } from '../models/booking.model';
import { BookingService } from '../services/booking.service';
import { Resort } from '../models/resort.model';

@Component({
  selector: 'app-customer-view-booking',
  templateUrl: './customer-view-booking.component.html',
  styleUrls: ['./customer-view-booking.component.css']
})
export class CustomerViewBookingComponent implements OnInit {
  
  bookings:Booking[]=[]
  resort:Resort;
  rname="resortdummy";
  // status="statusdummy";
  constructor(private bookingService: BookingService) { }
 
  ngOnInit(): void {
    this.getBookings();
  }
  public getBookings(){
    return this.bookingService.getAllBookings().subscribe(data=>this.bookings=data);
  }
  public deleteBooking(bookingId:number){
    return this.bookingService.deleteBooking(bookingId).subscribe(data=>{
      this.getBookings();
    });
  }

}
