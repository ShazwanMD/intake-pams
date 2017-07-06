import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {TdLoadingService} from '@covalent/core';
import {AuthenticationService} from '../../services/authentication.service';
import {AuthorizationService} from '../../services/authorization.service';

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
              private authzService: AuthorizationService) {
  }

  login(): void {
    this.authnService.login(this.username, this.password)
      .subscribe((result) => {
        if (result === true) {
          // login successful
          this.populatePermission();

          this._router.navigate(['/']);
        } else {
          // login failed
          // this.error = 'Username or password is incorrect';
        }
      });
  }

  populatePermission(): void {
    // todo: we should pull permission via promise here
    // todo: and populate authnService
    let aclData: any = {
      user: ['logout', 'view_content'],
    }
    this.authzService.setAbilities(aclData);
    this.authzService.attachRole('user');
  }
}
