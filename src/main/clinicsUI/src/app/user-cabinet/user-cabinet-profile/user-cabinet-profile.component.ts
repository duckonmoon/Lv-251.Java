import {Component, Input, OnInit} from '@angular/core';
import {FormControl, FormGroup, NgForm, Validators} from "@angular/forms";
import {UserService} from '../../user.service';

import {error} from "util";
import {User} from "../../models/user";

@Component({
  selector: 'app-user-cabinet-profile',
  templateUrl: './user-cabinet-profile.component.html',
  styleUrls: ['./user-cabinet-profile.component.css']
})
export class UserCabinetProfileComponent implements OnInit {
  editUserForm: FormGroup;
  userUpdate = new User;
  user:User=JSON.parse(localStorage.getItem("currentUser"));

  constructor(private userService: UserService) { }

  ngOnInit() {

    this.editUserForm = new FormGroup({
      'name': new FormControl('',Validators.required),
      'lastName': new FormControl('',Validators.required),
      'email': new FormControl(this.user.email,[Validators.required,Validators.email]),
      'city': new FormControl(''),
      'district': new FormControl(''),
      'address': new FormControl(''),
    })
  }
  onSave(){
    this.userUpdate= this.editUserForm.value;
    this.userUpdate.id =2;
    console.log(this.userUpdate);
    this.userService.updateUser(this.userUpdate).subscribe(
      (response)=> console.log(response),
      (error)=> console.error(error)
    )


  }

}
