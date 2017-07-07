import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/filter';
import {Http, Response} from '@angular/http';
import {Headers} from '@angular/http';
import {tokenNotExpired} from 'angular2-jwt';
import {environment} from '../environments/environment';

/**
 */
@Injectable()
export class AuthenticationService {

  public token: string;

  constructor(private http: Http) {
    let currentUser: any = JSON.parse(localStorage.getItem('currentUser'));
    this.token = currentUser && currentUser.token;
    console.log('currentUser: ' + currentUser);
    console.log('token: ' + this.token);
  }

  login(username: string, password: string): Observable<boolean> {
    return this.http.post(
      environment.endpoint + '/api/authentication/login',
      JSON.stringify({username: username, password: password}),
      {headers: new Headers({'Content-Type': 'application/json'})})
      .map((res: Response) => {
        // login successful if there's a jwt token in the res
        let token: any = res.json() && res.json().token;
        if (token) {
          this.token = token;

          // store username and jwt token in local storage to keep user logged in between page refreshes
          localStorage.setItem('currentUser', JSON.stringify({username: username, token: token}));
          // return true to indicate successful login
          return true;
        } else {
          // return false to indicate failed login
          return false;
        }
      });
  }

  logout(): void {
    // clear token remove user from local storage to log user out
    this.token = undefined;
    localStorage.removeItem('currentUser');
  }

  isLoggedIn(): boolean {
    return tokenNotExpired('currentUser');
  }

  currentUsername(): any {
    return JSON.parse(localStorage.getItem('currentUser'))}
}
