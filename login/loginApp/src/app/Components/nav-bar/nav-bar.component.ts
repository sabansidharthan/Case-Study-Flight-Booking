import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/Service/login.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  public loggedIn=false;
  myLabel:string | null | undefined;
  

  constructor(private loginservice:LoginService,private router:Router) { }

  ngOnInit(): void {
    this.loggedIn=this.loginservice.isLoggedIn();
    this.myLabel = localStorage.getItem("userName");
    
  }
logout(){
  this.loginservice.logout();
  window.location.reload();
}
clickUser(){
  this.router.navigate(['/dashboard']);
}
}
