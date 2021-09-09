import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import { NavBarComponent } from './Components/nav-bar/nav-bar.component';
import { HomeComponent } from './Components/home/home.component';
import { LoginComponent } from './Components/login/login.component';
import { DashboardComponent } from './Components/dashboard/dashboard.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { SignupComponent } from './Components/signup/signup.component';
import { FlightSearchComponent } from './Components/flight-search/flight-search.component';
import { BookflightComponent } from './Components/bookflight/bookflight.component';
import { CheckinComponent } from './Components/checkin/checkin.component';
import {MatSelectModule} from '@angular/material/select';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { MomentDateModule } from '@angular/material-moment-adapter';



import {MatTableModule} from '@angular/material/table';
import { FlightlistComponent } from './Components/flightlist/flightlist.component';
import { BookingsComponent } from './Components/bookings/bookings.component';
import { SignupService } from './Service/signup.service';
import { FlightServiceService } from './Service/flight-service.service';
import { DatePipe } from '@angular/common';
import { InterceptorService } from './Service/interceptor.service';
import { FooterComponent } from './Components/footer/footer.component';
import { LoginService } from './Service/login.service';
import { AuthGuard } from './Service/auth.guard';
import { BookingService } from './Service/booking.service';



@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    HomeComponent,
    LoginComponent,
    DashboardComponent,
    SignupComponent,
    FlightSearchComponent,
    BookflightComponent,
    CheckinComponent,
    FlightlistComponent,
    BookingsComponent,
    FooterComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatToolbarModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatTableModule,
    HttpClientModule,
    MomentDateModule,
    ReactiveFormsModule 
  ],
  providers: [DatePipe,SignupService,FlightServiceService,LoginService,SignupService,AuthGuard,BookingService,
    {
      provide:HTTP_INTERCEPTORS,
      useClass:InterceptorService,
      multi:true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
