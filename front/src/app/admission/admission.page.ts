import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {AdmissionModuleState} from "./index";
import {IntakeTask} from "../policy/intakes/intake-task.interface";
import {Observable} from "rxjs/Observable";
import {AdmissionActions} from "./admission.action";

@Component({
  selector: 'pams-admission-page',
  templateUrl: './admission.page.html',
})

export class AdmissionPage implements OnInit {

  private INTAKE_TASKS = "admissionModuleState.intakeTasks".split(".");
  private intakeTasks$: Observable<IntakeTask[]>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private store: Store<AdmissionModuleState>,
              private actions: AdmissionActions) {
    this.intakeTasks$ = this.store.select(...this.INTAKE_TASKS);
  }

  ngOnInit(): void {
    this.route.params.subscribe(() => {
      this.store.dispatch(this.actions.findAssignedIntakeTasks());
    });
  }

  view(intake: IntakeTask) {
    console.log("intake: " + intake.taskId);
    this.router.navigate(['/view-task', intake.taskId]);
  }

}
