import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Store} from "@ngrx/store";
import {MdDialogRef, MdSnackBar} from "@angular/material";
import {IntakeActions} from "../intake.action";
import {PolicyModuleState} from "../../index";
import {Intake} from "../intake.interface";
import {IntakeSession} from "../../intake-sessions/intake-session.interface";
import {GraduateCenter} from "../../../common/graduate-centers/graduate-center.interface";
import {ProgramLevel} from "../../program-levels/program-level.interface";
import {IntakeTask} from "../intake-task.interface";


@Component({
  selector: 'pams-intake-updater',
  templateUrl: './intake-updater.dialog.html',
})

export class IntakeUpdaterDialog implements OnInit {

  private updateForm: FormGroup;
  private _intake: Intake;

  constructor(private formBuilder: FormBuilder,
              private store: Store<PolicyModuleState>,
              private actions: IntakeActions,
              private dialog: MdDialogRef<IntakeUpdaterDialog>,
              private snackBar: MdSnackBar) {
  }

  set intake(intake: Intake) {
    this._intake = intake;
  }

  ngOnInit(): void {
    this.updateForm = this.formBuilder.group(<Intake>{
      id: null,
      referenceNo: '',
      sourceNo: '',
      intakeNo: '',
      description: '',
      projection: 0,
      startDate: null,
      endDate: null,
      programLevel: <ProgramLevel>{},
      intakeSession: <IntakeSession>{},
      graduateCenter: <GraduateCenter>{}
    });
    this.updateForm.patchValue(this._intake);
  }

  submit(intake: Intake, isValid: boolean) {
    let snackBarRef = this.snackBar.open("Confirm to submit?", "Ok");
    snackBarRef.afterDismissed().subscribe(() => {
      this.store.dispatch(this.actions.updateIntake(intake));
      this.dialog.close();
    });
  }
}
