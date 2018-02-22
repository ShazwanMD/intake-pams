import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import { Observable } from 'rxjs';
import {Store} from '@ngrx/store';
import { CandidateTask } from "../../shared/model/admission/candidate-task.interface";
import { AdmissionCandidateActions } from "./admission-candidate.action";
import { AdmissionCandidateModuleState } from "./index";

@Component({
  selector: 'pams-admission-task-detail',
  templateUrl: './admission-task-detail.page.html',
})
export class AdmissionTaskDetailPage implements OnInit {

  private CANDIDATE_TASKS: string[] = 'admissionCandidateModuleState.candidateTasks'.split('.');
  private candidateTasks$: Observable<CandidateTask>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private store: Store<AdmissionCandidateModuleState>,
              private actions: AdmissionCandidateActions) {
      this.candidateTasks$ = this.store.select(...this.CANDIDATE_TASKS);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { taskId: string }) => {
      let taskId: string = params.taskId;
      this.store.dispatch(this.actions.findCandidateTaskByTaskId(taskId));
    });
  }

  goBack(): void {
    this.router.navigate(['/secure/cps-candidate/']);
  }
}

