import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Store} from "@ngrx/store";
import { MdDialogRef, MdSnackBar } from "@angular/material";
import {IntakeActions} from "../intake.action";
import {PolicyModuleState} from "../../index";
import {Intake} from "../intake.interface";
import {IntakeSession} from "../../intake-sessions/intake-session.interface";
import {GraduateCentre} from "../../../common/graduate-centres/graduate-centre.interface";
import {ProgramLevel} from "../../program-levels/program-level.interface";
import { IntakeTask } from "../intake-task.interface";


@Component({
  selector: 'pams-intake-updater',
  templateUrl: './intake-updater.dialog.html',
})

export class IntakeUpdaterDialog implements OnInit {

  private createForm: FormGroup;
    private edit: boolean = false;
    private _intakeTask: IntakeTask;

  constructor(private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<PolicyModuleState>,
              private actions: IntakeActions,
              private dialog: MdDialogRef<IntakeUpdaterDialog>,
              private snackBar: MdSnackBar) {
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
      intakeSession: <IntakeSession>{},
      graduateCentre: <GraduateCentre>{}
    });
    
    if (this.edit) this.createForm.patchValue(this._intakeTask);
  }
  
  set intakeTask(intakeTask : IntakeTask) {
      this._intakeTask = intakeTask;
      this.edit = true;
    }
    
    submit(intake: Intake, isValid: boolean) {
        let snackBarRef = this.snackBar.open("Confirm to submit?", "Ok");
        snackBarRef.afterDismissed().subscribe(() => {
        if (!intake.id) this.store.dispatch(this.actions.startIntakeTask(intake));
        else  this.store.dispatch(this.actions.updateIntake(intake));
        this.dialog.close();
        });
      }
  }
