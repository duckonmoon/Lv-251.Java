import {Injectable} from "@angular/core";
import {Http} from "@angular/http";

@Injectable()
export class MarianZagadochnijService{
  constructor(private http: Http){}
  marjan() {
    return this.http.get("http://localhost:8080/api/getAllClinics");
  }
}
