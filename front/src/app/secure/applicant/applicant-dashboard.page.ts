import { Applicant } from './../../identity/applicant.interface';
import { Component, Output, OnInit, Input } from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {AuthorizationService} from '../../../services/authorization.service';
import {ApplicationModuleState} from './application/index';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {IntakeApplicationActions} from './application/intake-applications/intake-application.action';
import {IntakeApplication} from '../../shared/model/application/intake-application.interface';
import {AccountActions} from "./account/account.action";
import {Intake} from "../../shared/model/policy/intake.interface";

@Component({
  selector: 'pams-applicant-dashboard',
  templateUrl: './applicant-dashboard.page.html',
  styleUrls: ['./applicant-dashboard.page.scss'],
})

export class ApplicantDashboardPage implements OnInit {

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

  constructor(private router: Router,
              private  route: ActivatedRoute,
              private authz: AuthorizationService,
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
}
