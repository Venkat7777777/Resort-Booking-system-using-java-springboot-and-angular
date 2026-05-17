import { Component, Input, OnInit } from '@angular/core';
import { BookingService } from '../services/booking.service';
import { Resort } from '../models/resort.model';
import { ResortService } from '../services/resort.service';
import { ActivatedRoute, Router } from '@angular/router';
import {  AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Booking } from '../models/booking.model';
import { PaymentService } from '../services/payment.service';
import { Payment } from '../models/payment.model';


@Component({
  selector: 'app-add-booking',
  templateUrl: './add-booking.component.html',
  styleUrls: ['./add-booking.component.css']
})
export class AddBookingComponent implements OnInit {
  
 
  bookingId: number;
  booking:Booking;
  resortId : number;
  resort : Resort;
  selectedResort : Resort=null;
  addbookingForm:FormGroup;
  Token:string= Math.random().toString(10);
  today = new Date().toISOString().split('T')[0];
  constructor(private bservice:BookingService,private resortService : ResortService,
    private activatedRoute : ActivatedRoute,private builder : FormBuilder, 
    private router:Router) {
      this.addbookingForm = this.builder.group({
        rname: this.builder.control({value: "", disabled: true}),
        totalPrice: this.builder.control({value: "", disabled: true}),
        rlocation: this.builder.control({value: "", disabled: true}),
        rcapacity: this.builder.control({value: "", disabled: true}),
        address: this.builder.control("", Validators.required),
        noOfPersons: this.builder.control("", [Validators.required,Validators.min(1), this.capacityValidator.bind(this)]),
        fromDate: this.builder.control("", [Validators.required, this.FROMdateValidator.bind(this)]),
        toDate: this.builder.control("", [Validators.required, this.dateValidator.bind(this)])
      });
      
   
     
   }

   public setDataFields(){
    this.addbookingForm.get("rname").setValue(this.resort.resortName);
    this.addbookingForm.get("totalPrice").setValue(this.resort.price);
    this.addbookingForm.get("rlocation").setValue(this.resort.resortLocation);
    this.addbookingForm.get("rcapacity").setValue(this.resort.capacity);
    
   }

  ngOnInit(): void {
    this.resortId = this.activatedRoute.snapshot.paramMap.get("resortId") as unknown as number;
    console.log("Check 1")
    console.log(this.resortId)
    this.resortService.getResortById(this.resortId).subscribe(data =>{
      this.resort = data
      this.setDataFields();
     
    });
  }
  bookingObject:Booking={noOfPersons:0,fromDate:new Date(),toDate:new Date(),totalPrice:0,address:"",status:"",token:"",resort:{}};
  
  public goToPayment(){
     
    if(this.addbookingForm.valid){
      console.log("*****************************")
      console.log(this.bookingObject);
      // this.bservice.addBooking(b).subscribe(data=>{})
      // this.router.navigate(['api/payment/',b.bookingId]);
      let bookingDetails:Booking=this.addbookingForm.value;
      //  b.resort=this.resort;
       this.bookingObject.noOfPersons=bookingDetails.noOfPersons;
       this.bookingObject.fromDate=bookingDetails.fromDate;
       this.bookingObject.toDate=bookingDetails.toDate;
       this.bookingObject.totalPrice=bookingDetails.totalPrice;
       this.bookingObject.address=bookingDetails.address;
       this.bookingObject.status="pending";
       this.bookingObject.token=this.Token;
      //  this.bookingObject.user=this.user as User;
       this.bookingObject.resort=this.resort as Resort;
       console.log("**************CHECK-1***************")
      console.log(this.bookingObject);
        let list=[this.bookingObject,this.resort];
        //  this.router.navigate(['api/payment'],{queryParams:{myObjects:JSON.stringify(list)}})
        this.router.navigate(['api/payment'],{queryParams: { myObjects: JSON.stringify(list)},skipLocationChange: true});

       
    }
  }

  

    public get address(){
    return this.addbookingForm.get("address");
   }
   public get noOfPersons(){
     return this.addbookingForm.get("noOfPersons");
    }
    public get toDate(){
     return this.addbookingForm.get("toDate");
    }
    public get fromDate(){
     return this.addbookingForm.get("fromDate");
    }

    // Custom validator for capacity
  capacityValidator(control: AbstractControl): {[key: string]: any} | null {
    const noOfPersons = control.value;
    const capacity = this.addbookingForm?.get('rcapacity')?.value;
    return noOfPersons > capacity ? { 'exceedsCapacity': true } : null;
  }

  // Custom validator for date
  dateValidator(control: AbstractControl): {[key: string]: any} | null {
    const selectedDate = new Date(control.value);
    const today = new Date();
    return selectedDate < today ? { 'invalidDate': true } : null;
  }


  FROMdateValidator(control: AbstractControl): {[key: string]: any} | null {
    const selectedDate = new Date(control.value);
    const today = new Date();
    today.setHours(0,0,0,0);
    return selectedDate <= today ? { 'invalidDate': true } : null;
  }


  
  

}
