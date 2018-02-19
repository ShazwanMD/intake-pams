import { Intake } from './../../shared/model/policy/intake.interface';
import { IntakeActions } from './../policy/intakes/intake.action';
import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import {AdmissionModuleState} from './index';
import {Observable} from 'rxjs/Observable';
import {AdmissionActions} from './admission.action';
import {IntakeTask} from '../../shared/model/policy/intake-task.interface';
import { CandidateTask } from '../../shared/model/admission/candidate-task.interface';

@Component({
  selector: 'pams-admission-center-page',
  templateUrl: './admission-center.page.html',
})

export class AdmissionCenterPage implements OnInit {

  private INTAKE_TASKS: string[] = 'admissionModuleState.intakeTasks'.split('.');
  private ASSIGNED_CANDIDATE_TASKS: string[] = 'admissionModuleState.assignedCandidateTasks'.split('.');
  private POOLED_CANDIDATE_TASKS: string[] = 'admissionModuleState.pooledCandidateTasks'.split('.');
  private ARCHIVED_INTAKES: string[] = 'policyModuleState.archivedIntakes'.split('.');
  private CANDIDATE_TASKS: string[] = 'admissionModuleState.assignedTaskCandidates'.split('.');

 
  private assignedTaskCandidates$: Observable<CandidateTask[]>;
  private assignedCandidateTasks$: Observable<IntakeTask[]>;
  private pooledCandidateTasks$: Observable<IntakeTask[]>;
  private archivedIntakes$: Observable<Intake[]>;
  private intakeTasks$: Observable<IntakeTask[]>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private store: Store<AdmissionModuleState>,
              private action: IntakeActions,
              private actions: AdmissionActions) {
    this.intakeTasks$ = this.store.select(...this.INTAKE_TASKS);
    this.assignedCandidateTasks$ = this.store.select(...this.ASSIGNED_CANDIDATE_TASKS);
    this.pooledCandidateTasks$ = this.store.select(...this.POOLED_CANDIDATE_TASKS);
    this.archivedIntakes$ = this.store.select(...this.ARCHIVED_INTAKES);
    this.assignedTaskCandidates$ = this.store.select(...this.CANDIDATE_TASKS);
  }

  ngOnInit(): void {
    this.route.params.subscribe(() => {
      this.store.dispatch(this.actions.findAssignedIntakeTasks());
      this.store.dispatch(this.actions.findPooledIntakeTasks());
      this.store.dispatch(this.action.findArchivedIntakes());
    });
  }

  view(intake: IntakeTask) {
    console.log('intake: ' + intake.taskId);
    this.router.navigate(['/intake-task-detail', intake.taskId]);
  }

  viewTask(task: IntakeTask) {
    console.log('intake: ' + task.taskId);
    this.router.navigate(['/secure/admission/view-task/', task.taskId]);

  }

  viewIntake(intake: Intake) {
    this.router.navigate(['/secure/policy/intakes/intake-process-detail', intake.referenceNo]);
  }

  claimTask(task: IntakeTask) {
    console.log('intake: ' + task.taskId);
    this.store.dispatch(this.action.claimIntakeTask(task));
  }

}
