import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DoctorsComponent} from './doctors/doctors.component';
import {ClinicsComponent} from './clinics/clinics.component';
import {HomeComponent} from './home/home.component';
import {UserCabinetComponent} from './user-cabinet/user-cabinet.component';
import {UserCabinetMedicalComponent} from './user-cabinet/user-cabinet-medical/user-cabinet-medical.component';
import {UserCabinetProfileComponent} from './user-cabinet/user-cabinet-profile/user-cabinet-profile.component';
import {UserCabinetDoctorsComponent} from "./user-cabinet/user-cabinet-doctors/user-cabinet-doctors.component";

const appRoutes: Routes =[
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home' , component: HomeComponent},
  {path: 'doctors' , component: DoctorsComponent},
  {path: 'personal-cabinet'
    , component: UserCabinetComponent,
    children: [
      {path: '', component:UserCabinetProfileComponent },
    {path: 'profile', component:UserCabinetProfileComponent },
    {path: 'medical-info' , component: UserCabinetMedicalComponent},
      {path: 'doctors' , component:UserCabinetDoctorsComponent}

    ]
  },
  {path: 'clinics' , component: ClinicsComponent}
];
  @NgModule({
    imports: [RouterModule.forRoot(appRoutes)],
    exports: [RouterModule]
})
export  class AppRoutingModule {

}
