import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import { FormBuilder, Validators } from '@angular/forms';
import {Store} from '@ngrx/store';
import {MdDialogRef, MdSnackBar} from '@angular/material';
import {IntakeActions} from '../intake.action';
import {PolicyModuleState} from '../../index';
import {GraduateCenter} from '../../../../shared/model/common/graduate-center.interface';
import {Intake} from '../../../../shared/model/policy/intake.interface';
import {IntakeSession} from '../../../../shared/model/policy/intake-session.interface';
import {ProgramLevel} from '../../../../shared/model/policy/program-level.interface';
import { DateValidation } from "../../../../shared/component/date-validation";

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
    this.updateForm = this.formBuilder.group({
      id:  [undefined],
      referenceNo: [''],
      sourceNo: [''],
      intakeNo:[''],
      descriptionEn: [''],
      descriptionMs: [''],
      projection: [0],
      // startDate: null,
      // endDate: null,
      startDate:  ['', Validators.required],
      endDate:  ['', Validators.required],
      programLevel: [<ProgramLevel>{}],
      intakeSession: [<IntakeSession>{}], 
      graduateCenter: [<GraduateCenter>{}],
    },{
      validator: DateValidation.CheckDate
    });
    this.updateForm.patchValue(this._intake);
  }

  submit(intake: Intake, isValid: boolean) {
    if (confirm('Confirm to submit?')) {
      this.store.dispatch(this.actions.updateIntake(intake));
      this.dialog.close();
    }else {
    }
  }
}
