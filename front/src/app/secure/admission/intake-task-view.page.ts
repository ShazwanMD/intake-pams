import {
  Component, OnInit, Input,
} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {AdmissionActions} from './admission.action';
import {AdmissionModuleState} from './index';
import {IntakeTask} from '../../shared/model/policy/intake-task.interface';
import {Candidate} from '../../shared/model/admission/candidate.interface';

@Component({
  selector: 'pams-intake-task-view',
  templateUrl: './intake-task-view.page.html',
})
export class IntakeTaskViewPage implements OnInit {

  private INTAKE_TASK: string[] = 'admissionModuleState.intakeTask'.split('.');
  private CANDIDATES: string[] = 'admissionModuleState.candidates'.split('.');
  private SELECTED_CANDIDATES: string[] = 'admissionModuleState.selectedCandidates'.split('.');
  private PRE_SELECTED_CANDIDATES: string[] = 'admissionModuleState.preSelectedCandidates'.split('.');
  private REJECTED_CANDIDATES: string[] = 'admissionModuleState.rejectedCandidates'.split('.');
  private APPROVED_CANDIDATES: string[] = 'admissionModuleState.approvedCandidates'.split('.');
  private intakeTask$: Observable<IntakeTask>;
  private candidates$: Observable<Candidate[]>;
  private selectedCandidates$: Observable<Candidate[]>;
  private preSelectedCandidates$: Observable<Candidate[]>;
  private rejectedCandidates$: Observable<Candidate[]>;
  private approvedCandidates$: Observable<Candidate[]>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private store: Store<AdmissionModuleState>,
              private actions: AdmissionActions) {
    this.intakeTask$ = this.store.select(...this.INTAKE_TASK);
    this.candidates$ = this.store.select(...this.CANDIDATES);
    this.selectedCandidates$ = this.store.select(...this.SELECTED_CANDIDATES);
    this.rejectedCandidates$ = this.store.select(...this.REJECTED_CANDIDATES);
    this.preSelectedCandidates$ = this.store.select(...this.PRE_SELECTED_CANDIDATES);
    this.approvedCandidates$ = this.store.select(...this.APPROVED_CANDIDATES);
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
