import { Component, OnInit } from '@angular/core';
import { ReviewService } from '../services/review.service';
import { Review } from '../models/review.model';
import { ActivatedRoute, Router } from '@angular/router';
import { ResortService } from '../services/resort.service';
import { Resort } from '../models/resort.model';
 
 
@Component({
  selector: 'app-customer-view-review',
  templateUrl: './customer-view-review.component.html',
  styleUrls: ['./customer-view-review.component.css']
})
export class CustomerViewReviewComponent implements OnInit {
 
  reviews:Review[]=[];
  resortId:number;
  resort:Resort;
 
  constructor(private service:ReviewService,private router:Router,private activatedRoute:ActivatedRoute,private resortService:ResortService) { }
 
  ngOnInit(): void {
    
    this.resortId = this.activatedRoute.snapshot.paramMap.get("resortId") as unknown as number;
    this.getAllReviews();
    this.resortService.getResortById(this.resortId).subscribe(data =>{
      this.resort = data
    });

  }
 
  public getAllReviews(){
    this.service.getReviewsByresortId(this.resortId).subscribe(data=>{this.reviews=data});
 
  }
 
  public onAddReview(){
    this.router.navigate(['api/add/review/',this.resortId])
  }
 
}
  
