import { MyIntakeApplication } from './../../../shared/model/application/my-intake-application.interface';
import { Observable } from 'rxjs/Observable';
import { AddressChange } from './../../../shared/model/identity/address-change.interface';
import { IntakeApplication } from './../../../shared/model/application/intake-application.interface';
import { AuthenticatedUser } from './../../../shared/model/identity/authenticated-user.interface';

import {User} from '../../identity/user.interface';
import {AccountActions} from '../account.action';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import {AccountModuleState} from '../index';
import { AuthenticationService } from "../../../../services/authentication.service";

@Component({
  selector: 'pams-address-changer',
  templateUrl: './address-changer.dialog.html',
})

export class AddressChangerDialog implements OnInit {


 private INTAKE_APPLICATIONS: string[] = 'accountModuleState.intakeApplications'.split('.');

  private intakeApplications$: Observable<IntakeApplication[]>;

  private changeAddressForm: FormGroup;
  private _intakeApplication: IntakeApplication;
    private authenticatedUser: AuthenticatedUser;

  constructor(private formBuilder: FormBuilder,
              private dialog: MdDialogRef<AddressChangerDialog>,
              private store: Store<AccountModuleState>,
              private authnService: AuthenticationService,
              private router: Router,
              private actions: AccountActions) {
 this.intakeApplications$ = this.store.select(...this.INTAKE_APPLICATIONS);
  }

  set intakeApplications(value: IntakeApplication) {
    this._intakeApplication= value;
  }

  ngOnInit(): void {

    this.changeAddressForm = this.formBuilder.group({
      currentAddress: ['', Validators.required],
      newAddress: ['', Validators.required],
    });
  }

    logout(): void {
    this.authnService.logout();
    this.router.navigate(['/login']);
  }

  submit(changeAddress: AddressChange, valid: boolean) {
    this.store.dispatch(this.actions.changeApplicantAddress(changeAddress));
    this.dialog.close();
 //   this.logout();   
} 
}