import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Http} from "@angular/http";


@Component({
  selector: 'app-contacts',
  templateUrl: './contacts.component.html',
  styleUrls: ['./contacts.component.css']
})
export class ContactsComponent implements OnInit {
  contactUsForm: FormGroup;

  constructor(private http: Http) { }

  ngOnInit() {
    this.contactUsForm = new FormGroup ({
      'name': new FormControl(null, Validators.required),
      'email': new FormControl(null, [ Validators.required, Validators.email]),
      'phone': new FormControl(null, ),
      'subject': new FormControl(null, Validators.required),
      'message': new FormControl(null, Validators.required)
    })

  }

  onSubmit(){
    console.log(this.contactUsForm)
    this.contactUsForm.reset();
  }

  onSend(){
    // http://192.168.101.30:8080/
    this.http.post('http://10.4.48.181:8080/contact1', null).subscribe(
      (response) => console.log(response),
    );
  }
}
