import {Result} from './../../result.interface';
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
  selector: 'pams-diploma-result-editor',
  templateUrl: './diploma-result-editor.dialog.html',
})

export class DiplomaResultEditorDialog implements OnInit {

  private _intakeApplication: IntakeApplication;
  private editForm: FormGroup;
  private edit: boolean = false;
  private _diplomaResult: Result;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<ApplicationModuleState>,
              private actions: IntakeApplicationActions,
              private dialog: MdDialogRef<DiplomaResultEditorDialog>) {
  }


  set diplomaResult(value: Result) {
    this._diplomaResult = value;
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
      resultType: ResultType.DIPLOMA,

    });
    if (this.edit) this.editForm.patchValue(this._diplomaResult);
  }

  submit(diplomaResult: Result, isValid: boolean) {
    if (this.edit) this.store.dispatch(this.actions.updateResult(this._intakeApplication, diplomaResult));
    else  this.store.dispatch(this.actions.addResult(this._intakeApplication, diplomaResult));
    this.dialog.close();
  }
}
