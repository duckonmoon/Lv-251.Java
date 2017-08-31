import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, NgForm, Validators} from "@angular/forms";
import {UserService} from '../../user.service';
import {UserModel} from "../../user.model";
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

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.editUserForm = new FormGroup({
      'name': new FormControl('Yana',Validators.required),
      'lastName': new FormControl('Martynyak',Validators.required),
      'email': new FormControl('y@y.com',[Validators.required,Validators.email]),
      'city': new FormControl('dd'),
      'district': new FormControl('dd'),
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
