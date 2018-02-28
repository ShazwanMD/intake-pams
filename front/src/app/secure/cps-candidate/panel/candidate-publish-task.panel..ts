import { AdmissionCandidateModuleState } from '..';
import { Candidate } from '../../../shared/model/admission/candidate.interface';
import { CandidateTask } from '../../../shared/model/admission/candidate-task.interface';
import { IntakeActions } from '../../policy/intakes/intake.action';
import {
  Component, OnInit, Input,
} from '@angular/core';
import { MdSnackBar } from '@angular/material';
import {Router, ActivatedRoute} from '@angular/router';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import { ReportActions } from '../../../shared/report/report.action';
import { AdmissionCandidateActions } from "../admission-candidate.action";
import { IntakeApplication } from "../../../shared/model/application/intake-application.interface";
import { ApplicationModuleState } from "../../application/index";

@Component({
  selector: 'pams-candidate-publish-task',
  templateUrl: './candidate-publish-task.panel.html',
})
export class CandidatePublishTaskPanel implements OnInit {
  
  @Input() candidateTask: CandidateTask;

  //private INTAKE_TASK: string[] = 'admissionModuleState.intakeTask'.split('.');
  
  private CANDIDATE_BY_ID: string[] = 'admissionCandidateModuleState.candidate'.split('.');
//  private INTAKE_APPLICATION: string[] = 'applicationModuleState.intakeApplication'.split('.');
//  private PRE_SELECTED_CANDIDATES: string[] = 'admissionModuleState.preSelectedCandidates'.split('.');
//  private REJECTED_CANDIDATES: string[] = 'admissionModuleState.rejectedCandidates'.split('.');
//  private APPROVED_CANDIDATES: string[] = 'admissionModuleState.approvedCandidates'.split('.');
  //private intakeTask$: Observable<IntakeTask>;
  
  private candidate$: Observable<Candidate>;
//  private intakeApplication$: Observable<IntakeApplication>;
//  private selectedCandidates$: Observable<Candidate[]>;
//  private preSelectedCandidates$: Observable<Candidate[]>;
//  private rejectedCandidates$: Observable<Candidate[]>;
//  private approvedCandidates$: Observable<Candidate[]>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private store: Store<AdmissionCandidateModuleState>,
              //private stores: Store<ApplicationModuleState>,
              private snackBar: MdSnackBar,
              private reportActions: ReportActions,
              private intakeActions: IntakeActions,
              private actions: AdmissionCandidateActions) {
     
      this.candidate$ = this.store.select(...this.CANDIDATE_BY_ID);
//      this.intakeApplication$ = this.stores.select(...this.INTAKE_APPLICATION);
//    this.selectedCandidates$ = this.store.select(...this.SELECTED_CANDIDATES);
//    this.rejectedCandidates$ = this.store.select(...this.REJECTED_CANDIDATES);
//    this.preSelectedCandidates$ = this.store.select(...this.PRE_SELECTED_CANDIDATES);
//    this.approvedCandidates$ = this.store.select(...this.APPROVED_CANDIDATES);
  }

  ngOnInit(): void {
      console.log("candidateTask.candidate" + this.candidateTask.candidateIntake.id);
      this.store.dispatch(this.actions.findCandidateById(this.candidateTask.candidateIntake.id));
  }

  select(){
      this.store.dispatch(this.actions.completeCandidateTask(this.candidateTask));
      this.goBack();
  }

  goBack(): void {
    this.router.navigate(['/secure/cps-candidate']);
    //window.location.reload();
  }

}
