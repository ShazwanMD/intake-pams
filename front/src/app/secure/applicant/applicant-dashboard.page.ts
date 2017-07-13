import { Applicant } from '../administrator/identity/applicant.interface';
import { Component, Output, OnInit, Input, ViewContainerRef } from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {AuthorizationService} from '../../../services/authorization.service';
import {ApplicationModuleState} from './application/index';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {IntakeApplicationActions} from './application/intake-applications/intake-application.action';
import {IntakeApplication} from '../../shared/model/application/intake-application.interface';
import {AccountActions} from "./account/account.action";
import {Intake} from "../../shared/model/policy/intake.interface";
import { ChangePasswordDialog } from "./account/dialog/change-password.dialog";
import { MdDialogConfig, MdDialogRef, MdDialog } from "@angular/material";


@Component({
  selector: 'pams-applicant-dashboard',
  templateUrl: './applicant-dashboard.page.html',
  styleUrls: ['./applicant-dashboard.page.scss'],
})

export class ApplicantDashboardPage implements OnInit {
  [x: string]: any;

  private PUBLISHED_INTAKES: string[] = 'accountModuleState.publishedIntakes'.split('.');
  private INTAKE_APPLICATIONS: string[] = 'accountModuleState.intakeApplications'.split('.');
  private APPLICANT: string[] = 'accountModuleState.applicant'.split('.');
  private intakeApplications$: Observable<IntakeApplication[]>;
  private publishedIntakes$: Observable<Intake[]>;
  private applicant$: Observable<Applicant>;


  private intakeColumns: any[] = [
    {name: 'referenceNo', label: 'ReferenceNo'},
    {name: 'startDate', label: 'Start Date'},
    {name: 'endDate', label: 'End Date'},
    {name: 'flowState', label: 'Status'},
    {name: 'action', label: ''},
  ];

   private editorDialogRef: MdDialogRef<ChangePasswordDialog>;

  constructor(private router: Router,
              private  route: ActivatedRoute,
              private authz: AuthorizationService,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private store: Store<ApplicationModuleState>,
              private actions: AccountActions) {
    this.publishedIntakes$ = this.store.select(...this.PUBLISHED_INTAKES);
    this.intakeApplications$ = this.store.select(...this.INTAKE_APPLICATIONS);
    this.applicant$ = this.store.select(...this.APPLICANT);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findIntakeApplications());
    this.store.dispatch(this.actions.findPublishedIntakes());
    this.store.dispatch(this.actions.findApplicant());
  }
  
showDialog(): void {
    console.log("showDialog");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.editorDialogRef= this.dialog.open(ChangePasswordDialog, config);
    this.editorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
      // load something here
    });
  }
}
