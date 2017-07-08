import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Store} from '@ngrx/store';
import {RegistrationModuleState} from './index';
import {RegistrationActions} from './registration.action';
import {UserRegistration} from '../shared/model/registration/user-registration.interface';

@Component({
  selector: 'pams-registration-page',
  templateUrl: './registration.page.html',
})

export class RegistrationPage implements OnInit {

  private registrationForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private store: Store<RegistrationModuleState>,
              private registrationActions: RegistrationActions,
          ) {
  }

  ngOnInit(): void {
    this.registrationForm = this.formBuilder.group(<UserRegistration>{
      name: '',
      email: '',
      identityNo: '',
      password: '',
    });
  }

  register(registration: UserRegistration, isValid: boolean) {
    this.store.dispatch(this.registrationActions.registerUser(registration));
  }
}
