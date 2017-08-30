import {Http, RequestOptions} from "@angular/http";
import {Injectable} from "@angular/core";
import {User} from "../../models/user";
import  {Headers} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
@Injectable()
export  class  UserCabinetDoctorsService {
  private baseUrl = 'http://localhost:8080';
  constructor(private http: Http){}

   getDoctorsByUser( userId: number):Observable<any>{
     let options = new RequestOptions({headers: new Headers({'Content-Type': 'application/json'})});
     return this.http.get(this.baseUrl+'/api/getDoctorsToUser/'+userId)
       .map((response) => response.json())
       .catch((error)=>Observable.throw(error));
   }
}

