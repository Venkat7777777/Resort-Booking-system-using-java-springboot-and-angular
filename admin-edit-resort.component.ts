import { Component, OnInit } from '@angular/core';
import { Resort } from '../models/resort.model';
import { ResortService } from '../services/resort.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-admin-edit-resort',
  templateUrl: './admin-edit-resort.component.html',
  styleUrls: ['./admin-edit-resort.component.css']
})
export class AdminEditResortComponent implements OnInit {

  resortId:number;
  resort:Resort;
  editForm:FormGroup;
  constructor(private service:ResortService,private activateRoute:ActivatedRoute,private builder:FormBuilder,private router:Router) {
    this.editForm = builder.group({
      resortName: builder.control("", [Validators.required]),
      description: builder.control("", [Validators.required]),
      resortImageUrl: builder.control(""),
      resortAvailableStatus: builder.control(""),
      resortLocation: builder.control(""),
      capacity: builder.control("", [Validators.required, Validators.min(0)]),
      price: builder.control("", [Validators.required, Validators.min(1)])
    });

   }

  ngOnInit(): void {
    this.resortId=this.activateRoute.snapshot.paramMap.get("resortId") as unknown as number;
    this.service.getResortById(this.resortId).subscribe(data=>{
      this.resort=data;
      this.setDataFields();
    })
  }


  public setDataFields(){
    this.editForm.get("resortName").setValue(this.resort.resortName);
    this.editForm.get("description").setValue(this.resort.description);
    this.editForm.get("resortImageUrl").setValue(this.resort.resortImageUrl);
    this.editForm.get("resortAvailableStatus").setValue(this.resort.resortAvailableStatus);
    this.editForm.get("resortLocation").setValue(this.resort.resortLocation);
    this.editForm.get("capacity").setValue(this.resort.capacity);
    this.editForm.get("price").setValue(this.resort.price);

  }

  public cancelEdit(){
    this.router.navigate(['api/resort']);
  }

  public saveResort(){
    console.log(this.editForm.valid);//console
    if(this.editForm.valid){
      let updatedResort:Resort=this.editForm.value;
      console.log(updatedResort)//console
      this.service.updateResort(this.resortId,updatedResort).subscribe(data=>{
        this.router.navigate(['api/resort']);
      })
    }
  }



}

