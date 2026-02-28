import { Component, OnInit } from '@angular/core';
import { Booking } from '../models/booking.model';
import { BookingService } from '../services/booking.service';
import { Resort } from '../models/resort.model';
 
@Component({
  selector: 'app-admin-view-booking',
  templateUrl: './admin-view-booking.component.html',
  styleUrls: ['./admin-view-booking.component.css']
})
export class AdminViewBookingComponent implements OnInit {
 
  books:Booking[]=[];
  resort:Resort;
  userName="dummy";
  constructor(private service:BookingService) { }
 
  ngOnInit(): void {
    console.log(this.books);
    this.getAllBookings();
  }
 
  public getAllBookings(){
    this.service.getAllBookings().subscribe(data=>{this.books=data})
  }
 
  public onAccept(book:Booking){
    book.status="ACCEPTED";
    this.service.updateBooking(book).subscribe(data=>this.getAllBookings());
  }
 
  public onReject(book:Booking){
    book.status="REJECTED";
    this.service.updateBooking(book).subscribe(data=>this.getAllBookings());
  }
 
 
}
