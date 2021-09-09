import { Component, OnInit } from '@angular/core';
import { SignupService } from 'src/app/Service/signup.service';
import {FormControl, Validators} from '@angular/forms';
import {MatIconModule} from '@angular/material/icon';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  emailFormControl = new FormControl('', [Validators.required,  Validators.email,]);
phoneFormcontrol= new FormControl('', [ Validators.required]);
password= new FormControl('', [Validators.required, Validators.min(3) ])
hide = true;

  user={
    userId:"",
    userName:"",
    email:"",
    phoneNumber:"",
    password:""
  }
  
  constructor(private signupService: SignupService) { }

  ngOnInit(): void {
    this.emailFormControl = new FormControl('', [
      Validators.required,
      Validators.email,
    ]);
  this.phoneFormcontrol= new FormControl('', [
    Validators.required
  ]);
  this.password= new FormControl('', [Validators.required, Validators.min(3) ])
  this.hide = true;
  }

  onSubmitSignup(){
    console.log("form submitted")
    if((this.user.userName!="" && this.user.password!="")&&(this.user.password!=null && this.user.userName!=null)&&(this.user.email!=null && this.user.email!=null)){
      console.log("now subit to backend")
      console.log(this.user)
     
      this.signupService.addUser(this.user).subscribe(
        (data)=>{
          console.log(data);
          alert('Succesfully Registered');
        },
        (error)=>{
          console.log(error);
        }
        
      )
      alert('Succesfully Registered');
    }else{
      console.log("fields are empty")
    }
  }

}
