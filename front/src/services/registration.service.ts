import {Injectable} from '@angular/core';
import {Response, Http, RequestOptions, Headers} from '@angular/http';
import {HttpInterceptorService} from '@covalent/http';
import {environment} from "../environments/environment";
import {ProgramCode} from "../app/common/program-codes/program-code.interface";
import {Observable} from "rxjs";
import {FacultyCode} from "../app/common/faculty-codes/faculty-code.interface";
import {UserRegistration} from "../app/registration/user-registration.interface";

@Injectable()
export class RegistrationService {

  constructor(private http: Http,
              private _http: HttpInterceptorService) {
  }

  registerUser(registration: UserRegistration): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/registration/registerUser', JSON.stringify(registration), options)
      .flatMap((res:Response) => Observable.of(res.text()));
  }

  verifyUser(token: String): Observable<Boolean> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/registration/verifyUser', JSON.stringify(token), options)
      .flatMap((res:Response) => Observable.of(Boolean(res.text())));
  }
}
