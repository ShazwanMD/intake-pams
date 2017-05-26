import { Address } from './../../address.interface';
import {Component, ViewContainerRef, OnInit, Input} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {ApplicationModuleState} from "../../../index";
import {MdDialogRef} from "@angular/material";
import {IntakeApplicationActions} from "../../intake-application.action";
import {IntakeApplication} from "../../intake-application.interface";



@Component({
  selector: 'pams-address-creator',
  templateUrl: './address-creator.dialog.html',
})

export class AddressCreatorDialog implements OnInit {

  private _intakeApplication: IntakeApplication;
  private createForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<ApplicationModuleState>,
              private actions: IntakeApplicationActions,
              private dialog: MdDialogRef<AddressCreatorDialog>) {
  }


  set intakeApplication(value: IntakeApplication) {
    this._intakeApplication = value;
  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group(<Address>{
      id: null,
      address1: '',
      address2: '',
      address3: '',
      postcode: ''
    });
  }

  save(address: Address, isValid: boolean) {
    this.store.dispatch(this.actions.addAddress(this._intakeApplication, address));
    this.dialog.close();
  }
}
