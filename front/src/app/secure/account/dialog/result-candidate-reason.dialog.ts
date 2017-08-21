import { User } from './../../identity/user.interface';
import { Applicant } from './../../identity/applicant.interface';
import { Intake } from './../../../shared/model/policy/intake.interface';
import { AccountActions } from './../account.action';
import { AccountModuleState } from './../index';
import { MyIntakeApplication } from './../../../shared/model/application/my-intake-application.interface';
import { AdmissionActions } from './../../admission/admission.action';
import { Candidate } from '../../../shared/model/admission/candidate.interface';
import { Employment } from '../../../shared/model/application/employment.interface';
import { IntakeApplication } from '../../../shared/model/application/intake-application.interface';
import { Language } from '../../../shared/model/application/language.interface';
import { Referee } from '../../../shared/model/application/referee.interface';
import { ApplicationModuleState } from '../../application';
import { IntakeApplicationActions } from '../../application/intake-applications/intake-application.action';
import { IntakeActions } from '../../policy/intakes/intake.action';
import { Component, OnInit, ChangeDetectionStrategy, state, ViewContainerRef, Input } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs/Observable';
import { MdSnackBar, MdDialogRef, MdDialogConfig, MdDialog } from '@angular/material';

@Component({
  selector: 'pams-result-candidate-reason',
  templateUrl: './result-candidate-reason.dialog.html',
})

export class ResultCandidateReasonDialog implements OnInit {

  private _myIntakeApplications: MyIntakeApplication;
  private applicationForm: FormGroup;

  private PUBLISHED_INTAKES: string[] = 'accountModuleState.publishedIntakes'.split('.');
  private INTAKE_APPLICATIONS: string[] = 'accountModuleState.intakeApplications'.split('.');
  private MY_INTAKE_APPLICATIONS: string[] = 'accountModuleState.myIntakeApplications'.split('.');
  private APPLICANT: string[] = 'accountModuleState.applicant'.split('.');
  private USER: string[] = 'accountModuleState.user'.split('.');
  private intakeApplications$: Observable<IntakeApplication[]>;
  private myIntakeApplications$: Observable<MyIntakeApplication[]>;
  private publishedIntakes$: Observable<Intake[]>;
  private applicant$: Observable<Applicant>;
  private user$: Observable<User>;

  constructor(private router: Router,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private vcf: ViewContainerRef,
    private admissionActions: AdmissionActions,
    private dialog: MdDialog,
    private editorDialog: MdDialogRef<ResultCandidateReasonDialog>,
    private snackBar: MdSnackBar,
    private store: Store<AccountModuleState>,
    private actions: AccountActions) {
    this.myIntakeApplications$ = this.store.select(...this.MY_INTAKE_APPLICATIONS);
    this.intakeApplications$ = this.store.select(...this.INTAKE_APPLICATIONS);
    this.publishedIntakes$ = this.store.select(...this.PUBLISHED_INTAKES);
    this.applicant$ = this.store.select(...this.APPLICANT);
    this.user$ = this.store.select(...this.USER);
  }
  set myIntakeApplications(value: MyIntakeApplication) {
    this._myIntakeApplications = value;
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findMyIntakeApplications());
    this.store.dispatch(this.actions.findApplicant());
    this.store.dispatch(this.actions.findUser());
    this.store.dispatch(this.actions.findIntakeApplications());
    this.store.dispatch(this.actions.findPublishedIntakes());
  }

}
