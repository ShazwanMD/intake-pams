import {Component, Input, OnInit, ViewContainerRef} from '@angular/core';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {FormControl, FormBuilder} from '@angular/forms';
import {CommonActions} from '../../common.action';
import {CommonModuleState} from '../../index';
import {ProgramLevel} from '../../../shared/model/policy/program-level.interface';
import { SupervisorOffering } from '../../../shared/model/policy/supervisor-offering.interface';
import { IntakeApplication } from '../../../shared/model/application/intake-application.interface';
import { Router, ActivatedRoute } from '@angular/router';
import { IntakeApplicationActions } from '../../../secure/application/intake-applications/intake-application.action';
import { ApplicationModuleState } from '../../../secure/application/index';
import { MdDialogRef } from '@angular/material';
import { SupervisorOfferingSelectorDialog } from '../../../secure/application/intake-applications/dialog/supervisor-offering-selector.dialog';

@Component({
  selector: 'pams-supervisor-offering-select',
  templateUrl: './supervisor-offering-select.component.html',
  styleUrls: ['./supervisor-offering-select.scss'],
})
export class SupervisorOfferingSelectComponent implements OnInit {

  private SUPERVISOR_OFFERINGS: string[] = 'commonModuleState.supervisorOfferings'.split('.');
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

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


  selectChangeEvent(event: SupervisorOffering) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}
