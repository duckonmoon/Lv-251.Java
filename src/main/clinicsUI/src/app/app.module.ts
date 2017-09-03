import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
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
import {FormsModule, NgModel, ReactiveFormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {UserService} from "./user.service";
import { UserCabinetDoctorsComponent } from './user-cabinet/user-cabinet-doctors/user-cabinet-doctors.component';
import { AppointmentsHistoryComponent } from './user-cabinet/user-cabinet-medical/appointments-history/appointments-history.component';
import { LoginComponent } from './auth/login/login.component';
import {AuthenticationService} from "./auth/authentication.service";
import {AlertService} from "./auth/alert.service";


// import { RegistrationComponent } from './auth/registration/registration.component';
// import { ClinicsEditComponent } from './clinics/clinics-edit/clinics-edit.component';
// import { ClinicsListComponent } from './clinics/clinics-list/clinics-list.component';
import {ContactService} from "./contacts/contact.service";
import {ClinicsEditComponent} from "./clinics/clinics-edit/clinics-edit.component";
import {ClinicsListComponent} from "./clinics/clinics-list/clinics-list.component";
import { RegistrationComponent } from './auth/registration/registration.component';
import {RegistrationService} from "./auth/registration/registration.service";

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
    AppointmentsHistoryComponent,
    ClinicsEditComponent,
    ClinicsListComponent,
    LoginComponent,
    RegistrationComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,

  ],

  providers: [UserService,AuthenticationService,AlertService,ContactService, RegistrationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
