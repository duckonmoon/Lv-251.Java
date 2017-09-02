import { Component, OnInit } from '@angular/core';
import {ClinicsService} from "../clinics-service";

@Component({
  selector: 'app-clinics-edit',
  templateUrl: './clinics-edit.component.html',
  styleUrls: ['./clinics-edit.component.css']
})
export class ClinicsEditComponent implements OnInit {

  constructor(private clinicsService:ClinicsService) { }

  ngOnInit() {
  }

}
