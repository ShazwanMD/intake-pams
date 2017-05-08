import {Component, OnInit, ChangeDetectionStrategy, state, ViewContainerRef} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {Store, State} from "@ngrx/store";
import {Observable} from "rxjs";
import {IntakeSessionActions} from "./intake-session.action";
import {IntakeSessionTask} from "./intake-session-task.interface";
import {PolicyModuleState} from "../index";
import {MdDialogConfig, MdDialogRef, MdDialog} from "@angular/material";
import {ApplicationModuleState} from "../../application/index";
import { IntakeSessionTaskCreatorDialog } from "./dialog/intake-session-task-creator.dialog";

@Component({
  selector: 'pams-intake-session-center',
  templateUrl: './intake-session-center.page.html',
})

export class IntakeSessionCenterPage implements OnInit {

  private INTAKE_SESSION_TASKS = "policyModuleState.intakeSessionTasks".split(".");
  private intakeSessionTasks$: Observable<IntakeSessionTask[]>;
  private creatorDialogRef: MdDialogRef<IntakeSessionTaskCreatorDialog>;

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
    console.log("showDialog");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(IntakeSessionTaskCreatorDialog, config);
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
      // load something here
    });
  }

  ngOnInit(): void {
  }
}

