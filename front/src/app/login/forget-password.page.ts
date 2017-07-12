import {Component} from '@angular/core';

import {Router, ActivatedRoute} from '@angular/router';
import {TdLoadingService} from '@covalent/core';

@Component({
  selector: 'pams-login-forgetpassword',
  templateUrl: './forget-password.page.html',
  styleUrls: ['./forget-password.page.scss'],
})
export class ForgetPasswordComponent {

  email: string;
  //password: string;

  constructor(private _router: Router,
              private _loadingService: TdLoadingService) {
  }

   forgetPassword() : void {

    this._loadingService.register();
    alert('forget password' + this.email);
    setTimeout(() => {
      this._router.navigate(['/']);
      this._loadingService.resolve();
    }, 2000);
  }

    //     register(registration: UserRegistration, isValid: boolean) {
  //   this.store.dispatch(this.registrationActions.registerUser(registration));
  // }

}
