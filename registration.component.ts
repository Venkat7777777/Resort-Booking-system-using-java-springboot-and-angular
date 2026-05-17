import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user.model';
import { AuthService } from 'src/app/services/auth.service';
 
@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  passwordMismatch: boolean = false;
  user:User
 
  registrationForm:FormGroup;
 
  constructor(private service : AuthService,private builder : FormBuilder,private router:Router) {
    this.registrationForm = builder.group({
      username:builder.control("",Validators.required),
      email:builder.control("",Validators.required),
      password:builder.control("",Validators.required),
      confirmPassword:builder.control("",Validators.required),
      mobileNumber:builder.control("",Validators.required),
      userRole:builder.control("CUSTOMER",Validators.required)
    })
  }
 
  ngOnInit(): void {
  }
 
  public register(){
    let entUser = this.registrationForm.value;
    if (this.registrationForm.valid && !this.passwordMismatch){
      this.service.register(entUser).subscribe(
        data=>{
        console.log(data);
            this.router.navigate(['api/login']);      
      },
      error => {
       // console.error(error);
        this.router.navigate(['/']);
      }
 
      );
    }
  }
 
  checkPasswords(): void {
    const password = this.registrationForm.get('password')?.value;
    const confirmPassword = this.registrationForm.get('confirmPassword')?.value;
    this.passwordMismatch = password !== confirmPassword;
  }
 
  passwordComplexityValidator(control: FormControl) {
    const value = control.value;
    if (!value) return null;
 
    const hasUpperCase = /[A-Z]/.test(value);
    const hasLowerCase = /[a-z]/.test(value);
    const hasDigit = /\d/.test(value);
    const hasSpecialChar = /[!@#$%^&*(),.?":{}|<>]/.test(value);
 
    const valid = hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar;
    return valid ? null : { passwordComplexity: true };
  }
}