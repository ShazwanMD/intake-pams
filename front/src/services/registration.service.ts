import {Injectable} from '@angular/core';
import {Response, Http, RequestOptions, Headers} from '@angular/http';
import {HttpInterceptorService} from '@covalent/http';
import {environment} from '../environments/environment';
import {Observable} from 'rxjs';
import {UserRegistration} from '../app/registration/user-registration.interface';
import {AuthenticationService} from './authentication.service';

@Injectable()
export class RegistrationService {

  constructor(private http: Http,
              private _http: HttpInterceptorService,
              private authnService: AuthenticationService) {
  }

  registerUser(registration: UserRegistration): Observable<String> {
    let headers: Headers = new Headers({'Content-Type': 'application/json'});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/registration/registerUser', JSON.stringify(registration), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  verifyUser(token: String): Observable<Boolean> {
    let headers: Headers = new Headers();
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/registration/verifyUser/' + token, options)
      .map((res: Response) => <Boolean>res.json());
  }
}
