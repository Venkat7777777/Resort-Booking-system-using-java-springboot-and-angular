import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customernavbar',
  templateUrl: './customernavbar.component.html',
  styleUrls: ['./customernavbar.component.css']
})
export class CustomernavbarComponent implements OnInit {


  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  ToLogin() {
    this.router.navigate(['api/login'])
   
    }
    
    ToHome() {
      this.router.navigate(['api/home'])
    
    }
    ToCBooking() {
  this.router.navigate(['api/customer/booking'])
   
  }
  ToCResorts() {
   this.router.navigate(['api/customer'])  
  }
  
}
