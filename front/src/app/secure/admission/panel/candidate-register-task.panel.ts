import { Intake } from './../../../shared/model/policy/intake.interface';
import { GraduateCenter } from './../../../shared/model/common/graduate-center.interface';
import { AdmissionModuleState } from '..';
import { Candidate } from '../../../shared/model/admission/candidate.interface';
import { IntakeTask } from '../../../shared/model/policy/intake-task.interface';
import { AdmissionActions } from '../admission.action';
import {
  Component, OnInit, Input,
} from '@angular/core';
import { MdSnackBar } from '@angular/material';
import {Router, ActivatedRoute} from '@angular/router';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import { IntakeActions } from "../../policy/intakes/intake.action";
import { ReportActions } from '../../../shared/report/report.action';

@Component({
  selector: 'pams-candidate-register-task',
  templateUrl: './candidate-register-task.panel.html',
})
export class CandidateRegisterTaskPanel implements OnInit {
  
  @Input() intakeTask: IntakeTask;
  @Input() intake: Intake;

  //private INTAKE_TASK: string[] = 'admissionModuleState.intakeTask'.split('.');
  private CANDIDATES: string[] = 'admissionModuleState.candidates'.split('.');
  private SELECTED_CANDIDATES: string[] = 'admissionModuleState.selectedCandidates'.split('.');
  private PRE_SELECTED_CANDIDATES: string[] = 'admissionModuleState.preSelectedCandidates'.split('.');
  private REJECTED_CANDIDATES: string[] = 'admissionModuleState.rejectedCandidates'.split('.');
  private APPROVED_CANDIDATES: string[] = 'admissionModuleState.approvedCandidates'.split('.');
  private OFFERED_CANDIDATES: string[] = 'admissionModuleState.offeredCandidates'.split('.');
  private ACCEPTED_CANDIDATES: string[] = 'admissionModuleState.acceptedCandidates'.split('.');
  private REGISTERED_CANDIDATES: string[] = 'admissionModuleState.registeredCandidates'.split('.');
  //private intakeTask$: Observable<IntakeTask>;
  private candidates$: Observable<Candidate[]>;
  private selectedCandidates$: Observable<Candidate[]>;
  private preSelectedCandidates$: Observable<Candidate[]>;
  private rejectedCandidates$: Observable<Candidate[]>;
  private approvedCandidates$: Observable<Candidate[]>;
  private offeredCandidates$: Observable<Candidate[]>;
  private acceptedCandidates$: Observable<Candidate[]>;
  private registeredCandidates$: Observable<Candidate[]>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private store: Store<AdmissionModuleState>,
              private snackBar: MdSnackBar,
              private intakeActions: IntakeActions,
              private reportActions: ReportActions,
              private actions: AdmissionActions) {
    //this.intakeTask$ = this.store.select(...this.INTAKE_TASK);
    this.candidates$ = this.store.select(...this.CANDIDATES);
    this.selectedCandidates$ = this.store.select(...this.SELECTED_CANDIDATES);
    this.rejectedCandidates$ = this.store.select(...this.REJECTED_CANDIDATES);
    this.preSelectedCandidates$ = this.store.select(...this.PRE_SELECTED_CANDIDATES);
    this.offeredCandidates$ = this.store.select(...this.OFFERED_CANDIDATES);
    this.acceptedCandidates$ = this.store.select(...this.ACCEPTED_CANDIDATES);
    this.registeredCandidates$ = this.store.select(...this.REGISTERED_CANDIDATES);
  }

  ngOnInit(): void {
  }

  broadcast(): void {
    // this.store.dispatch(this.actions.broadcastIntakeResult(null));
  }

  startAcademic(referenceNo): void {
    // start offer process for candidate in status approve
    if(confirm('Confirm to Start Academic This candidate?')){
        this.store.dispatch(this.intakeActions.completeIntakeTask(this.intakeTask));
      this.goBack();
    }else {
    }
  }

  goBack(): void {
    this.router.navigate(['/secure/admission']);
    window.location.reload();
  }

  downloadReport(reportId, parameterReport1: IntakeTask): void { 
  let repParam = reportId + '&intake_reference_no=' + parameterReport1.referenceNo;
  this.store.dispatch(this.reportActions.downloadReport(repParam));
   }
} 
