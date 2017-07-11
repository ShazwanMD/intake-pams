import {Component} from '@angular/core';

import {Router, ActivatedRoute} from '@angular/router';
import {TdLoadingService} from '@covalent/core';

@Component({
  selector: 'pams-applicant-changepassword',
  templateUrl: './change-password.page.html',
  styleUrls: ['./change-password.page.scss'],
})
export class ChangePasswordComponent {

  username: string;
  password: string;

  constructor(private _router: Router,
              private _loadingService: TdLoadingService) {
  }

   changePassword() : void {
    this._loadingService.register();
    alert('reset new password' + this.username);
    setTimeout(() => {
      this._router.navigate(['/']);
      this._loadingService.resolve();
    }, 2000);
  }
  

}
