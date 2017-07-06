import {
  Component, OnInit,
} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {IntakeTask} from '../policy/intakes/intake-task.interface';
import {AdmissionActions} from './admission.action';
import {AdmissionModuleState} from './index';
import {Candidate} from './candidate.interface';

@Component({
  selector: 'pams-intake-task-view',
  templateUrl: './intake-task-view.page.html',
})
export class IntakeTaskViewPage implements OnInit {

  private INTAKE_TASK: string[] = 'admissionModuleState.intakeTask'.split('.');
  private CANDIDATES: string[] = 'admissionModuleState.candidates'.split('.');
  private SELECTED_CANDIDATES: string[] = 'admissionModuleState.selectedCandidates'.split('.');
  private REJECTED_CANDIDATES: string[] = 'admissionModuleState.rejectedCandidates'.split('.');
  private intakeTask$: Observable<IntakeTask>;
  private candidates$: Observable<Candidate[]>;
  private selectedCandidates$: Observable<Candidate[]>;
  private rejectedCandidates$: Observable<Candidate[]>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private store: Store<AdmissionModuleState>,
              private actions: AdmissionActions) {
    this.intakeTask$ = this.store.select(...this.INTAKE_TASK);
    this.candidates$ = this.store.select(...this.CANDIDATES);
    this.selectedCandidates$ = this.store.select(...this.SELECTED_CANDIDATES);
    this.rejectedCandidates$ = this.store.select(...this.REJECTED_CANDIDATES);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { taskId: string }) => {
      let taskId: string = params.taskId;
      console.log('intake: ' + taskId);
      this.store.dispatch(this.actions.findIntakeTaskByTaskId(taskId));
    });
  }

  broadcast(): void {
    // this.store.dispatch(this.actions.broadcastIntakeResult(null));
  }

  approve(): void {
    // no op
  }

  goBack(): void {
    this.router.navigate(['/policy/intakes']);
  }
}