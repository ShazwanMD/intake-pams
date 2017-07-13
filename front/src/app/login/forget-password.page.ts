import {Component} from '@angular/core';

import {Router, ActivatedRoute} from '@angular/router';
import {TdLoadingService} from '@covalent/core';
import { FormGroup, FormBuilder } from "@angular/forms";
import { RegistrationModuleState } from "../registration/index";
import { Store } from "@ngrx/store";
import { RegistrationActions } from "../registration/registration.action";
import { UserRegistration } from "../shared/model/registration/user-registration.interface";

@Component({
  selector: 'pams-login-forgetpassword',
  templateUrl: './forget-password.page.html',
  styleUrls: ['./forget-password.page.scss'],
})
export class ForgetPasswordComponent {

  // email: string;
  // password: string;

  private forgetPasswordForm: FormGroup;

  constructor(private _router: Router,
              private _loadingService: TdLoadingService,           
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private store: Store<RegistrationModuleState>,
              private registrationActions: RegistrationActions,) {
  }

    ngOnInit(): void {
    this.forgetPasswordForm = this.formBuilder.group(<UserRegistration>{
      name: '',
      email: '',
      identityNo: '',
      password: '',
    });
  }

  submit(email: String, isValid: boolean) {
    this.store.dispatch(this.registrationActions.forgetPassword(email));
  }
}
