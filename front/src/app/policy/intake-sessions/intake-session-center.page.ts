import {Component, OnInit, ChangeDetectionStrategy, state, ViewContainerRef} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {Store, State} from "@ngrx/store";
import {Observable} from "rxjs";
import {IntakeSessionActions} from "./intake-session.action";
import {IntakeSessionTask} from "./intake-session-task.interface";
import {PolicyModuleState} from "../index";
import {MdDialogConfig, MdDialogRef, MdDialog} from "@angular/material";
import {ApplicationModuleState} from "../../application/index";

@Component({
  selector: 'pams-intake-session-center',
  templateUrl: './intake-session-center.page.html',
})

export class IntakeSessionCenterPage implements OnInit {

  private INTAKE_SESSION_TASKS = "policyModuleState.intakeSessionTasks".split(".");
  private intakeSessionTasks$: Observable<IntakeSessionTask[]>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: IntakeSessionActions,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
  }

  goBack(route: string): void {
    this.router.navigate(['/intake-sessions']);
  }

  view(intakeSession: IntakeSessionTask) {
    console.log("intakeSession: " + intakeSession.taskId);
    this.router.navigate(['/view-task', intakeSession.taskId]);
  }

  showDialog(): void {
  
  }

  ngOnInit(): void {
  }
}

