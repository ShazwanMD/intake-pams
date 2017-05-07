import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {ApplicationModuleState} from "../../../index";
import {IntakeApplication} from "../../intake-application.interface";
import { MdDialogRef } from "@angular/material";
import { IntakeApplicationPersonal } from "../intake-application.interface";


@Component({
  selector: 'pams-working-experience-creator',
  templateUrl: './working-experience-creator.dialog.html',
})

export class WorkingExperienceCreatorDialog implements OnInit {

  private createForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<ApplicationModuleState>,
              private dialog: MdDialogRef<WorkingExperienceCreatorDialog>) {
  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group(<IntakeApplicationPersonal>{
      id: null,
      //referenceNo: '',
     // sourceNo: '',
     // intakeNo: '',
     // description: '',
     // projection: 0,
     // startDate: null,
     // endDate: null,
     // programLevel: <ProgramLevel>{},
      //intakeSession: <IntakeSession>{},
      //graduateCentre: <GraduateCentre>{}
    });
  }

  save(intake: Intake, isValid: boolean) {
    console.log("intake: " + intake.description);
    console.log("program level: " + intake.programLevel.code);
    console.log("session " + intake.intakeSession.code);
    console.log("graduate centre " + intake.graduateCentre.code);
    this.store.dispatch(this.actions.startIntakeTask(intake));
    this.dialog.close();
  }

  expandedEvent(): void {

  }

  collapsedEvent(): void {

  }

  next(application: IntakeApplication, isValid: boolean) {
  }
}
