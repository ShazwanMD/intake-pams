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
import { StudyModeOffering } from "../../../../policy/intakes/study-mode-offering.interface";
import { MdDialogRef } from "@angular/material";



@Component({
  selector: 'pams-study-mode-offering-selector',
  templateUrl: './study-mode-offering-selector.dialog.html',
})

export class StudyModeOfferingSelectorDialog implements OnInit {

  private STUDY_MODE_OFFERINGS: string[] = "applicationModuleState.studyModeOfferings".split(".");
  private _intake: Intake;
  private _intakeApplication: IntakeApplication;
  private studyModeOfferings$: Observable<StudyModeOffering[]>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private actions: IntakeApplicationActions,
              private store: Store<ApplicationModuleState>,
              private dialog: MdDialogRef<StudyModeOfferingSelectorDialog>) {
    this.studyModeOfferings$ = this.store.select(...this.STUDY_MODE_OFFERINGS);
  }

  set intake(value: Intake) {
    this._intake = value;
  }

  set intakeApplication(value: IntakeApplication) {
    this._intakeApplication = value;
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findStudyModeOfferingsByIntake(this._intake));
  }

 select(offering: StudyModeOffering) {
    console.log("selecting " + offering.studyMode.code);
    this.store.dispatch(this.actions.selectStudyModeOffering(this._intakeApplication, offering));
    this.dialog.close();
  }
}
