import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";
import {IntakeActions} from "../intake.action";
import {PolicyModuleState} from "../../index";
import {Intake} from "../intake.interface";
import {GraduateCentre} from "../../../common/graduate-centres/graduate-centre.interface";
import {ProgramLevel} from "../../program-levels/program-level.interface";


@Component({
  selector: 'pams-intake-task-creator',
  templateUrl: './intake-task-creator.dialog.html',
  styleUrls: ['./intake-task-creator.dialog.scss'],
})

export class IntakeTaskCreatorDialog implements OnInit {

  private createForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<PolicyModuleState>,
              private actions: IntakeActions,
              private dialog: MdDialogRef<IntakeTaskCreatorDialog>) {
  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group(<Intake>{
      id: null,
      referenceNo: '',
      sourceNo: '',
      intakeNo: '',
      description: '',
      projection: 0,
      startDate: null,
      endDate: null,
      programLevel: <ProgramLevel>{},
      graduateCentre: <GraduateCentre>{}
    });
  }

  save(intake: Intake, isValid: boolean) {
    console.log("intake: " + intake.description);
    console.log("program level: " + intake.programLevel.code);
    console.log("graduate centre " + intake.graduateCentre.code);
    this.store.dispatch(this.actions.startIntakeTask(intake));
    this.dialog.close();
  }
}
