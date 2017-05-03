import {Component} from '@angular/core';

import {Router, ActivatedRoute} from '@angular/router';
import {TdLoadingService} from '@covalent/core';

@Component({
  selector: 'pams-login-forgetpassword',
  templateUrl: './forget-password.component.html',
  styleUrls: ['./login.component.scss'],
})
export class ForgetPasswordComponent {

  username: string;
  password: string;

  constructor(private _router: Router,
              private _loadingService: TdLoadingService) {
  }

   forgetPassword() : void {
    this._loadingService.register();
    alert('reset new password' + this.username);
    setTimeout(() => {
      this._router.navigate(['/']);
      this._loadingService.resolve();
    }, 2000);
  }

}
