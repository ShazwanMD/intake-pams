import {Result} from '../../../../../shared/model/application/result.interface';
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
  selector: 'pams-spm-result-editor',
  templateUrl: './spm-result-editor.dialog.html',
})

export class SpmResultEditorDialog implements OnInit {

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
              private dialog: MdDialogRef<SpmResultEditorDialog>) {
  }

  set result(value: Result) {
    console.log('setting result');
    this._result = value;
    console.log(value);
    this.edit = true;
  }

  set intakeApplication(value: IntakeApplication) {
    console.log('setting application');
    this._intakeApplication = value;
  }

  ngOnInit(): void {
    this.editForm = this.formBuilder.group(<Result>{
      id: undefined,
      name: '',
      graduationYear: 0,
      resultAlphanumeric: '',
      malayResult: '',
      englishResult: '',
      resultType: ResultType.SPM,

    });
    if (this.edit) this.editForm.patchValue(this._result);
  }

  submit(result: Result, isValid: boolean): void {
    if (this.edit) this.store.dispatch(this.actions.updateResult(this._intakeApplication, result));
    else  this.store.dispatch(this.actions.addResult(this._intakeApplication, result));
    this.dialog.close();
  }
}
