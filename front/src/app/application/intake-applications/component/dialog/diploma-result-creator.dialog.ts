import { DiplomaResult } from './../../diploma-result-interface';
import {Component, ViewContainerRef, OnInit, Input} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {ApplicationModuleState} from "../../../index";
import {MdDialogRef} from "@angular/material";
import {IntakeApplicationActions} from "../../intake-application.action";
import {IntakeApplication} from "../../intake-application.interface";
import { ResultType } from "../../result-type.enum";



@Component({
  selector: 'pams-diploma-result-creator',
  templateUrl: './diploma-result-creator.dialog.html',
})

export class DiplomaResultCreatorDialog implements OnInit {

  private _intakeApplication: IntakeApplication;
  private createForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<ApplicationModuleState>,
              private actions: IntakeApplicationActions,
              private dialog: MdDialogRef<DiplomaResultCreatorDialog>) {
  }


  set intakeApplication(value: IntakeApplication) {
    this._intakeApplication = value;
  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group(<DiplomaResult>{
      id: null,
      year: 0,
      name: '',
      cgpa: 0,
      resultType: ResultType.DIPLOMA,

    });
  }

  save(diplomaResult: DiplomaResult, isValid: boolean) {
    this.store.dispatch(this.actions.addDiplomaResult(this._intakeApplication, diplomaResult));
    this.dialog.close();
  }
}
