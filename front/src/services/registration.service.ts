import {Injectable} from '@angular/core';
import {Response} from '@angular/http';
import {HttpInterceptorService} from '@covalent/http';
import {environment} from '../environments/environment';
import {Observable} from 'rxjs';
import {UserRegistration} from '../app/shared/model/registration/user-registration.interface';

@Injectable()
export class RegistrationService {

  private registration_api: string = environment.endpoint + '/api/registration';

  constructor(private _http: HttpInterceptorService) {
  }

  registerUser(registration: UserRegistration): Observable<String> {
    return this._http.post(this.registration_api + '/registerUser', JSON.stringify(registration))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  verifyUser(token: String): Observable<Boolean> {
    return this._http.get(this.registration_api + '/verifyUser/' + token)
      .map((res: Response) => <Boolean>res.json());
  }
}
