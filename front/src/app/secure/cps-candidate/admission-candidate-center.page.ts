import { Intake } from './../../shared/model/policy/intake.interface';
import { IntakeActions } from './../policy/intakes/intake.action';
import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import {AdmissionCandidateModuleState} from './index';
import {Observable} from 'rxjs/Observable';
import {IntakeTask} from '../../shared/model/policy/intake-task.interface';
import { CandidateTask } from '../../shared/model/admission/candidate-task.interface';
import { AdmissionCandidateActions } from "./admission-candidate.action";
import { Candidate } from "../../shared/model/admission/candidate.interface";

@Component({
  selector: 'pams-admission-candidate-center.page',
  templateUrl: './admission-candidate-center.page.html',
})

export class AdmissionCandidateCenterPage implements OnInit {
    
    private CANDIDATE_TASKS: string[] = 'admissionCandidateModuleState.candidateTasks'.split('.');
    private ASSIGNED_CANDIDATE: string[] = 'admissionCandidateModuleState.assignedCandidate'.split('.');
    private POOLED_CANDIDATE: string[] = 'admissionCandidateModuleState.pooledCandidate'.split('.');
    private ARCHIVED_CANDIDATE: string[] = 'admissionCandidateModuleState.archivedCandidate'.split('.');

    private assignedCandidate$: Observable<CandidateTask[]>;
    private pooledCandidate$: Observable<CandidateTask[]>;
    private candidateTasks$: Observable<CandidateTask[]>;
    private archivedCandidate$: Observable<Candidate[]>;

    constructor(private router: Router,
            private route: ActivatedRoute,
            private store: Store<AdmissionCandidateModuleState>,
            private actions: AdmissionCandidateActions) {
        this.assignedCandidate$ = this.store.select(...this.ASSIGNED_CANDIDATE);
        this.pooledCandidate$ = this.store.select(...this.POOLED_CANDIDATE);
        this.candidateTasks$ = this.store.select(...this.CANDIDATE_TASKS);
        this.archivedCandidate$ = this.store.select(...this.ARCHIVED_CANDIDATE);
    }
    
    ngOnInit(): void {
        this.route.params.subscribe(() => {
          this.store.dispatch(this.actions.findAssignedCandidateTasks());
          this.store.dispatch(this.actions.findPooledCandidateTasks());
          this.store.dispatch(this.actions.findArchivedCandidates());
        });
      }
    
    viewTask(task: CandidateTask) {
        console.log('CandidateTask view: ' + task.taskId);
        this.router.navigate(['/secure/cps-candidate/view-task/', task.taskId]);

      }
    
    claimTask(task: CandidateTask) {
       this.store.dispatch(this.actions.claimCandidateTask(task));
      }
    
    viewDetail(task: Candidate) {
        console.log('Candidate view: ' + task.referenceNo);
        this.router.navigate(['/secure/cps-candidate/candidate-view-detail/', task.referenceNo]);

      }
}
