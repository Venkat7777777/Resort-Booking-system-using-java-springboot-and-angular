import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
 
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
ToSignup() {
this.router.navigate(['api/register'])
}
 
  username: string="";
  password: string="";
  role: string="";
  error: string = '';
  invalidCredentials : number = 0;
 
 
  constructor(public authService: AuthService, private router: Router) { }
 
  login(): void {
    console.log("Before login");
    console.log("Username : "+this.username);
    console.log("Password : "+this.password);
    this.authService.login(this.username, this.password,(isLoginUser : boolean)=>{
      console.log(isLoginUser);
      if(isLoginUser) {
        let userRole = localStorage.getItem("userRole");
        if (userRole === 'ADMIN') {
          this.router.navigate(['/api/admin']); // Navigate to the Admin component
        } else if (userRole === 'CUSTOMER') {
          this.router.navigate(['/api/customer']); // Navigate to the Organizer component
        } else {
              // Handle other roles or scenarios if needed
        }
      }else{
        this.invalidCredentials = 1;
        this.error = "Invalid credentials"
      }
    });
   
   
  }
 
  }