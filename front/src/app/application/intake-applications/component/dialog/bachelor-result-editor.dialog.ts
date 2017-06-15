import { Result } from './../../result.interface';
import {BachelorResult} from '../../bachelor-result-interface';
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
  selector: 'pams-bachelor-result-editor',
  templateUrl: './bachelor-result-editor.dialog.html',
})

export class BachelorResultEditorDialog implements OnInit {

  private _intakeApplication: IntakeApplication;
  private editForm: FormGroup;
  private edit: boolean = false;
  private _bachelorResult: Result;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<ApplicationModuleState>,
              private actions: IntakeApplicationActions,
              private dialog: MdDialogRef<BachelorResultEditorDialog>) {
  }


  set bachelorResult(value: Result) {
    this._bachelorResult = value;
    this.edit = true;
  }

  set intakeApplication(value: IntakeApplication) {
    this._intakeApplication = value;
  }

  ngOnInit(): void {
    this.editForm = this.formBuilder.group(<Result>{
      id: null,
      name: '',
      field: '',
      graduationYear: '',
      resultNumeric: 0,
      resultType: ResultType.BACHELOR,

    });
    if (this.edit) this.editForm.patchValue(this._bachelorResult);
  }

  submit(bachelorResult: Result, isValid: boolean) {
    if (this.edit) this.store.dispatch(this.actions.updateResult(this._intakeApplication, bachelorResult));
    else  this.store.dispatch(this.actions.addResult(this._intakeApplication, bachelorResult));
    this.dialog.close();
  }
}
