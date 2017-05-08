import {Component, OnInit, ViewContainerRef, Input} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {MdSnackBar, MdDialog, MdDialogRef, MdDialogConfig} from "@angular/material";
import {IntakeTask} from "../intake-task.interface";
import {IntakeActions} from "../intake.action";
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

export class IntakeDraftTaskPanel implements OnInit {

  private PROGRAM_OFFERINGS = "policyModuleState.programOfferings".split(".");
  private SUPERVISOR_OFFERINGS = "policyModuleState.supervisorOfferings".split(".");
  private STUDY_MODE_OFFERINGS = "policyModuleState.studyModeOfferings".split(".");

  @Input() intakeTask: IntakeTask;
  programOfferings$: Observable<ProgramOffering[]>;
  supervisorOfferings$: Observable<SupervisorOffering[]>;
  studyModeOfferings$: Observable<StudyModeOffering[]>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private viewContainerRef: ViewContainerRef,
              private actions: IntakeActions,
              private store: Store<PolicyModuleState>,
              private dialog: MdDialog,
              private snackBar: MdSnackBar) {
    this.programOfferings$ = this.store.select(...this.PROGRAM_OFFERINGS);
    this.supervisorOfferings$ = this.store.select(...this.SUPERVISOR_OFFERINGS);
    this.studyModeOfferings$ = this.store.select(...this.STUDY_MODE_OFFERINGS);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findIntakeByReferenceNo(this.intakeTask.referenceNo));
  }

  draft(intakeTask: IntakeTask) {
    this.store.dispatch(this.actions.completeIntakeTask(intakeTask));
  }

  goBack(): void {
    this.router.navigate(['/policy/intakes']);
  }
}
