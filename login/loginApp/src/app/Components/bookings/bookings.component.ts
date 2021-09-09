import { Component, OnInit } from '@angular/core';
import { Booking } from 'src/app/Model/booking';
import { BookingService } from 'src/app/Service/booking.service';
import { LoginService } from 'src/app/Service/login.service';

@Component({
  selector: 'app-bookings',
  templateUrl: './bookings.component.html',
  styleUrls: ['./bookings.component.css']
})
export class BookingsComponent implements OnInit {

  isLoggedIn: any;
  currentUser: string | undefined;
  user: any;
  showbutton!: boolean;
  bookingList!: Booking[];

  constructor(private bookingService:BookingService,private loginService:LoginService) { }

  ngOnInit(): void {
    this.isLoggedIn=this.loginService.isLoggedIn();
    this.currentUser=String(localStorage.getItem('userName'));
    this.user=this.currentUser;
    console.log(this.currentUser)
    this.showbutton=true;
    this.bookingService.listofBooking(this.currentUser).subscribe(data => {
     this.bookingList!= data;
     console.log(this.bookingList);
  })}

  }