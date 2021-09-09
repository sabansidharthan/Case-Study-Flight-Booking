import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Booking } from '../Model/booking';
import { Details } from '../Model/details';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  constructor(private http: HttpClient) { }

  public  addBooking(booking:Booking):Observable<string>{
    return this.http.post<string>('http://localhost:8080/bookings/bookings', booking);
  }

  public getBooking(userEmail:String):Observable<Booking[]>{
    return this.http.get<Booking[]>('http://localhost:8080/bookings/bookingDetails/'+userEmail);
  }

  public showBooking(userName:String):Observable<Booking[]>{
    console.log(userName);
    return this.http.get<Booking[]>('http://localhost/8080/booking/booking/mykey/'+userName);
  }
  public listBooking(id:String):Observable<Details>{
    return this.http.get<Details>('http://localhost/8083/booking/bookingDetails/'+id);
  }

  public listofBooking(userName:String){
    console.log(userName);
    return this.http.get('http://localhost/8080/bookings/booking/mykey/'+userName);
  }

}
