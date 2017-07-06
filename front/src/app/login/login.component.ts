import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {TdLoadingService} from '@covalent/core';
import {AuthenticationService} from '../../services/authentication.service';
import {AuthorizationService} from '../../services/authorization.service';
import {SystemService} from '../../services/system.service';
import {Module} from '../system/module.interface';
import {toPromise} from 'rxjs/operator/toPromise';

@Component({
  selector: 'pams-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {

  username: string;
  password: string;

  constructor(private _router: Router,
              private _loadingService: TdLoadingService,
              private authnService: AuthenticationService,
              private authzService: AuthorizationService,
              private systemService: SystemService) {
  }

  login(): void {
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
    // todo: we should pull permission via promise here
    // todo: and populate authnService
    // {"roles":["user"],"abilities":{"user":["VIEW_APN","VIEW_PLC"]}}
    this.authzService.attachRole('user');
    this.systemService.findAuthorizedModules()
      .map((modules: Module[]) => {
        for (let module of modules) {
          console.log('module: ' + module.code);
          this.authzService.addAbility('user', 'VIEW_' + module.code);
        }
        this._router.navigate(['/']);
      })
      .toPromise();

    // let aclData: any = {
    //   user: ['VIEW_APN', 'VIEW_PLC'],
    // }
    //
    // this.authzService.setAbilities(aclData);
  }
}
