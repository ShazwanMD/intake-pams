import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";

import {PolicyModuleState} from "../../index";

import {GraduateCentre} from "../../../common/graduate-centres/graduate-centre.interface";
import {ProgramLevel} from "../../program-levels/program-level.interface";
import {IntakeSession} from "../../intake-sessions/intake-session.interface";


@Component({
  selector: 'pams-intake-session-task-creator',
  templateUrl: './intake-session-task-creator.dialog.html',
  //styleUrls: ['./intake-sess-task-creator.dialog.scss'],
})

export class IntakeSessionTaskCreatorDialog implements OnInit {

  private createForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<PolicyModuleState>,
              
              private dialog: MdDialogRef<IntakeSessionTaskCreatorDialog>) {
  }

   ngOnInit(): void {
  //   this.createForm = this.formBuilder.group(<IntakeSession>{
  //     id: null,
  //     referenceNo: '',
  //     sourceNo: '',
  //     intakeNo: '',
  //     description: '',
  //     projection: 0,
  //     startDate: null,
  //     endDate: null,
  //     programLevel: <ProgramLevel>{},
  //     graduateCentre: <GraduateCentre>{},
  //     intakeSession: <IntakeSession>{}
   // });
   }

  // save(intake: Intake, isValid: boolean) {
  //   console.log("intake: " + intake.description);
  //   console.log("program level: " + intake.programLevel.code);
  //   console.log("graduate centre " + intake.graduateCentre.code);
  //   this.store.dispatch(this.actions.startIntakeTask(intake));
  //   this.dialog.close();
  // }
}
