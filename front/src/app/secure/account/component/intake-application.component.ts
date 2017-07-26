import { IntakeApplication } from './../../../shared/model/application/intake-application.interface';
import { Component, Output, OnInit, Input, ViewContainerRef, ChangeDetectionStrategy } from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {MdDialogConfig, MdDialogRef, MdDialog} from '@angular/material';
import { Intake } from "../../../shared/model/policy/intake.interface";
import { Applicant } from "../../identity/applicant.interface";
import { ApplicationModuleState } from "../../application/index";
import { AccountActions } from "../account.action";



@Component({
  selector: 'pams-intake-application',
  templateUrl: './intake-application.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class IntakeApplicationComponent {

 @Input() intakeApplication: IntakeApplication;

  private PUBLISHED_INTAKES: string[] = 'accountModuleState.publishedIntakes'.split('.');
  private INTAKE_APPLICATIONS: string[] = 'accountModuleState.intakeApplications'.split('.');
  // private APPLICANT: string[] = 'accountModuleState.applicant'.split('.');
  private intakeApplications$: Observable<IntakeApplication[]>;
  private publishedIntakes$: Observable<Intake[]>;
 
  constructor(private router: Router,
              private route: ActivatedRoute,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private store: Store<ApplicationModuleState>,
              private actions: AccountActions) {
    this.publishedIntakes$ = this.store.select(...this.PUBLISHED_INTAKES);
    this.intakeApplications$ = this.store.select(...this.INTAKE_APPLICATIONS);
  

  }

  ngOnInit(): void {
    // this.store.dispatch(this.actions.findApplicant());
    // this.store.dispatch(this.actions.findUser());
    this.store.dispatch(this.actions.findIntakeApplications());
    this.store.dispatch(this.actions.findPublishedIntakes());
  }

 
}
