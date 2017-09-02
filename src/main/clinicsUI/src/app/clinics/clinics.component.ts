import { Component, OnInit } from '@angular/core';
import {ClinicsService} from "./clinics-service";
import {Clinic} from "../models/Clinic";
import {MarianZagadochnijService} from "./marian-zagadochnij-service";
import {Http} from "@angular/http";

@Component({
  selector: 'app-clinics',
  templateUrl: './clinics.component.html',
  styleUrls: ['./clinics.component.css'],
  providers: [ClinicsService,MarianZagadochnijService]
})
export class ClinicsComponent implements OnInit {
  clinics: Clinic[];
  constructor(private clinicsService:ClinicsService, private marjan: MarianZagadochnijService) { }

  ngOnInit() {
    this.clinics = this.clinicsService.clinics;
    this.marjan.marjan().subscribe((responce)=> console.log(responce))

  }

}
