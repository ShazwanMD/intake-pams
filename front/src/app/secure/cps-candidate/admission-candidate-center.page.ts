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

@Component({
  selector: 'pams-admission-candidate-center.page',
  templateUrl: './admission-candidate-center.page.html',
})

export class AdmissionCandidateCenterPage implements OnInit {
    
    private CANDIDATE_TASK: string[] = 'admissionCandidateModuleState.candidateTask'.split('.');
    private ASSIGNED_CANDIDATE: string[] = 'admissionCandidateModuleState.assignedCandidate'.split('.');
    private POOLED_CANDIDATE: string[] = 'admissionCandidateModuleState.pooledCandidate'.split('.');

    private assignedCandidate$: Observable<CandidateTask[]>;
    private pooledCandidate$: Observable<CandidateTask[]>;
    private candidateTask$: Observable<CandidateTask[]>;

    constructor(private router: Router,
            private route: ActivatedRoute,
            private store: Store<AdmissionCandidateModuleState>,
            private actions: AdmissionCandidateActions) {
        this.assignedCandidate$ = this.store.select(...this.ASSIGNED_CANDIDATE);
        this.pooledCandidate$ = this.store.select(...this.POOLED_CANDIDATE);
        this.candidateTask$ = this.store.select(...this.CANDIDATE_TASK);
    }
    
    ngOnInit(): void {
        this.route.params.subscribe(() => {
          this.store.dispatch(this.actions.findAssignedCandidateTasks());
          //this.store.dispatch(this.actions.findPooledCandidateTasks());
        });
      }
    
    viewTask(task: CandidateTask) {
        //console.log('intake: ' + task.taskId);
        //this.router.navigate(['/secure/admission/view-task/', task.taskId]);

      }
    
    claimTask(task: CandidateTask) {
        //console.log('intake: ' + task.taskId);
       //this.store.dispatch(this.actions.claimIntakeTask(task));
      }
}
