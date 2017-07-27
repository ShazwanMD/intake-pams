import {Component, OnInit} from '@angular/core';
import {FormGroup, FormBuilder, Validators} from '@angular/forms';
import {RegistrationModuleState} from '../registration/index';
import {Store} from '@ngrx/store';
import {RegistrationActions} from '../registration/registration.action';

@Component({
  selector: 'pams-login-forget-password',
  templateUrl: './forget-password.page.html',
  styleUrls: ['./forget-password.page.scss'],
})
export class ForgetPasswordPage implements OnInit {

  private forgetPasswordForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private store: Store<RegistrationModuleState>,
              private registrationActions: RegistrationActions,
  ) {
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
