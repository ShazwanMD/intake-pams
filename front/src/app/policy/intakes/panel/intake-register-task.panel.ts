import {Component, OnInit, ViewContainerRef, Input} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {MdSnackBar, MdDialog, MdDialogRef, MdDialogConfig} from "@angular/material";
import {IntakeTask} from "../intake-task.interface";
import {IntakeActions} from "../intake.action";
import {Store} from "@ngrx/store";
import {PolicyModuleState} from "../../index";


@Component({
  selector: 'pams-intake-register-task',
  templateUrl: './intake-register-task.panel.html',
})

export class IntakeRegisterTaskPanel {

  @Input() intakeTask: IntakeTask;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private viewContainerRef: ViewContainerRef,
              private actions: IntakeActions,
              private store: Store<PolicyModuleState>,
              private dialog: MdDialog,
              private snackBar: MdSnackBar) {
  }

  verify() {
    this.store.dispatch(this.actions.completeIntakeTask(this.intakeTask));
    this.goBack();
  }

  goBack(): void {
    this.router.navigate(['/policy/intakes']);
  }
}
