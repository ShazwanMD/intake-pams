import { AdmissionActions } from './../../admission/admission.action';
import { Candidate } from '../../../shared/model/admission/candidate.interface';
import { Employment } from '../../../shared/model/application/employment.interface';
import { IntakeApplication } from '../../../shared/model/application/intake-application.interface';
import { Language } from '../../../shared/model/application/language.interface';
import { Referee } from '../../../shared/model/application/referee.interface';
import { ApplicationModuleState } from '../../application';
import { IntakeApplicationActions } from '../../application/intake-applications/intake-application.action';
import { IntakeActions } from '../../policy/intakes/intake.action';
import {Component, OnInit, ChangeDetectionStrategy, state, ViewContainerRef, Input} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs/Observable';
import {MdSnackBar, MdDialogRef, MdDialogConfig, MdDialog} from '@angular/material';

@Component({
  selector: 'pams-result-candidate',
  templateUrl: './result-candidate.dialog.html',
})

export class ResultCandidateDialog implements OnInit {

  private INTAKE_APPLICATION: string[] = 'applicationModuleState.intakeApplication'.split('.');
  private CANDIDATES: string[] = 'admissionModuleState.candidates'.split('.');


  private intakeApplication$: Observable<IntakeApplication>;
  private candidates$: Observable<Candidate[]>;
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
              private editorDialog: MdDialogRef< ResultCandidateDialog>,
          //    private editorDialogRef: MdDialogRef<CandidateProfileRejectDialog>,
              private snackBar: MdSnackBar,
              private store: Store<ApplicationModuleState>) {

    this.intakeApplication$ = this.store.select(...this.INTAKE_APPLICATION);
    this.candidates$ = this.store.select(...this.CANDIDATES);

  }

  ngOnInit(): void {
    // let referenceNo: string = this.candidate.application.referenceNo;
    // this.store.dispatch(this.actions.findIntakeApplicationByReferenceNo(referenceNo));
  }



  
  // showDialog(candidate): void {
  //   let config = new MdDialogConfig();
  //   config.viewContainerRef = this.vcf;
  //   config.role = 'dialog';
  //   config.width = '50%';
  //   config.height = '40%';
  //   config.position = {top: '0px'};
  //   this.editorDialogRef = this.dialog.open(CandidateProfileRejectDialog, config);
  //   this.editorDialogRef.componentInstance.candidate = candidate;
  //   this.editorDialog.afterClosed().subscribe((res) => {
  //    this.route.params.subscribe((params: { taskId: string }) => {
  //     let taskId: string = params.taskId;
  //     console.log('intake: ' + taskId);
  //     this.store.dispatch(this.admissionActions.findIntakeTaskByTaskId(taskId));
  //   });
  //   });
  // }

}
