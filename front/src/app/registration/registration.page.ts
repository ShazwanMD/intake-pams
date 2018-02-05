import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {FormBuilder, FormGroup,Validators, AbstractControl} from '@angular/forms';
import {Store} from '@ngrx/store';
import {RegistrationModuleState} from './index';
import {RegistrationActions} from './registration.action';
import {UserRegistration} from '../shared/model/registration/user-registration.interface';
import { MdSnackBar } from "@angular/material";
import { PasswordValidation } from '../shared/component/password-validation';

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
              private snackBar: MdSnackBar,
          ) {
  }

  ngOnInit(): void {
    let emailPattern: string = '^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$';
   // let password = 'password';
    this.registrationForm = this.formBuilder.group({
      name: ['', Validators.required],
      email: ['', [(Validators.required), (Validators.pattern(emailPattern))]],
      identityNo: ['', Validators.required],
      password: ['', Validators.required],
      confirmPassword :['', Validators.required],
    },
    { validator: this.matchingPasswords } 
  )
  } 

  private matchingPasswords( AC: AbstractControl ) {
    const password = AC.get( 'password' );
    const confirmPassword = AC.get( 'confirmPassword' );

    if ( !password || !confirmPassword ) {
      return null;
    }

    return password.value === confirmPassword.value ? null : { nomatch: true };
  }
  
  register(registration: UserRegistration, isValid: boolean) {
    this.store.dispatch(this.registrationActions.registerUser(registration));
  }
}
