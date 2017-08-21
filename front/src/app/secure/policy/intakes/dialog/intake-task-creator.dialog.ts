import { Checkpassword } from './../../../account/component/check-password';
import { Component, ViewContainerRef, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { FormBuilder, Validators } from '@angular/forms';
import { Store } from '@ngrx/store';
import { MdDialogRef, MdSnackBar } from '@angular/material';
import { IntakeActions } from '../intake.action';
import { PolicyModuleState } from '../../index';
import { GraduateCenter } from '../../../../shared/model/common/graduate-center.interface';
import { IntakeTask } from '../../../../shared/model/policy/intake-task.interface';
import { Intake } from '../../../../shared/model/policy/intake.interface';
import { ProgramLevel } from '../../../../shared/model/policy/program-level.interface';
import { IntakeSession } from '../../../../shared/model/policy/intake-session.interface';
import { DateValidation } from "../../../../shared/component/date-validation";
import { Router } from "@angular/router";

@Component({
  selector: 'pams-intake-task-creator',
  templateUrl: './intake-task-creator.dialog.html',
})

export class IntakeTaskCreatorDialog implements OnInit {
  [x: string]: any;

  private createForm: FormGroup;
  private edit: boolean = false;
  private _intakeTask: IntakeTask;


  constructor(private router: Router,
    private formBuilder: FormBuilder,
    private viewContainerRef: ViewContainerRef,
    private store: Store<PolicyModuleState>,
    private actions: IntakeActions,
    private dialog: MdDialogRef<IntakeTaskCreatorDialog>,
    private snackBar: MdSnackBar) {
  }

  ngOnInit(): void {

    // this.createForm = this.formBuilder.group(<Intake>{
      this.createForm = this.formBuilder.group({
      id:  [undefined],
      referenceNo: [''],
      sourceNo: [''],
      intakeNo:[''],
      description: [''],
      projection: [0],
      // startDate: null,
      // endDate: null,
      startDate:  ['', Validators.required],
      endDate:  ['', Validators.required],
      programLevel: [<ProgramLevel>{}],
      intakeSession: [<IntakeSession>{}], 
      graduateCenter: [<GraduateCenter>{}],
    },{
       validator: DateValidation.CheckDate // your validation method
    }) 
  }

  submit(intake: Intake, isValid: boolean) {
    if (confirm('Create intake?')) {
      this.store.dispatch(this.actions.startIntakeTask(intake));
      this.dialog.close();
    }else {
}  
}

goBack(): void {
  this.router.navigate(['/secure/policy/intakes']);
}

}