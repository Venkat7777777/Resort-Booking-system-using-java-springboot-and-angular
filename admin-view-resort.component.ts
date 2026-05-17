import { Component, OnInit } from '@angular/core';
import { Resort } from '../models/resort.model';
import { ResortService } from '../services/resort.service';
import { Router } from '@angular/router';
import { Review } from '../models/review.model';

@Component({
  selector: 'app-admin-view-resort',
  templateUrl: './admin-view-resort.component.html',
  styleUrls: ['./admin-view-resort.component.css']
})
export class AdminViewResortComponent implements OnInit {

  resorts:Resort[]=[];


  // fliterResorts=this.resorts.filter(data=>data.resortAvailableStatus=="available")


  constructor(private service:ResortService,private router:Router) { }

  ngOnInit(): void {
    this.getAllResorts();
  }

  public getAllResorts(){
    this.service.getAllResorts().subscribe(data=>{this.resorts=data})

    
  }

  public onEdit(resortId:number){
    console.log(resortId);
      this.router.navigate(['api/resort/',resortId])
  }
 
  public onDelete(resortId:number){
   this.service.deleteResort(resortId).subscribe(data=>{
    this.getAllResorts();
   })
  }
  

  public onReview(r:Resort){
    this.router.navigate(['api/admin/review/',r.resortId])
  }
public addResort(){
  this.router.navigate(['api/admin/addResort'])
}

}
