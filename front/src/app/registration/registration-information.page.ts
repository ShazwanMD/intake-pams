import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {FormBuilder, FormGroup} from "@angular/forms";
import { UserRegistration } from "./user-registration.interface";

import {Store} from "@ngrx/store";
import {RegistrationModuleState} from "./index";
import {RegistrationActions} from "./registration.action";
import { Observable } from "rxjs/Observable";

@Component({
  selector: 'pams-registration-information-page',
  templateUrl: './registration-information.page.html',
})

  export class RegistrationInformationPage{ 
  
  //implements OnInit {
  private REGISTRATION: string[] = 'registrationModuleState.registration'.split('.');

  private registrationForm: FormGroup;
  private registration$: Observable<UserRegistration>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private store: Store<RegistrationModuleState>,
              private registrationActions:RegistrationActions
              ) {
              this.registration$ = this.store.select(...this.REGISTRATION);
  }
 
  ngOnInit(): void {
    this.registrationForm = this.formBuilder.group({
     email: '',
   });
  }

   
}
