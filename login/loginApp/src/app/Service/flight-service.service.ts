import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Flight } from '../Model/flight';
import { Search } from '../Model/search';
import { FlightList } from '../Model/flight-list';

@Injectable({
  providedIn: 'root'
})
export class FlightServiceService {
  
  private flightUrl: string;

  
  constructor(private http: HttpClient) {
    this.flightUrl = 'http://localhost:8082/flight';
  }

  public searchFlights(source:String,destination:String,date:String):Observable<Flight []> {

    return this.http.get<Flight []>(this.flightUrl+'/search/'+source+"/"+destination+"/"+date)
    
  }


  public searchFlightsSD(searchObj:Search):Observable<any> {

    return this.http.post<Flight []>(this.flightUrl+'/searchFlights/search',searchObj)

  }
  // public searchFlights(flight:Flight):Observable<any> {
  //   let params = new HttpParams()
  //   .set('flightNumber', String(flight.flightNumber))
  //   .set('source', String(flight.source))
  //   .set('departDate', String(flight.departDate))
  //   .set('departTime', String(flight.departTime))
  //   .set('destination', String(flight.destination))
  //   .set('arrivalDate', String(flight.arrivalDate))
  //   .set('arrivalTime', String(flight.arrivalTime))
  //   .set('travelTime', String(flight.travelTime))
  //   .set('fare', String(flight.fare))
  //   .set('seatsRemaining', String(flight.seatsRemaining));

  //   return this.http.get<Flight []>(this.flightUrl+'/searchFlights',{params: params})

  // }
}
