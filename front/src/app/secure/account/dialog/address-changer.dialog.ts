import { intakeApplicationRoutes } from './../../application/intake-applications/intake-application.routes';
import { AddressChange } from './../../../shared/model/identity/address-change.interface';
import { IntakeApplication } from './../../../shared/model/application/intake-application.interface';
import {AuthenticatedUser} from '../../../shared/model/identity/authenticated-user.interface';
import {AccountActions} from '../account.action';
import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import {Store} from '@ngrx/store';
import { MdDialogRef, MdSnackBar } from '@angular/material';
import {AccountModuleState} from '../index';
import {AuthenticationService} from '../../../../services/authentication.service';
import {EmailChange} from '../../../shared/model/identity/email-change.interface';

@Component({
  selector: 'pams-address-changer',
  templateUrl: './address-changer.dialog.html',
})

export class AddressChangerDialog implements OnInit {

  private changeAddressForm: FormGroup;
  private _intakeApplication: IntakeApplication;
  private authenticatedUser: AuthenticatedUser;
  // private edit : boolean = false;

  constructor(private formBuilder: FormBuilder,
              private route: ActivatedRoute,
              private dialog: MdDialogRef<AddressChangerDialog>,
              private store: Store<AccountModuleState>,
              private authnService: AuthenticationService,
              private router: Router,
              private actions: AccountActions,
               private snackBar: MdSnackBar) {
  }

  set intakeApplication(value : IntakeApplication) {
    this._intakeApplication = value;
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findSubmittedIntakeApplications());
    this.changeAddressForm = this.formBuilder.group({    
      currentAddress: [this._intakeApplication.officialAddress1, Validators.compose([Validators.required])],
      newAddress: ['', Validators.required],
     
    });
    // if(this.edit)this.changeAddressForm.patchValue(this._intakeApplication);
  }

  logout(): void {
    this.authnService.logout();
    this.router.navigate(['/login']);
  }

    submit(change: AddressChange, isValid: boolean) {
    console.log('address change to: ', change);
    let snackBarRef = this.snackBar.open('confirm submit address changes?', 'Ok');
    snackBarRef.afterDismissed().subscribe(() => {
    if (!change.currentAddress) this.store.dispatch(this.actions.updateIntakeApplication(change));
    else  this.store.dispatch(this.actions.changeApplicantAddress(change));
    this.dialog.close();
    });
  }

  goBack(): void {
    this.router.navigate(['/secure']);
  }
}

 

