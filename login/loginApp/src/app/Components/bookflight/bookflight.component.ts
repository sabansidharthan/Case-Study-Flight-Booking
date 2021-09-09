import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { Booking } from 'src/app/Model/booking';
import { BookingService } from 'src/app/Service/booking.service';
import { LoginService } from 'src/app/Service/login.service';



interface Gender {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-bookflight',
  templateUrl: './bookflight.component.html',
  styleUrls: ['./bookflight.component.css']
})
export class BookflightComponent implements OnInit {
  emailFormControl = new FormControl('', [Validators.required,  Validators.email,]);
  phoneFormcontrol= new FormControl('', [ Validators.required]);
  password= new FormControl('', [Validators.required, Validators.min(3) ])
  ageFormControl= new FormControl('', [ Validators.required]);

  hide = true;

  gender: Gender[] = [
    {value:"", viewValue:"Gender"},
    { value: 'male', viewValue: 'MALE' },
    { value: 'female', viewValue: 'FEMALE' },
    { value: 'other', viewValue: 'OTHER' }
  ];

  isLoggedIn = false;
  reservedSource: string = "";
  reservedDestination: string = "";
  reservedDepartDate: string = "";
  reservedFlightNumber: string = "";

  booking!: Booking;
  reserve={
    bookingId:"",
    userEmail:"",
    firstName:"",
    lastName:"",
    passengerEmail:"",
    passengerPhone:"",
    passengerAge:0,
    gender:"",
    bookingDate:new Date(),
    flightId: 0
  }
  constructor(
     private loginService: LoginService,
     private router: Router,
     private route: ActivatedRoute,
     private bookingService:BookingService) { }
  ngOnInit(): void {

    this.isLoggedIn = !!this.loginService.isLoggedIn();
    //check if logged in else error
    if (this.isLoggedIn) {
      this.route.paramMap.subscribe((params: ParamMap) => {
        let source = params.get('source') || "";
        this.reservedSource = source;
        let destination = params.get('destination') || "";
        this.reservedDestination = destination;
        let departDate = params.get('departDate') || "";
        this.reservedDepartDate = departDate;
        let flightNumber = params.get('flightNumber') || "";
        this.reservedFlightNumber = flightNumber;
      })}
    
  }

    

  onSubmitSignup(){
    this.reserve.bookingId="";
    this.reserve.userEmail=localStorage.getItem('userEmail')!;
    this.reserve.bookingDate=new Date();
    this.reserve.flightId=Number(this.reservedFlightNumber);
    console.log(this.reserve);
    console.log(this.reserve.firstName);   
    this.bookingService.addBooking(this.reserve).subscribe(
      (data)=>{
        console.log(data);
      }
    )
    alert('Succesfully Booked');
       window.location.href="/dashboard"
  }
  

}


