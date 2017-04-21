import {Component, OnInit, ViewContainerRef, Input} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {MdSnackBar, MdDialog, MdDialogRef, MdDialogConfig} from "@angular/material";
import {IntakeTask} from "../intake-task.interface";
import {IntakeActions} from "../intake.action";
import {IntakeTaskState} from "../intake-task.reducer";
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {PolicyModuleState} from "../../index";


@Component({
  selector: 'pams-intake-draft-task',
  templateUrl: './intake-draft-task.panel.html',
})

export class IntakeDraftTaskPanel {

  @Input() intakeTask: IntakeTask;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private viewContainerRef: ViewContainerRef,
              private actions: IntakeActions,
              private store: Store<PolicyModuleState>,
              private dialog: MdDialog,
              private snackBar: MdSnackBar) {
  }

  draft(intakeTask: IntakeTask) {
    this.store.dispatch(this.actions.completeIntakeTask(intakeTask));
  }

  goBack(): void {
    this.router.navigate(['/policy/intakes']);
  }
}
