import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, NgForm, Validators} from "@angular/forms";
import {UserService} from '../../user.service';
import {UserModel} from "../../user.model";
import {error} from "util";

@Component({
  selector: 'app-user-cabinet-profile',
  templateUrl: './user-cabinet-profile.component.html',
  styleUrls: ['./user-cabinet-profile.component.css']
})
export class UserCabinetProfileComponent implements OnInit {
  name: string = 'Yana';
  editUserForm: FormGroup;
  user: UserModel= new UserModel;

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.editUserForm = new FormGroup({
      'name': new FormControl('Yana',Validators.required),
      'lastName': new FormControl('Martynyak',Validators.required),
      'email': new FormControl('y@y.com',[Validators.required,Validators.email]),
    })
  }
  onSubmit() {
  console.log(this.editUserForm.value.name);
    console.log("here");

  }
  onSave(){
    this.user= this.editUserForm.value;
    console.log(this.user);
    this.userService.registerApartmentWithUser(this.user).subscribe(
      (response)=> console.log(response),
      (error)=> console.error(error)
    )


  }

}
