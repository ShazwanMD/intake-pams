import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {TdLoadingService} from '@covalent/core';
import {AuthenticationService} from '../../services/authentication.service';
import {AuthorizationService} from '../../services/authorization.service';
import {SystemService} from '../../services/system.service';
import {Module} from '../shared/model/system/module.interface';
import {AuthenticatedUser} from '../shared/model/identity/authenticated-user.interface';

@Component({
  selector: 'pams-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage {

  username: string;
  password: string;

  constructor(private router: Router,
              private authnService: AuthenticationService,
              private authzService: AuthorizationService,
              private systemService: SystemService) {
  }

  login(): void {
    this.authzService.flushRoles();
    this.authnService.login(this.username, this.password)
      .subscribe((result: boolean) => {
        if (result === true) {
          console.log('LoginPage: ' + result);
          // login successful
          this.populateUser();
          this.populatePermission();
          // navigate to secure area
          console.log('to secure page');
          this.router.navigate(['/secure']);
        } else {
          // login failed
          // this.error = 'Username or password is incorrect';
        }
      });
  }

  populateUser(): void {
    console.log('populate user');
    this.systemService.findAuthenticatedUser()
      .map((user: AuthenticatedUser) => {
        this.authnService.authenticatedUser = user;
        console.log('user: ' + JSON.stringify(user));
      })
      .toPromise();
  }

  populatePermission(): void {
    console.log('populate permission');
    this.authnService.roles.forEach((role: string) => {
      this.authzService.attachRole(role);
    });

    this.systemService.findAuthorizedModules()
      .map((modules: Module[]) => {

        // load authorized modules
        for (let module of modules) {
          console.log('module: ' + module.code);
          this.authzService.addAbility('ROLE_USER', 'VIEW_' + module.code);
        }

      })
      .toPromise();

  }
}
