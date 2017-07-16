import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs/Observable';
import {UserRegistration} from '../shared/model/registration/user-registration.interface';
import { RegistrationModuleState } from "../registration/index";
import { RegistrationActions } from "../registration/registration.action";

@Component({
  selector: 'pams-forget-password-information-page',
  templateUrl: './forget-password-information.page.html',
})

export class ForgetPasswordInformationPage {
  

  private REGISTRATION: string[] = 'registrationModuleState.registration'.split('.');
  private forgetPasswordForm: FormGroup;
  private registration$: Observable<UserRegistration>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private store: Store<RegistrationModuleState>,
              private registrationActions: RegistrationActions,) {
   this.registration$ = this.store.select(...this.REGISTRATION);
  }

  ngOnInit(): void {
    this.forgetPasswordForm = this.formBuilder.group({
      email: '',
    });
  }

}
