import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {AdmissionModuleState} from "./index";
import {PolicyModuleState} from "../policy/index";
import {IntakeActions} from "../policy/intakes/intake.action";
import {IntakeTask} from "../policy/intakes/intake-task.interface";
import {Observable} from "rxjs/Observable";

@Component({
  selector: 'pams-admission-page',
  templateUrl: './admission.page.html',
})

export class AdmissionPage implements OnInit {

  private INTAKE_TASKS = "policyModuleState.intakeTasks".split(".");
  private intakeTasks$: Observable<IntakeTask[]>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private store: Store<AdmissionModuleState>,
              private policyStore: Store<PolicyModuleState>,
              private intakeActions: IntakeActions) {
    this.intakeTasks$ = this.policyStore.select(...this.INTAKE_TASKS);
  }

  ngOnInit(): void {
    this.route.params.subscribe(() => {
      this.policyStore.dispatch(this.intakeActions.findAssignedIntakeTasks());
    });
  }
}
