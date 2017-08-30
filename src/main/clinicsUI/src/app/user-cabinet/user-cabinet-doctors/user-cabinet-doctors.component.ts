import { Component, OnInit } from '@angular/core';
import {Doctor} from "../../models/doctor";
import {UserCabinetDoctorsService} from "./user-cabinet-doctors.service";

@Component({
  selector: 'app-user-cabinet-doctors',
  templateUrl: './user-cabinet-doctors.component.html',
  styleUrls: ['./user-cabinet-doctors.component.css'],

})
export class UserCabinetDoctorsComponent implements OnInit {
  private doctors: Doctor[] = [];
  constructor(private doctorsService: UserCabinetDoctorsService) { }

  ngOnInit() {
    this.doctorsService.getDoctorsByUser(12)
      .subscribe((data)=> {
      console.log(data.length);
        this.doctors = data;
      console.log(this.doctors)
      }, (error)=>
        console.log(error));

  }

}
