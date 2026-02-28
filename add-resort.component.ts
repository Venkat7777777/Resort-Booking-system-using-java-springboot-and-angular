import { Component, OnInit } from '@angular/core';
import { ResortService } from '../services/resort.service';
import { Resort } from '../models/resort.model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
 
 
 
@Component({
  selector: 'app-add-resort',
  templateUrl: './add-resort.component.html',
  styleUrls: ['./add-resort.component.css']
})
export class AddResortComponent implements OnInit {
 
  resorts:Resort[]=[];
  isActive:boolean;
  resortform:FormGroup;
  constructor(private service: ResortService, private builder: FormBuilder,private router:Router) {
    this.resortform = this.builder.group({
      resortName: ['', Validators.required],
      resortImageUrl: ['', Validators.required],
      resortLocation: ['', Validators.required],
      description: ['', Validators.required],
      resortAvailableStatus: ['', Validators.required],
      price: ['', [Validators.required, Validators.min(0)]],
      capacity: ['', [Validators.required, Validators.min(1)]],
      isActive: [true]
    });
  }
 
  ngOnInit(): void {}
 
  public addResort() {
    if (this.resortform.valid) {
      let resort: Resort = this.resortform.value;
      resort.isActive = true;
      this.service.addResort(resort).subscribe(data => {});
    } else {
      // If form is not valid, mark all fields as touched to display validation messages
      this.resortform.markAllAsTouched();
    }
  }
 
 
  public get resortName(){
    return this.resortform.get("resortName")
  }
 
  public get resortImageUrl(){
    return this.resortform.get("resortImageUrl")
  }
 
  public get description(){
    return this.resortform.get("description")
  }
 
  public get resortAvailableStatus(){
    return this.resortform.get("resortAvailableStatus")
  }
  public get price(){
    return this.resortform.get("price")
  }
  public get capacity(){
    return this.resortform.get("capacity")
  }
  public get resortLocation(){
    return this.resortform.get("resortLocation")
  }
 
public onA(){
  this.router.navigate(['api/resort'])
}
 
// saveImage(files:FileList){
//   var file:File=files.item(0);
//   var myReader:FileReader=new FileReader();
//   myReader.readAsDataURL(file);
// }
 
 
}
 
