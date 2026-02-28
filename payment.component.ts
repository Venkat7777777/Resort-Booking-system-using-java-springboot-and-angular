import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Payment } from '../models/payment.model';
import { Resort } from '../models/resort.model';
import { ActivatedRoute } from '@angular/router';
import { ResortService } from '../services/resort.service';
import { BookingService } from '../services/booking.service';
import { PaymentService } from '../services/payment.service';
import { Booking } from '../models/booking.model';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  resortId:number
  resort:Resort;
  booking:Booking;
  paymentForm: FormGroup;
  currDate: Date=new Date();
  constructor(private builder:FormBuilder,private activatedRoute:ActivatedRoute,
    private resortService:ResortService,private bservice:BookingService,private paymentservice : PaymentService) {
    this.paymentForm = this.builder.group({
      cardNumber: builder.control('', [Validators.required, Validators.pattern('^[0-9]{16}$')]),
      expiryDate: builder.control('', [Validators.required, Validators.pattern('(0[1-9]|1[0-2])\\/([0-9]{2})')]),
      cvv: builder.control('', [Validators.required, Validators.pattern('^[0-9]{3,4}$')])
    });
   }
   

  ngOnInit(): void {
    list:[];
    this.activatedRoute.queryParamMap.subscribe((params: any) => {const list=JSON.parse(params.params.myObjects);
    this.booking=list[0]; this.resort=list[1]});
   this.booking.resort=this.resort;
   console.log(this.booking);
    }
  
  
    public completeprocess(){
      console.log("**************CHECK-COMPLETE***************")
      console.log(this.booking.token);
    let p:Payment={userName:"dummyuser",resortName:this.resort.resortName,totalPrice:this.resort.price,currDate:this.currDate,token:this.booking.token}
        this.bservice.addBooking(this.booking).subscribe(data=>{console.log("**************CHECK-Inside-complete***************",this.booking.token);})
        this.paymentservice.addPayment(p).subscribe(data=>{});
   
    }

}

