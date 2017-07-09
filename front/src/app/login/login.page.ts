import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {TdLoadingService} from '@covalent/core';
import {AuthenticationService} from '../../services/authentication.service';
import {AuthorizationService} from '../../services/authorization.service';
import {SystemService} from '../../services/system.service';
import {Module} from '../shared/model/system/module.interface';
import {toPromise} from 'rxjs/operator/toPromise';

@Component({
  selector: 'pams-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage {

  username: string;
  password: string;

  constructor(private _router: Router,
              private _loadingService: TdLoadingService,
              private authnService: AuthenticationService,
              private authzService: AuthorizationService,
              private systemService: SystemService) {
  }

  login(): void {
    this.authzService.flushRoles();
    this.authnService.login(this.username, this.password)
      .subscribe((result) => {
        if (result === true) {
          // login successful
          this.populatePermission();
        } else {
          // login failed
          // this.error = 'Username or password is incorrect';
        }
      });
  }

  populatePermission(): void {
    this.authnService.roles.forEach((role: string) => {
      this.authzService.attachRole(role);
    });

    this.systemService.findAuthorizedModules()
      .map((modules: Module[]) => {
        for (let module of modules) {
          console.log('module: ' + module.code);
          this.authzService.addAbility('ROLE_USER', 'VIEW_' + module.code);
        }

        if (this.authzService.hasRole('ROLE_ADMINISTRATOR') && this.authzService.hasRole('ROLE_USER')) {
          this._router.navigate(['/secure/administrator']);
        } else if (this.authzService.hasRole('ROLE_USER')) {
          this._router.navigate(['/secure/applicant']);
        } else {
          this._router.navigate(['/secure/somewhere']);
        }
      })
      .toPromise();

  }
}
