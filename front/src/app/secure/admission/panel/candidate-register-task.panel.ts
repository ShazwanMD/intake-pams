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

@Component({
  selector: 'pams-candidate-register-task',
  templateUrl: './candidate-register-task.panel.html',
})
export class CandidateRegisterTaskPanel implements OnInit {
  
  @Input() intakeTask: IntakeTask;

  //private INTAKE_TASK: string[] = 'admissionModuleState.intakeTask'.split('.');
  private CANDIDATES: string[] = 'admissionModuleState.candidates'.split('.');
  private SELECTED_CANDIDATES: string[] = 'admissionModuleState.selectedCandidates'.split('.');
  private PRE_SELECTED_CANDIDATES: string[] = 'admissionModuleState.preSelectedCandidates'.split('.');
  private REJECTED_CANDIDATES: string[] = 'admissionModuleState.rejectedCandidates'.split('.');
  private APPROVED_CANDIDATES: string[] = 'admissionModuleState.approvedCandidates'.split('.');
  //private intakeTask$: Observable<IntakeTask>;
  private candidates$: Observable<Candidate[]>;
  private selectedCandidates$: Observable<Candidate[]>;
  private preSelectedCandidates$: Observable<Candidate[]>;
  private rejectedCandidates$: Observable<Candidate[]>;
  private approvedCandidates$: Observable<Candidate[]>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private store: Store<AdmissionModuleState>,
              private snackBar: MdSnackBar,
              private actions: AdmissionActions) {
    //this.intakeTask$ = this.store.select(...this.INTAKE_TASK);
    this.candidates$ = this.store.select(...this.CANDIDATES);
    this.selectedCandidates$ = this.store.select(...this.SELECTED_CANDIDATES);
    this.rejectedCandidates$ = this.store.select(...this.REJECTED_CANDIDATES);
    this.preSelectedCandidates$ = this.store.select(...this.PRE_SELECTED_CANDIDATES);
    this.approvedCandidates$ = this.store.select(...this.APPROVED_CANDIDATES);
  }

  ngOnInit(): void {
   // this.route.params.subscribe((params: { taskId: string }) => {
      //let taskId: string = params.taskId;
      console.log('intake: ' + this.intakeTask.taskId);
      this.store.dispatch(this.actions.findIntakeTaskByTaskId(this.intakeTask.taskId));
    //});
  }

  broadcast(): void {
    // this.store.dispatch(this.actions.broadcastIntakeResult(null));
  }

  offer(referenceNo): void {
    // start offer process for candidate in status approve
     let snackBarRef = this.snackBar.open('Confirm to Offer This candidate?', 'Ok');

    snackBarRef.afterDismissed().subscribe(() => {
      console.log("submit candidate in snck bar: "+referenceNo);
      this.store.dispatch(this.actions.offerCandidate(referenceNo));
      this.goBack();
    });
  }

  goBack(): void {
    this.router.navigate(['/secure/admission']);
  }
}
