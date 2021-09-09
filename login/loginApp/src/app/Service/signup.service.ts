import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Iuser } from '../Model/iuser';

@Injectable({
  providedIn: 'root'
})
export class SignupService {

  constructor(private http: HttpClient) { }

public addUser(user:Iuser){
  return this.http.post('http://localhost:8080/user/addUser', user);
}

}
