import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/filter';
import {Http, Response} from '@angular/http';
import {Headers} from '@angular/http';
import {tokenNotExpired} from 'angular2-jwt';
import {environment} from '../environments/environment';
import {AuthenticatedUser} from "../app/shared/model/identity/authenticated-user.interface";

/**
 */
@Injectable()
export class AuthenticationService {

  private _roles: string[];
  private _authenticatedUser: AuthenticatedUser;
  public token: string;
  public parsedToken: any;

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

          // look at claims
          this.parsedToken = this.parseToken();
          this._roles = this.parsedToken.role.split(',');
          console.log('role: ' + this._roles);

          // return true to indicate successful login
          return true;
        } else {
          // return false to indicate failed login
          return false;
        }
      });
  }

  parseToken(): any {
    let base64Url: string = this.token.split('.')[1];
    let base64: string = base64Url.replace('-', '+').replace('_', '/');
    console.log('token: ' + JSON.stringify(JSON.parse(window.atob(base64))));
    return JSON.parse(window.atob(base64));
  }

  logout(): void {
    // clear token remove user from local
    // storage to log user out
    this.token = undefined;
    localStorage.removeItem('currentUser');
    this.authenticatedUser = undefined;
    // todo: clear store by dispatching init
  }

  isLoggedIn(): boolean {
    return tokenNotExpired('currentUser');
  }

  currentUsername(): any {
    return JSON.parse(localStorage.getItem('currentUser'));
  }

  get roles(): string[] {
    return this._roles;
  }

  get authenticatedUser(): AuthenticatedUser {
    return this._authenticatedUser;
  }

  set authenticatedUser(value: AuthenticatedUser) {
    this._authenticatedUser = value;
  }
}
