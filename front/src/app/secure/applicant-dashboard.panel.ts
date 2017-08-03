import { IntakeApplication } from './../shared/model/application/intake-application.interface';
import { AddressChangerDialog } from './account/dialog/address-changer.dialog';
import { User } from './identity/user.interface';
import { Component, Output, OnInit, Input, ViewContainerRef } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Store } from '@ngrx/store';
import { MdDialogConfig, MdDialogRef, MdDialog } from '@angular/material';
import { Intake } from '../shared/model/policy/intake.interface';
import { Applicant } from './identity/applicant.interface';
import { ApplicationModuleState } from './application/index';
import { AccountActions } from './account/account.action';
import { ResultCandidateDialog } from "./account/dialog/result-candidate.dialog";
import { Candidate } from "../shared/model/admission/candidate.interface";

@Component({
  selector: 'pams-applicant-dashboard-panel',
  templateUrl: './applicant-dashboard.panel.html',
  styleUrls: ['./applicant-dashboard.panel.scss'],
})

export class ApplicantDashboardPanel implements OnInit {



  [x: string]: any;
  private editorDialogRef: MdDialogRef<AddressChangerDialog>;
  private resultDialogRef: MdDialogRef<ResultCandidateDialog>;

  private PUBLISHED_INTAKES: string[] = 'accountModuleState.publishedIntakes'.split('.');
  private INTAKE_APPLICATIONS: string[] = 'accountModuleState.intakeApplications'.split('.');
  private MY_INTAKE_APPLICATIONS: string[] = 'accountModuleState.myIntakeApplications'.split('.');
  private APPLICANT: string[] = 'accountModuleState.applicant'.split('.');
  private USER: string[] = 'accountModuleState.user'.split('.');
  private intakeApplications$: Observable<IntakeApplication[]>;
  private myIntakeApplications$: Observable<IntakeApplication[]>;
  private publishedIntakes$: Observable<Intake[]>;
  private applicant$: Observable<Applicant>;
  private user$: Observable<User>;

  constructor(private router: Router,
    private route: ActivatedRoute,
    private vcf: ViewContainerRef,
    private dialog: MdDialog,
    private store: Store<ApplicationModuleState>,
    private actions: AccountActions) {
    this.intakeApplications$ = this.store.select(...this.INTAKE_APPLICATIONS);
    this.myIntakeApplications$ = this.store.select(...this.MY_INTAKE_APPLICATIONS);   
    this.publishedIntakes$ = this.store.select(...this.PUBLISHED_INTAKES);
    this.intakeApplications$ = this.store.select(...this.INTAKE_APPLICATIONS);
    this.applicant$ = this.store.select(...this.APPLICANT);
    this.user$ = this.store.select(...this.USER);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findApplicant());
    this.store.dispatch(this.actions.findUser());
    this.store.dispatch(this.actions.findIntakeApplications());
    this.store.dispatch(this.actions.findPublishedIntakes());
    this.store.dispatch(this.actions.findMyIntakeApplications());
  }

  resultDialog(candidate): void {
    console.log('resultDialog');
    let config: MdDialogConfig = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = { top: '0px' };
    this.resultDialogRef = this.dialog.open(ResultCandidateDialog, config);
   // this.editorDialogRef.componentInstance.candidate = candidate;
    // this.editorDialogRef.componentInstance.intakeApplication = this.intakeApplication;
    this.resultDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
      // load something here
    });
  }

  editDialog(intakeApplication: IntakeApplication): void {
    this.showDialog(intakeApplication);
  }

  private showDialog(intakeApplication: IntakeApplication): void {
    console.log('editDialog');
    let config: MdDialogConfig = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = { top: '0px' };
    this.editorDialogRef = this.dialog.open(AddressChangerDialog, config);
    this.editorDialogRef.componentInstance.intakeApplication = intakeApplication;
    this.editorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
      this.store.dispatch(this.actions.findIntakeApplications());

      // load something here
    });

  }
}