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
  selector: 'pams-bachelor-result-creator',
  templateUrl: './bachelor-result-creator.dialog.html',
})

export class BachelorResultCreatorDialog implements OnInit {

  private _intakeApplication: IntakeApplication;
  private createForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<ApplicationModuleState>,
              private actions: IntakeApplicationActions,
              private dialog: MdDialogRef<BachelorResultCreatorDialog>) {
  }


  set intakeApplication(value: IntakeApplication) {
    this._intakeApplication = value;
  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group(<BachelorResult>{
      id: null,
      year: 0,
      name: '',
      cgpa: 0,
      resultType: ResultType.BACHELOR,

    });
  }

  save(bachelorResult: BachelorResult, isValid: boolean) {
    this.store.dispatch(this.actions.addBachelorResult(this._intakeApplication, bachelorResult));
    this.dialog.close();
  }
}
