import {Component, OnInit, ChangeDetectionStrategy, state, ViewContainerRef} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {IntakeActions} from "./intake.action";
import {IntakeTask} from "./intake-task.interface";
import {PolicyModuleState} from "../index";
import {MdDialogConfig, MdDialogRef, MdDialog} from "@angular/material";
import {IntakeTaskCreatorDialog} from "./dialog/intake-task-creator.dialog";

@Component({
  selector: 'pams-intake-center',
  templateUrl: './intake-center.page.html',
})

export class IntakeCenterPage implements OnInit {

  private intakeTasks$: Observable<IntakeTask[]>;
  private creatorDialogRef: MdDialogRef<IntakeTaskCreatorDialog>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: IntakeActions,
              private store: Store<PolicyModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
    this.intakeTasks$ = this.store.select(state => state.intakeTasks);
  }

  goBack(route: string): void {
    this.router.navigate(['/intakes']);
  }

  view(intake: IntakeTask) {
    console.log("intake: " + intake.taskId);
    this.router.navigate(['/view-task', intake.taskId]);
  }

  showDialog(): void {
    console.log("showDialog");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '60%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(IntakeTaskCreatorDialog, config);
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
      // load something here
    });
  }

  ngOnInit(): void {
    console.log("find assigned intake tasks");
    this.store.dispatch(this.actions.findAssignedIntakeTasks());
  }
}

