import {Component, OnInit} from '@angular/core';
import {FormGroup, FormBuilder} from '@angular/forms';
import {RegistrationModuleState} from '../registration/index';
import {Store} from '@ngrx/store';
import {RegistrationActions} from '../registration/registration.action';
import {UserRegistration} from '../shared/model/registration/user-registration.interface';

@Component({
  selector: 'pams-login-forgetpassword',
  templateUrl: './forget-password.page.html',
  styleUrls: ['./forget-password.page.scss'],
})
export class ForgetPasswordPage implements OnInit {

  // email: string;
  // password: string;

  private forgetPasswordForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
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

  submit(email: String, isValid: boolean): void {
    this.store.dispatch(this.registrationActions.forgetPassword(email));
  }
}
