import { Result } from '../../../../../shared/model/application/result.interface';
import {Component, ViewContainerRef, OnInit, Input} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import {ApplicationModuleState} from '../../../index';
import {MdDialogRef} from '@angular/material';
import {IntakeApplicationActions} from '../../intake-application.action';
import {IntakeApplication} from '../../../../../shared/model/application/intake-application.interface';
import {ResultType} from '../../../../../shared/model/application/result-type.enum';

@Component({
  selector: 'pams-bachelor-result-editor',
  templateUrl: './bachelor-result-editor.dialog.html',
})

export class BachelorResultEditorDialog implements OnInit {

  private _intakeApplication: IntakeApplication;
  private editForm: FormGroup;
  private edit: boolean = false;
  private _result: Result;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<ApplicationModuleState>,
              private actions: IntakeApplicationActions,
              private dialog: MdDialogRef<BachelorResultEditorDialog>) {
  }

  set result(value: Result) {
    this._result = value;
    this.edit = true;
  }

  set intakeApplication(value: IntakeApplication) {
    this._intakeApplication = value;
  }

  ngOnInit(): void {
    this.editForm = this.formBuilder.group({
      id: undefined,
      name: '',
      field: '',
      graduationYear: 0,
      resultNumeric: 0,
      resultType: ResultType.BACHELOR,

    });
    if (this.edit) this.editForm.patchValue(this._result);
  }

  submit(result: Result, isValid: boolean) {
    if (this.edit) this.store.dispatch(this.actions.updateResult(this._intakeApplication, result));
    else  this.store.dispatch(this.actions.addResult(this._intakeApplication, result));
    this.dialog.close();
  }
}
