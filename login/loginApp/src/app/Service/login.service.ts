import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Iuser } from '../Model/iuser';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  url="http://localhost:8080"

  constructor(private http: HttpClient) { }

  //calling the server to generate token

  //doLogin(useremail: string, password:string)

  generateToken(credential:any):Observable<any>{
    //generate token

    return this.http.post(`${this.url}/authenticate`,credential)
  }





  //for login user
  loginUser(token: string){
    console.log(token);
    localStorage.setItem("token",token);
    return true;
  }
//to check user is login or not
  //to check user is login or not
 isLoggedIn()
  {
    let token=localStorage.getItem("token");
    console.log(token);
    if(token==null||token===''||token==undefined)
    {
      console.log("not logged in")
      return false;
    }
    else{
      return true;
    }
  }
//to logout user
  logout(){
    localStorage.removeItem("token");
    return true;
  }

  getToken()
  {
    return localStorage.getItem("token");
  }
  printToken()
  {
    console.log(localStorage.getItem("token"));
  }

  getUserByEmail(email:string): Observable<Iuser>{

    return this.http.get<Iuser>(`${this.url}/user/getUserByEmail/`+email)
  }

  
}
