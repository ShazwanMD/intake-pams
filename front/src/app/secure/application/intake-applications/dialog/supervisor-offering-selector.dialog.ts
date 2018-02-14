import { MdDialogRef } from '@angular/material';
import { ApplicationModuleState } from './../../index';
import { IntakeApplicationActions } from './../intake-application.action';
import { Router, ActivatedRoute } from '@angular/router';
import { IntakeApplication } from './../../../../shared/model/application/intake-application.interface';
import { Component, Input, OnInit, ViewContainerRef } from '@angular/core';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import { FormControl, FormBuilder } from '@angular/forms';
import { SupervisorOffering } from '../../../../shared/model/policy/supervisor-offering.interface';
import { CommonActions } from '../../../../common/common.action';
import { CommonModuleState } from '../../../../common/index';
import { ProgramLevel } from '../../../../shared/model/policy/program-level.interface';
@Component({
  selector: 'pams-supervisor-offering-selector',
  templateUrl: './supervisor-offering-selector.dialog.html',
})
export class SupervisorOfferingSelectorDialog implements OnInit {
  private SUPERVISOR_OFFERINGS: string[] = 'applicationModuleState.supervisorOfferings'.split('.');
  private supervisorOfferings$: Observable<SupervisorOffering[]>;
  private _intakeApplication: IntakeApplication;
  private _programLevel: ProgramLevel;

  constructor(private router: Router,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private viewContainerRef: ViewContainerRef,
    private actions: IntakeApplicationActions,
    private store: Store<ApplicationModuleState>,
    private dialog: MdDialogRef<SupervisorOfferingSelectorDialog>) {

this.supervisorOfferings$ = this.store.select(...this.SUPERVISOR_OFFERINGS);
}

set programLevel(value: ProgramLevel) {
  this._programLevel = value;
}

set intakeApplication(value: IntakeApplication) {
  this._intakeApplication = value;
}

  ngOnInit() {
    this.store.dispatch(this.actions.findSupervisorOfferingsByProgramLevel(this._programLevel));
  }
  
select(offering: SupervisorOffering) {
  // console.log('selecting ' + offering.supervisor.code);
  this.store.dispatch(this.actions.selectSupervisorOffering(this._intakeApplication, offering));
  this.dialog.close();
}
}