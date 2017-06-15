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
  selector: 'pams-stpm-result-editor',
  templateUrl: './stpm-result-editor.dialog.html',
})

export class StpmResultEditorDialog implements OnInit {

  private _intakeApplication: IntakeApplication;
  private editForm: FormGroup;
  private edit: boolean = false;
  private _stpmResult: Result;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<ApplicationModuleState>,
              private actions: IntakeApplicationActions,
              private dialog: MdDialogRef<StpmResultEditorDialog>) {
  }


  set stpmResult(value: Result) {
    this._stpmResult = value;
    this.edit = true;
  }

  set intakeApplication(value: IntakeApplication) {
    this._intakeApplication = value;
  }

  ngOnInit(): void {
    this.editForm = this.formBuilder.group(<Result>{
      id: null,
      name: '',
      graduationYear: 0,
      resultAlphanumeric: '',
      resultType: ResultType.STPM,

    });
    if (this.edit) this.editForm.patchValue(this._stpmResult);
  }

  submit(stpmResult: Result, isValid: boolean) {
    if (this.edit) this.store.dispatch(this.actions.updateResult(this._intakeApplication, stpmResult));
    else  this.store.dispatch(this.actions.addResult(this._intakeApplication, stpmResult));
    this.dialog.close();
  }
}
