import { Attachment } from './../../../shared/model/application/attachment.interface';
import { Result } from './../../../shared/model/application/result.interface';
import { Candidate } from '../../../shared/model/admission/candidate.interface';
import { Employment } from '../../../shared/model/application/employment.interface';
import { IntakeApplication } from '../../../shared/model/application/intake-application.interface';
import { Language } from '../../../shared/model/application/language.interface';
import { Referee } from '../../../shared/model/application/referee.interface';
import { ApplicationModuleState } from '../../application';
import { IntakeApplicationActions } from '../../application/intake-applications/intake-application.action';
import { IntakeActions } from '../../policy/intakes/intake.action';
import { AdmissionActions } from '../admission.action';
import { CandidateProfileRejectDialog } from './candidate-profile-reject.dialog';
import {Component, OnInit, ChangeDetectionStrategy, state, ViewContainerRef, Input} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs/Observable';
import {MdSnackBar, MdDialogRef, MdDialogConfig, MdDialog} from '@angular/material';

@Component({
  selector: 'pams-candidate-profile-register',
  templateUrl: './candidate-profile-register.dialog.html',
})

export class CandidateProfileRegisterDialog implements OnInit {


  private INTAKE_APPLICATION: string[] = 'applicationModuleState.intakeApplication'.split('.');
  private EMPLOYMENTS: string[] = 'applicationModuleState.employments'.split('.');
  private LANGUAGES: string[] = 'applicationModuleState.languages'.split('.');
  private REFEREES: string[] = 'applicationModuleState.referees'.split('.');
  private ATTACHMENTS: string[] = 'applicationModuleState.attachments'.split('.');
  private RESULTS: string[] = 'applicationModuleState.results'.split('.');

  private intakeApplication$: Observable<IntakeApplication>;
  private employments$: Observable<Employment>;
  private languages$: Observable<Language>;
  private referees$: Observable<Referee>;
  private attachments$: Observable<Attachment>;
  private results$: Observable<Result>;  
  private applicationForm: FormGroup;

  @Input() candidate: Candidate;
  @Input() intakeApplication: IntakeApplication;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private vcf: ViewContainerRef,
              private actions: IntakeApplicationActions,
              private admissionActions: AdmissionActions,
              private dialog: MdDialog,
              private editorDialog: MdDialogRef<CandidateProfileRegisterDialog>,
              private editorDialogRef: MdDialogRef<CandidateProfileRejectDialog>,
              private snackBar: MdSnackBar,
              private store: Store<ApplicationModuleState>) {

    this.intakeApplication$ = this.store.select(...this.INTAKE_APPLICATION);
    this.employments$ = this.store.select(...this.EMPLOYMENTS);
    this.languages$ = this.store.select(...this.LANGUAGES);
    this.referees$ = this.store.select(...this.REFEREES);
    this.results$ = this.store.select(...this.RESULTS);
    this.attachments$ = this.store.select(...this.ATTACHMENTS);

  }

  ngOnInit(): void {
    let referenceNo: string = this.candidate.application.referenceNo;
    this.store.dispatch(this.actions.findIntakeApplicationByReferenceNo(referenceNo));
  }

  register(candidate: Candidate) {
    if(confirm('Confirm to Register This Candidate?')){
     this.store.dispatch(this.admissionActions.registerCandidate(candidate));
      this.editorDialog.afterClosed().subscribe((res) => {
      this.route.params.subscribe((params: { taskId: string }) => {
      let taskId: string = params.taskId;
      console.log('intake: ' + taskId);
      this.store.dispatch(this.admissionActions.findIntakeTaskByTaskId(taskId));
    });
      });
      this.editorDialog.close();
      window.location.reload();
    }else {
    }
  }
  reject(candidate: Candidate) {
     this.showDialog(candidate);
  }
  
  showDialog(candidate): void {
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '40%';
    config.position = {top: '0px'};
    this.editorDialogRef = this.dialog.open(CandidateProfileRejectDialog, config);
    this.editorDialogRef.componentInstance.candidate= candidate;
    this.editorDialog.afterClosed().subscribe((res) => {
     this.route.params.subscribe((params: { taskId: string }) => {
      let taskId: string = params.taskId;
      console.log('intake: ' + taskId);
      this.store.dispatch(this.admissionActions.findIntakeTaskByTaskId(taskId));
    });
    });
  }

}
