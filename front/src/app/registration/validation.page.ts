import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {FormBuilder, FormGroup} from "@angular/forms";
import { UserRegistration } from "./user-registration.interface";

import {Store} from "@ngrx/store";
import {RegistrationModuleState} from "./index";
import {RegistrationActions} from "./registration.action";

@Component({
  selector: 'pams-validation-page',
  templateUrl: './validation.page.html',
})

  export class ValidationPage{ 
  //implements OnInit {

  private validationForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private store: Store<RegistrationModuleState>,
              private registrationActions:RegistrationActions) {
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { email: string }) => {


       let email: string = params.email;

      //trigger validation wording to email

     // if (null != email) 
       //   this.store.dispatch(this.actions.(email));
   });
  }

      validation() {
  }
  }
