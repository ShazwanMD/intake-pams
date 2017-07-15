import {Component, Output, OnInit, Input, ViewContainerRef} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {MdDialogConfig, MdDialogRef, MdDialog} from '@angular/material';
import {IntakeApplication} from '../shared/model/application/intake-application.interface';
import {Intake} from '../shared/model/policy/intake.interface';
import {Applicant} from './administrator/identity/applicant.interface';
import {ChangePasswordDialog} from './account/dialog/change-password.dialog';
import {ApplicationModuleState} from './application/index';
import {AccountActions} from './account/account.action';

@Component({
  selector: 'pams-applicant-dashboard-panel',
  templateUrl: './applicant-dashboard.panel.html',
  styleUrls: ['./applicant-dashboard.panel.scss'],
})

export class ApplicantDashboardPanel implements OnInit {
  [x: string]: any;

  private PUBLISHED_INTAKES: string[] = 'accountModuleState.publishedIntakes'.split('.');
  private INTAKE_APPLICATIONS: string[] = 'accountModuleState.intakeApplications'.split('.');
  private APPLICANT: string[] = 'accountModuleState.applicant'.split('.');
  private intakeApplications$: Observable<IntakeApplication[]>;
  private publishedIntakes$: Observable<Intake[]>;
  private applicant$: Observable<Applicant>;

  private editorDialogRef: MdDialogRef<ChangePasswordDialog>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private store: Store<ApplicationModuleState>,
              private actions: AccountActions) {
    this.publishedIntakes$ = this.store.select(...this.PUBLISHED_INTAKES);
    this.intakeApplications$ = this.store.select(...this.INTAKE_APPLICATIONS);
    this.applicant$ = this.store.select(...this.APPLICANT);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findApplicant());
    this.store.dispatch(this.actions.findIntakeApplications());
    this.store.dispatch(this.actions.findPublishedIntakes());
  }

  showDialog(): void {
    console.log('showDialog');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.editorDialogRef = this.dialog.open(ChangePasswordDialog, config);
    this.editorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
      // load something here
    });
  }
}
