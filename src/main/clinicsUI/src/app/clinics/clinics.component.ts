import { Component, OnInit } from '@angular/core';
// import {ClinicsService} from "./clinics-service";
// import {Clinic} from "../models/Clinic";

@Component({
  selector: 'app-clinics',
  templateUrl: './clinics.component.html',
  styleUrls: ['./clinics.component.css']
  // providers: [ClinicsService]
})
export class ClinicsComponent implements OnInit {
  ngOnInit(): void {
    throw new Error("Method not implemented.");
  }

  // clinics: Clinic[];
  // constructor(private clinicsService:ClinicsService) { }
  //
  // ngOnInit() {
  //   this.clinics = this.clinicsService.clinics;
  // }

}
