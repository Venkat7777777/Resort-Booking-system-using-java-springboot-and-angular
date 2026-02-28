import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ResortService } from '../services/resort.service';
import { Resort } from '../models/resort.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customer-view-resort',
  templateUrl: './customer-view-resort.component.html',
  styleUrls: ['./customer-view-resort.component.css']
})
export class CustomerViewResortComponent implements OnInit {
  resorts :Resort[]=[];
  // @Output() resortevnt =new EventEmitter<Resort>;

  constructor(private rservice : ResortService,private router : Router){ 
  
  }

  rating=0;
  
  ngOnInit(): void {
    this.getResorts();
  }
  
  public getResorts(){
    this.rservice.getAllResorts().subscribe(data=>{this.resorts=data})
  }
  // view:string='customerview';

  
  public emitResort(resort : Resort){
    // this.resortevnt.emit(resort);
    console.log("works");
    console.log(resort.resortId);
    // this.view="booking";
    this.router.navigate(['api/booking/',resort.resortId])

    
  }
  public onListOfReviews(resort:Resort){
    this.router.navigate(['api/customer/review/',resort.resortId])
  }

}

