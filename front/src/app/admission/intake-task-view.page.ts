import {
  Component, OnInit
} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {Observable} from "rxjs";
import {Store} from "@ngrx/store";
import {IntakeTask} from "../policy/intakes/intake-task.interface";
import {AdmissionActions} from "./admission.action";
import {AdmissionModuleState} from "./index";
import {Candidate} from "./candidate.interface";


@Component({
  selector: 'pams-intake-task-iew',
  templateUrl: './intake-task-view.page.html',
})
export class IntakeTaskViewPage implements OnInit {

  private INTAKE_TASK = "admissionModuleState.intakeTask".split(".");
  private CANDIDATES = "admissionModuleState.candidates".split(".");
  private intakeTask$: Observable<IntakeTask>;
  private candidates$: Observable<Candidate[]>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private store: Store<AdmissionModuleState>,
              private actions: AdmissionActions) {
    this.intakeTask$ = this.store.select(...this.INTAKE_TASK)
    this.candidates$ = this.store.select(...this.CANDIDATES)
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { taskId: string }) => {
      let taskId: string = params.taskId;
      this.store.dispatch(this.actions.findIntakeTaskByTaskId(taskId));
      this.intakeTask$.subscribe(task => {
        if (null != task)
          this.store.dispatch(this.actions.findCandidates(task.intake))
      })
    });
  }

  broadcast(): void {
    this.store.dispatch(this.actions.broadcastIntakeResult(null)); // todo: payload
  }

  register(): void {

  }

  goBack(): void {
    this.router.navigate(['/policy/intakes']);
  }
}
