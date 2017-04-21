import {Component, OnInit, ViewContainerRef, Input} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {MdSnackBar, MdDialog, MdDialogRef, MdDialogConfig} from "@angular/material";
import {IntakeTask} from "../intake-task.interface";
import {IntakeActions} from "../intake.action";
import {IntakeTaskState} from "../intake-task.reducer";
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {PolicyModuleState} from "../../index";
import {ProgramOffering} from "../program-offering.interface";
import {StudyModeOffering} from "../study-mode-offering.interface";
import {SupervisorOffering} from "../supervisor-offering.interface";


@Component({
  selector: 'pams-intake-draft-task',
  templateUrl: './intake-draft-task.panel.html',
})

export class IntakeDraftTaskPanel implements OnInit{

  @Input() intakeTask: IntakeTask;
  programOfferings$:Observable<ProgramOffering[]>;
  supervisorOfferings$:Observable<SupervisorOffering[]>;
  studyModeOfferings$:Observable<StudyModeOffering[]>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private viewContainerRef: ViewContainerRef,
              private actions: IntakeActions,
              private store: Store<PolicyModuleState>,
              private dialog: MdDialog,
              private snackBar: MdSnackBar) {
    this.programOfferings$ =  this.store.select(state => state.programOfferings);
    this.supervisorOfferings$ =  this.store.select(state => state.supervisorOfferings);
    this.studyModeOfferings$ =  this.store.select(state => state.studyModeOfferings);
  }

  ngOnInit():void {
    this.store.dispatch(this.actions.findIntakeByReferenceNo(this.intakeTask.referenceNo));
  }

  draft(intakeTask: IntakeTask) {
    this.store.dispatch(this.actions.completeIntakeTask(intakeTask));
  }

  goBack(): void {
    this.router.navigate(['/policy/intakes']);
  }
}
