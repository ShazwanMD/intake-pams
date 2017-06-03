import { Referee } from './../../referee.interface';
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
  selector: 'pams-referee-creator',
  templateUrl: './referee-creator.dialog.html',
})

export class RefereeCreatorDialog implements OnInit {

  private _intakeApplication: IntakeApplication;
  private createForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<ApplicationModuleState>,
              private actions: IntakeApplicationActions,
              private dialog: MdDialogRef<RefereeCreatorDialog>) {
  }


  set intakeApplication(value: IntakeApplication) {
    this._intakeApplication = value;
  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group(<Referee>{
      id: null,
      name: '',
      officeAddrs: '',
      occupation: '',
      phoneNo: ''
    });
  }

  save(referee: Referee, isValid: boolean) {
    this.store.dispatch(this.actions.addReferee(this._intakeApplication, referee));
    this.dialog.close();
  }
}
