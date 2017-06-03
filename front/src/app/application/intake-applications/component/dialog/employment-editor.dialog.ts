import {Component, ViewContainerRef, OnInit, Input} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {ApplicationModuleState} from "../../../index";
import {MdDialogRef} from "@angular/material";
import {IntakeApplicationActions} from "../../intake-application.action";
import {IntakeApplication} from "../../intake-application.interface";
import {Employment} from "../../employment.interface";


@Component({
  selector: 'pams-employment-editor',
  templateUrl: './employment-editor.dialog.html',
})

export class EmploymentEditorDialog implements OnInit {

  private _intakeApplication: IntakeApplication;
  private _employment: Employment;
  private editForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<ApplicationModuleState>,
              private actions: IntakeApplicationActions,
              private dialog: MdDialogRef<EmploymentEditorDialog>) {
  }


  set intakeApplication(value: IntakeApplication) {
    this._intakeApplication = value;
  }

  set employment(value: Employment) {
  this._employment = value;
  }

  ngOnInit(): void {
    this.editForm = this.formBuilder.group(<Employment>{
      id: null,
      startDate: null,
      endDate: null,
      employer: '',
      designation: '',
      current: false
    });
  }

  save(employment: Employment, isValid: boolean) {
      if (!employment.id) this.store.dispatch(this.actions.addEmployment(this._intakeApplication, employment));
      else  this.store.dispatch(this.actions.updateEmployment(this._intakeApplication, employment));
      this.dialog.close();
  }
}
