import { Result } from './../../result.interface';
import {Component, ViewContainerRef, OnInit, Input} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {ApplicationModuleState} from "../../../index";
import {MdDialogRef} from "@angular/material";
import {IntakeApplicationActions} from "../../intake-application.action";
import {IntakeApplication} from "../../intake-application.interface";
import {ResultType} from "../../result-type.enum";


@Component({
  selector: 'pams-spm-result-editor',
  templateUrl: './spm-result-editor.dialog.html',
})

export class SpmResultEditorDialog implements OnInit {

  private _intakeApplication: IntakeApplication;
  private editForm: FormGroup;
  private edit: boolean = false;
  private _spmResult: Result;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<ApplicationModuleState>,
              private actions: IntakeApplicationActions,
              private dialog: MdDialogRef<SpmResultEditorDialog>) {
  }


  set spmResult(value: Result) {
    this._spmResult = value;
    this.edit = true;
  }

  set intakeApplication(value: IntakeApplication) {
    this._intakeApplication = value;
  }

  ngOnInit(): void {
    this.editForm = this.formBuilder.group(<Result>{
      id: null,
      name: '',
      graduationYear: '',
      resultAlphanumeric: '',
      resultType: ResultType.SPM,

    });
    if (this.edit) this.editForm.patchValue(this._spmResult);
  }

  submit(spmResult: Result, isValid: boolean) {
    if (this.edit) this.store.dispatch(this.actions.updateResult(this._intakeApplication, spmResult));
    else  this.store.dispatch(this.actions.addResult(this._intakeApplication, spmResult));
    this.dialog.close();
  }
}
