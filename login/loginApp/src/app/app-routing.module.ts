import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookflightComponent } from './Components/bookflight/bookflight.component';
import { BookingsComponent } from './Components/bookings/bookings.component';
import { CheckinComponent } from './Components/checkin/checkin.component';
import { DashboardComponent } from './Components/dashboard/dashboard.component';
import { FlightSearchComponent } from './Components/flight-search/flight-search.component';
import { HomeComponent } from './Components/home/home.component';
import { LoginComponent } from './Components/login/login.component';
import { SignupComponent } from './Components/signup/signup.component';
import { AuthGuard } from './Service/auth.guard';

const routes: Routes = [
  {
    path: '',component:HomeComponent,
    pathMatch:"full"
  },
  {
    path:"home",component:HomeComponent,
    pathMatch:"full"
  },
  {
    path:"login",component:LoginComponent,
    pathMatch:"full"
  },
  {
    path:"dashboard",component:DashboardComponent,
    pathMatch:"full",
    canActivate:[AuthGuard]
  },
  {
    path:"signup",component:SignupComponent,
    pathMatch:"full"
  },
  {
    path:"search",component:FlightSearchComponent,
    pathMatch:"full"
  },
  {
    path:"checkin",component:CheckinComponent,
    pathMatch:"full"
  },
  {
    path:"book",component:BookflightComponent,
    pathMatch:"full"
  },
  {
    path:"booking",component:BookingsComponent,
    pathMatch:"full"
  },
  {
    path:'search/:source/:destination/:departDate/:flightNumber',component:BookflightComponent,
    pathMatch:"full"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
