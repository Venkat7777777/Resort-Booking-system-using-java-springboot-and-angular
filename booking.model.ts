import { logging } from "protractor";
import { LoginComponent } from "../login/login.component";
import { User } from "./user.model";
import { Resort } from "./resort.model";
 
export class Booking {
    bookingId?:number;
    noOfPersons?:number;
    fromDate?:Date;
    toDate?:Date;
    totalPrice?:number;
    address?:string;
    status?:string;
    token?:string;
    //user?:User;
    resort?:Resort
}