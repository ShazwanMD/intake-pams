import { AddressChange } from './../../../shared/model/identity/address-change.interface';
import { IntakeApplication } from './../../../shared/model/application/intake-application.interface';
import {AuthenticatedUser} from '../../../shared/model/identity/authenticated-user.interface';
import {AccountActions} from '../account.action';
import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import {AccountModuleState} from '../index';
import {AuthenticationService} from '../../../../services/authentication.service';
import {EmailChange} from '../../../shared/model/identity/email-change.interface';

@Component({
  selector: 'pams-result-candidate',
  templateUrl: './result-candidate.dialog.html',
})

export class ResultCandidateDialog implements OnInit {

  private changeAddressForm: FormGroup;
  private _intakeApplication: IntakeApplication;
  private authenticatedUser: AuthenticatedUser;
  

  constructor(private formBuilder: FormBuilder,
              private dialog: MdDialogRef<ResultCandidateDialog>,
              private store: Store<AccountModuleState>,
              private authnService: AuthenticationService,
              private router: Router,
              private actions: AccountActions) {
  }

  set intakeApplication(value: IntakeApplication) {
    this._intakeApplication = value;
  }

  ngOnInit(): void {
    this.changeAddressForm = this.formBuilder.group({
      currentAddress: ['', Validators.required],
      newAddress: ['', Validators.required],
      newAddressAgain: ['', Validators.required],
    });
  }

  logout(): void {
    this.authnService.logout();
    this.router.navigate(['/login']);
  }

  submit(change: AddressChange, valid: boolean) {
    this.store.dispatch(this.actions.changeApplicantAddress(change));
    this.dialog.close();
  }
}
