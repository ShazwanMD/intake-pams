import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Store} from '@ngrx/store';
import {MdDialogRef, MdSnackBar} from '@angular/material';
import {IntakeActions} from '../intake.action';
import {PolicyModuleState} from '../../index';
import {GraduateCenter} from '../../../../../shared/model/common/graduate-center.interface';
import {IntakeTask} from '../../../../../shared/model/policy/intake-task.interface';
import {Intake} from '../../../../../shared/model/policy/intake.interface';
import {ProgramLevel} from '../../../../../shared/model/policy/program-level.interface';
import {IntakeSession} from '../../../../../shared/model/policy/intake-session.interface';

@Component({
  selector: 'pams-intake-task-creator',
  templateUrl: './intake-task-creator.dialog.html',
})

export class IntakeTaskCreatorDialog implements OnInit {

  private createForm: FormGroup;
  private edit: boolean = false;
  private _intakeTask: IntakeTask;

  constructor(private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<PolicyModuleState>,
              private actions: IntakeActions,
              private dialog: MdDialogRef<IntakeTaskCreatorDialog>,
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
      graduateCenter: <GraduateCenter>{},
    });
  }

  submit(intake: Intake, isValid: boolean) {
    let snackBarRef = this.snackBar.open('Confirm to create intake?', 'Ok');
    snackBarRef.afterDismissed().subscribe(() => {
      this.store.dispatch(this.actions.startIntakeTask(intake));
      this.dialog.close();
    });
  }
}
