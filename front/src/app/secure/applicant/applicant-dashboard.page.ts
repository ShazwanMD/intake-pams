import {Component, Output, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {AuthorizationService} from '../../../services/authorization.service';
import {ApplicationModuleState} from './application/index';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {IntakeApplicationActions} from './application/intake-applications/intake-application.action';
import {IntakeApplication} from '../../shared/model/application/intake-application.interface';

@Component({
  selector: 'pams-applicant-dashboard',
  templateUrl: './applicant-dashboard.page.html',
  styleUrls: ['./applicant-dashboard.page.scss'],
})

export class ApplicantDashboardPage implements OnInit {

  private SUBMITTED_INTAKE_APPLICATIONS: string[] = 'accountModuleState.submittedIntakeApplications'.split('.');
  private DRAFTED_INTAKE_APPLICATIONS: string[] = 'accountModuleState.draftedIntakeApplications'.split('.');
  private draftedIntakeApplications$: Observable<IntakeApplication>;
  private submittedIntakeApplications$: Observable<IntakeApplication>;

  constructor(private router: Router,
              private  route: ActivatedRoute,
              private authz: AuthorizationService,
              private store: Store<ApplicationModuleState>,
              private actions: IntakeApplicationActions) {
    this.draftedIntakeApplications$ = this.store.select(...this.DRAFTED_INTAKE_APPLICATIONS);
    this.submittedIntakeApplications$ = this.store.select(...this.SUBMITTED_INTAKE_APPLICATIONS);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findDraftedIntakeApplications());
    this.store.dispatch(this.actions.findSubmittedIntakeApplications());
  }
}
