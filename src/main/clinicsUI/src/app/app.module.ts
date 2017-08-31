import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { ClinicsComponent } from './clinics/clinics.component';
import { DoctorsComponent } from './doctors/doctors.component';
import { ContactsComponent } from './contacts/contacts.component';
import { UserCabinetComponent } from './user-cabinet/user-cabinet.component';
import { DoctorCabinetComponent } from './doctor-cabinet/doctor-cabinet.component';
import { ModeratorCabinetComponent } from './moderator-cabinet/moderator-cabinet.component';
import {UserCabinetProfileComponent} from './user-cabinet/user-cabinet-profile/user-cabinet-profile.component';
import {AppRoutingModule} from './app-routing-module';
import {UserCabinetMedicalComponent} from './user-cabinet/user-cabinet-medical/user-cabinet-medical.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {UserService} from "./user.service";
import { UserCabinetDoctorsComponent } from './user-cabinet/user-cabinet-doctors/user-cabinet-doctors.component';
import {UserCabinetDoctorsService} from "./user-cabinet/user-cabinet-doctors/user-cabinet-doctors.service";
import { AppointmentsHistoryComponent } from './user-cabinet/user-cabinet-medical/appointments-history/appointments-history.component';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    ClinicsComponent,
    DoctorsComponent,
    ContactsComponent,
    UserCabinetComponent,
    DoctorCabinetComponent,
    ModeratorCabinetComponent,

    UserCabinetProfileComponent,
    UserCabinetMedicalComponent,
    UserCabinetDoctorsComponent,
    AppointmentsHistoryComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule



  ],
  providers: [UserService,UserCabinetDoctorsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
