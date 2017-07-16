import {Component, OnInit} from '@angular/core';
import {FormGroup, FormBuilder, Validators} from '@angular/forms';
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
    let emailPattern: string = '^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$';
    this.forgetPasswordForm = this.formBuilder.group({
      name: [''],
      email: ['', Validators.pattern(emailPattern)],
      identityNo: [''],
      password: [''],
    });
  }

  submit(forgetPasswordForm: any, isValid: boolean): void {
    console.log('submit email=: ', forgetPasswordForm.email);
    this.store.dispatch(this.registrationActions.forgetPassword(forgetPasswordForm.email));
  }
}
