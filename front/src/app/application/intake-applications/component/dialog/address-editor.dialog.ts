import {CountryCode} from '../../../../common/country-codes/country-code.interface';
import {StateCode} from '../../../../common/state-codes/state-code.interface';
import {Address} from '../../address.interface';
import {Component, ViewContainerRef, OnInit, Input} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {ApplicationModuleState} from "../../../index";
import {MdDialogRef} from "@angular/material";
import {IntakeApplicationActions} from "../../intake-application.action";
import {IntakeApplication} from "../../intake-application.interface";
import {AddressType} from "../../address-type.enum";


@Component({
  selector: 'pams-address-editor',
  templateUrl: './address-editor.dialog.html',
})

export class AddressEditorDialog implements OnInit {

  private _intakeApplication: IntakeApplication;
  private editForm: FormGroup;
  private _address: Address;
  private edit: boolean = false;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<ApplicationModuleState>,
              private actions: IntakeApplicationActions,
              private dialog: MdDialogRef<AddressEditorDialog>) {
  }


  set intakeApplication(value: IntakeApplication) {
    this._intakeApplication = value;
  }

  set address(value: Address) {
    this._address = value;
    this.edit = true;
  }


  ngOnInit(): void {
    this.editForm = this.formBuilder.group(<Address>{
      id: null,
      address1: '',
      address2: '',
      address3: '',
      postcode: '',
      stateCode: <StateCode>{},
      countryCode: <CountryCode>{},
      addressType: AddressType.MAILING,
    });
    if (this.edit) this.editForm.patchValue(this._address);
  }

  submit(address: Address, isValid: boolean) {
    if (this.edit) this.store.dispatch(this.actions.updateAddress(this._intakeApplication, address));
    else  this.store.dispatch(this.actions.addAddress(this._intakeApplication, address));
    this.dialog.close();
  }
}
