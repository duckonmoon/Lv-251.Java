import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, NgForm} from "@angular/forms";

@Component({
  selector: 'app-user-cabinet-profile',
  templateUrl: './user-cabinet-profile.component.html',
  styleUrls: ['./user-cabinet-profile.component.css']
})
export class UserCabinetProfileComponent implements OnInit {
  name: string = 'Yana';
  editUserForm: FormGroup;

  constructor() { }

  ngOnInit() {
    this.editUserForm = new FormGroup({
      'name': new FormControl('Yana'),
      'lastName': new FormControl('Martynyak'),
      'email': new FormControl('y@y.com'),
    })
  }
  onSubmit(form: NgForm) {
console.log(form);
    console.log("here");
  }

}
