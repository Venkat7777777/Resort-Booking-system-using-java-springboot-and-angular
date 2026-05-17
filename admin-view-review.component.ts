import { Component, OnInit } from '@angular/core';
import { Review } from '../models/review.model';
import { ReviewService } from '../services/review.service';
import { ActivatedRoute } from '@angular/router';
import { Resort } from '../models/resort.model';
import { ResortService } from '../services/resort.service';
 
 
@Component({
  selector: 'app-admin-view-review',
  templateUrl: './admin-view-review.component.html',
  styleUrls: ['./admin-view-review.component.css']
})
export class AdminViewReviewComponent implements OnInit {
 
  reviews : Review[]=[];
  resortId:number;
  resort:Resort; 
  constructor(private service:ReviewService,private activated:ActivatedRoute,private resortservice:ResortService){ }
 
  ngOnInit(): void {
   
    this.resortId =this.activated.snapshot.paramMap.get("resortId") as unknown as number;
    this.getAllReviews();
    this.resortservice.getResortById(this.resortId).subscribe(data=>this.resort=data);
    
  }
 
  public getAllReviews(){
    this.service.getReviewsByresortId(this.resortId).subscribe(data=>{this.reviews=data});
  }
 
}
  
