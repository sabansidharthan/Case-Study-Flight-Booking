import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/Service/login.service';
import {FormControl, Validators} from '@angular/forms';
import {MatIconModule} from '@angular/material/icon';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  emailFormControl = new FormControl('', [Validators.required,  Validators.email,]);
  password= new FormControl('', [Validators.required, Validators.min(3) ])
  hide = true;
  credential = {
    email: "",
    password: ""
  }
  token: string="";
  constructor(private loginService: LoginService, private router:Router) { }

  ngOnInit(): void {  
    this.emailFormControl = new FormControl('', [Validators.required,  Validators.email,]);
  this.password= new FormControl('', [Validators.required, Validators.min(3) ])
  }

  onSubmit() {
    console.log("form submitted")
    if ((this.credential.email != "" && this.credential.password != "") && (this.credential.password != null && this.credential.email != null)) {
      console.log("now subit to backend")
      this.loginService.generateToken(this.credential).subscribe(
        response => {
          this.loginService.loginUser(response.jwtToken);
          console.log("------------------------------------------------------------")
          this.loginService.getUserByEmail(this.credential.email).subscribe(
            data =>{
              localStorage.setItem("userDetails",JSON.stringify(data));
              localStorage.setItem("userEmail",data.email);
              localStorage.setItem("userName",data.userName);
              localStorage.setItem("userId",data.userId);
              window.location.href = "/dashboard";
              //this.router.navigate(["dashboard"]);
              console.log("logged in");
            },error =>
            {
              console.log(error);
              alert('Login Failed');
            }
          )
        },
        error => {
          console.log(error);
          alert('Login Failed');

        }
        
      )

    } else {
      console.log("fields are empty")
    }
  }
}
