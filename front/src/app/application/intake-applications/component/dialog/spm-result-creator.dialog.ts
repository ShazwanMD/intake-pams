import { BachelorResult } from './../../bachelor-result-interface';
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
import { SpmResult } from "../../spm-result.interface";



@Component({
  selector: 'pams-spm-result-creator',
  templateUrl: './spm-result-creator.dialog.html',
})

export class SpmResultCreatorDialog implements OnInit {

  private _intakeApplication: IntakeApplication;
  private createForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<ApplicationModuleState>,
              private actions: IntakeApplicationActions,
              private dialog: MdDialogRef<SpmResultCreatorDialog>) {
  }


  set intakeApplication(value: IntakeApplication) {
    this._intakeApplication = value;
  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group(<SpmResult>{
      id: null,
      year: 0,
      name: '',
      grade: '',
      aggregate:0,
      // resultType: ResultType.BACHELOR,

    });
  }

  save(spmResult: SpmResult, isValid: boolean) {
    this.store.dispatch(this.actions.addSpmResult(this._intakeApplication, spmResult));
    this.dialog.close();
  }
}
