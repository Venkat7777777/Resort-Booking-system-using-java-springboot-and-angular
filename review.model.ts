import { Resort } from "./resort.model";
// import { User } from "./user.model";
 
export class Review {
    reviewId?:number;
    comment?:string;
    rating?:number;
    dateCreated?:Date;
    // username?:string;
    // resortname?:string;
    body?:string;
    subject?:string;
    //user?:User;
    resort?:Resort;
}
