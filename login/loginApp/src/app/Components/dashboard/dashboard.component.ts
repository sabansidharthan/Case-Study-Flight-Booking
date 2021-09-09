import { Component, OnInit } from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import { Booking } from 'src/app/Model/booking';
import { Details } from 'src/app/Model/details';
import { BookingService } from 'src/app/Service/booking.service';
import { LoginService } from 'src/app/Service/login.service';

export interface PeriodicElement {

  
	userEmail:string;
	firstName:string;
	lastName:string;
	passengerEmail:string;
	passengerPhone:string;
	passengerAge:Number;
	gender:string;
	bookingDate: string;
	flightId: string;
}

const ELEMENT_DATA: PeriodicElement[] = [
{flightId:"9892", firstName: 'Saban', lastName:"S",userEmail:"saban@email.com" ,passengerEmail: 'saban@email.com',passengerPhone:"1234567890",passengerAge:26,gender:"MALE",bookingDate:"2021-09-06"},
{flightId: "9892", firstName: 'Roronoa', lastName:"Zoro",userEmail:"saban@email.com" ,passengerEmail: 'zoro@email.com',passengerPhone:"6366636363",passengerAge:26,gender:"MALE",bookingDate:"2021-09-06"}];
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  currentUser:string="";
  isLoggedIn:boolean = false;
  bookingList!: Booking [];
  list!:Details;
  showbutton:boolean=false;
  user:string="User";

  displayedColumns: string[] = ["flightId", "firstName", "lastName","userEmail","passengerEmail","passengerPhone","passengerAge","gender","bookingDate"];
  dataSource = new MatTableDataSource(this.bookingList);

  // applyFilter(event: Event) {
  //   const filterValue = (event.target as HTMLInputElement).value;
  //   this.dataSource.filter = filterValue.trim().toLowerCase();
  //   this.showbutton=false;
  // }

  constructor(private bookingService:BookingService, private loginService:LoginService) { }

  ngOnInit(): void {
    this.isLoggedIn=this.loginService.isLoggedIn();
    this.currentUser=String(localStorage.getItem('userEmail'));
    this.user=this.currentUser;
  }

  show(){
    console.log(this.currentUser)
    this.showbutton=true;
    // this.bookingService.listofBooking(this.currentUser).subscribe((data: Booking[]) => {
    //  this.bookingList= data;
    //  console.log(this.bookingList);
    // })

    this.bookingService.getBooking(this.currentUser).subscribe(
      
      data =>{
        this.bookingList=data;
        console.log(data);
        console.log(this.bookingList)
        this.dataSource = new MatTableDataSource(this.bookingList);
      },
      error => {
        console.log(error);
      }


    )
      

    
  }
}