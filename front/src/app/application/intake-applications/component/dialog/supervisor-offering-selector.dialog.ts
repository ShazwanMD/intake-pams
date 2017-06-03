import { SupervisorOffering } from './../../../../policy/intakes/supervisor-offering.interface';
import {Component, ViewContainerRef, OnInit, Input} from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {ApplicationModuleState} from "../../../index";
import {IntakeApplicationActions} from "../../intake-application.action";
import {IntakeApplication} from "../../intake-application.interface";
import {Intake} from "../../../../policy/intakes/intake.interface";
import {ProgramOffering} from "../../../../policy/intakes/program-offering.interface";
import {Observable} from "rxjs/Observable";
import { MdDialogRef } from "@angular/material";



@Component({
  selector: 'pams-supervisor-offering-selector',
  templateUrl: './supervisor-offering-selector.dialog.html',
})

export class SupervisorOfferingSelectorDialog implements OnInit {

  private SUPERVISOR_OFFERINGS: string[] = "applicationModuleState.supervisorOfferings".split(".");
  private _intake: Intake;
  private _intakeApplication: IntakeApplication;
  private supervisorOfferings$: Observable<SupervisorOffering[]>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private actions: IntakeApplicationActions,
              private store: Store<ApplicationModuleState>,
              private dialog: MdDialogRef<SupervisorOfferingSelectorDialog>) {
    this.supervisorOfferings$ = this.store.select(...this.SUPERVISOR_OFFERINGS);
  }

  set intake(value: Intake) {
    this._intake = value;
  }

  set intakeApplication(value: IntakeApplication) {
    this._intakeApplication = value;
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findSupervisorOfferingsByIntake(this._intake));
  }

 select(offering: SupervisorOffering) {
    console.log("selecting " + offering.supervisorCode);
    this.store.dispatch(this.actions.selectSupervisorOffering(this._intakeApplication, offering));
    this.dialog.close();
  }
}
