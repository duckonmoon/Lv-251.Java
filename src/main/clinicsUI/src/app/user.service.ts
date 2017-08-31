import 'rxjs/add/operator/toPromise';
import {Http, RequestOptions} from '@angular/http';
import {Injectable} from '@angular/core';
import {UserModel} from './user.model';
import  {Headers} from '@angular/http';
import {Observable} from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import {User} from "./models/user";

@Injectable()
export  class UserService {
  private baseUrl = 'http://localhost:8080';


  constructor(private http: Http) {
  }

  updateUser(user: User): Observable<any> {
    let options = new RequestOptions({headers: new Headers({'Content-Type': 'application/json'})});
    return this.http.post(this.baseUrl + '/api/editUser/'+user.id, user, options);
  }
  getAppointmentsToUser( userId: number):Observable<any>{
    let options = new RequestOptions({headers: new Headers({'Content-Type': 'application/json'})});
    return this.http.get(this.baseUrl+'/api/getAppointmentsToUser/'+userId)
      .map((response) => response.json())
      .catch((error)=>Observable.throw(error));
  }
}
