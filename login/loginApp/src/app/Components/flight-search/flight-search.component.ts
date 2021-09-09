import { DatePipe, formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Flight } from 'src/app/Model/flight';
import { Search } from 'src/app/Model/search';
import { FlightServiceService } from 'src/app/Service/flight-service.service';
import {FlightInt} from 'src/app/Model/flight-int';
import { FlightList } from 'src/app/Model/flight-list';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginService } from 'src/app/Service/login.service';

interface From {
  value: string;
  viewValue: string;
}
interface To {
  value: string;
  viewValue: string;
}
export interface PeriodicElement {
  flightNumber: Number;
  source: String;
  departDate: String;
  departTime: String;
  destination: String;
  arrivalDate: String;
  arrivalTime: String;
  fare: Number;
}
const ELEMENT_DATA: PeriodicElement[] = [
  {  flightNumber: 1,
    source: 'TRV',
    departDate: '2021-09-01',
    departTime: '9:30',
    destination: 'HYD',
    arrivalDate: '2021-09-01',
    arrivalTime: '11:30',
    fare: 3000,
    }
];


@Component({
  selector: 'app-flight-search',
  templateUrl: './flight-search.component.html',
  styleUrls: ['./flight-search.component.css']
})


export class FlightSearchComponent implements OnInit {
  minDate: Date;
  maxDate: Date;
  selectedFrom!: string;
  selectedTo!: string;
  date = new Date();
  displayedColumns: string[] = ['flightNumber','source','departDate','departTime','destination','arrivalDate','arrivalTime','fare','action'];
  dataSource = ELEMENT_DATA;
  isLoggedIn=false;
  
  

  search: Search={
    source: this.selectedFrom,
    destination:this.selectedTo
  }

 flight: Flight={
  flightNumber:0 ,
      source:this.selectedFrom ,
      departDate:this.date ,
      departTime: this.date,
      destination:this.selectedTo  ,
      arrivalDate: this.date,
      arrivalTime: this.date,
      travelTime: 4,
      fare: 4,
      seatsRemaining: 4
 }

  flights!: Flight[];

  flightdisplayedColumns: string[] = ['flightNumber','source','departDate','departTime','destination','arrivalDate','arrivalTime','fare','action'];
  flightDataSource = new MatTableDataSource(this.flights);
  pickedDate!:String;

  froms: From[] = [
    { value: 'TRV', viewValue: 'TRV' },
    { value: 'DEL', viewValue: 'DEL' },
    { value: 'BOM', viewValue: 'BOM' },
    { value: 'HYD', viewValue: 'HYD' },
    { value: 'BLR', viewValue: 'BLR' },
    { value: 'MAA', viewValue: 'MAA' }
  ];

  tos: To[] = [
    { value: 'TRV', viewValue: 'TRV' },
    { value: 'DEL', viewValue: 'DEL' },
    { value: 'BOM', viewValue: 'BOM' },
    { value: 'HYD', viewValue: 'HYD' },
    { value: 'BLR', viewValue: 'BLR' },
    { value: 'MAA', viewValue: 'MAA' }
  ];

/////////////////////////////////////////////////////////////////////////////////////////////////////////////
  constructor(
    private flightService: FlightServiceService, 
    private datePipe: DatePipe,
    private route:ActivatedRoute,
    private router:Router,
    private loginService: LoginService
    ) {
      const currentYear = new Date().getFullYear();
      this.minDate = new Date();
      this.maxDate = new Date(currentYear + 1, 11, 31);
     }

  ngOnInit(): void {
    this.pickedDate =formatDate(this.date?.valueOf(),'yyyy-MM-dd','en');
    console.log(this.pickedDate +" init");
  
  }

  transformDate():String{
   var formatedDate=this.datePipe.transform(this.date,"yyyy-MM-dd");
   return String(formatedDate);
  }

 formatedDate=this.transformDate();
 
  searchFlights() {
    this.pickedDate =formatDate(this.date?.valueOf(),'yyyy-MM-dd','en');
      this.flightService.searchFlights(this.selectedFrom,this.selectedTo,this.pickedDate)
      .subscribe(data => {
      this.flights = data;
      this.flightDataSource=new MatTableDataSource(this.flights);
      console.log(data);
      console.log(this.flightDataSource)
    })
  }

  toStringMyDate(){
    this.pickedDate =formatDate(this.date?.valueOf(),'yyyy-MM-dd','en');
    console.log(this.pickedDate);
    return this.pickedDate;
    }

  searchFun() {
    console.log(this.search);
    console.log(this.formatedDate);
    this.pickedDate =formatDate(this.date?.valueOf(),'yyyy-MM-dd','en');
    console.log(this.pickedDate +" in search");
    
    this.flightService.searchFlightsSD(this.search).subscribe(data => {
      this.flights = data;
      console.log(this.flights);
    })
  }

  getRecord(flightbooked:Flight)
  {
    console.log(flightbooked)
    console.log(flightbooked.source);
    console.log(flightbooked.destination);
    console.log(flightbooked.departDate);

    this.isLoggedIn=this.loginService.isLoggedIn();
    if(this.isLoggedIn){
      alert("Booking Flight");
      this.router.navigate([flightbooked.source,flightbooked.destination,flightbooked.departDate,flightbooked.flightNumber], { relativeTo: this.route });
 
    }else{
      alert("please login");
      window.location.href="/login";
    }
  }

  resetField() {
    this.selectedTo = "";
    this.selectedFrom = "";
  }

}


