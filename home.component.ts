import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  ToLogin() {
    this.router.navigate(['api/login'])
    }
    ToAR() {
      this.router.navigate(['api/admin'])
    }
    ToResorts() {
      this.router.navigate(['api/customer'])
    }
    ToHome() {
      this.router.navigate(['api/home'])
    }
    

}
