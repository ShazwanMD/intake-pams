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
import {IntakeApplication} from "../../../application/intake-applications/intake-application.interface";


@Component({
  selector: 'pams-intake-evaluate-task',
  templateUrl: './intake-evaluate-task.panel.html',
})

export class IntakeEvaluateTaskPanel implements OnInit {

  private PROGRAM_OFFERINGS: string[] = "policyModuleState.programOfferings".split(".");
  private SUPERVISOR_OFFERINGS: string[] = "policyModuleState.supervisorOfferings".split(".");
  private STUDY_MODE_OFFERINGS: string[] = "policyModuleState.studyModeOfferings".split(".");
  private INTAKE_APPLICATIONS: string[] = "policyModuleState.intakeApplications".split(".");
  private INTAKE_SUBMITTED_APPLICATIONS: string[] = "policyModuleState.intakeSubmittedApplications".split(".");
  private INTAKE_SELECTED_APPLICATIONS: string[] = "policyModuleState.intakeSelectedApplications".split(".");
  private INTAKE_REJECTED_APPLICATIONS: string[] = "policyModuleState.intakeRejectedApplications".split(".");

  @Input() intakeTask: IntakeTask;
  programOfferings$: Observable<ProgramOffering[]>;
  supervisorOfferings$: Observable<SupervisorOffering[]>;
  studyModeOfferings$: Observable<StudyModeOffering[]>;
  intakeSubmittedApplications$: Observable<IntakeApplication[]>;
  intakeSelectedApplications$: Observable<IntakeApplication[]>;
  intakeRejectedApplications$: Observable<IntakeApplication[]>;

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
    this.intakeSubmittedApplications$ = this.store.select(...this.INTAKE_SUBMITTED_APPLICATIONS);
    this.intakeSelectedApplications$ = this.store.select(...this.INTAKE_SELECTED_APPLICATIONS);
    this.intakeRejectedApplications$ = this.store.select(...this.INTAKE_REJECTED_APPLICATIONS);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findIntakeByReferenceNoAndBidStatus(this.intakeTask.referenceNo));
  }


  copy() {
    let snackBarRef = this.snackBar.open("Copy this intake?", "Yes");
    snackBarRef.afterDismissed().subscribe(() => {
      this.store.dispatch(this.actions.copyIntakeTask(this.intakeTask));
      this.goBack();
    });
  }

  goBack(): void {
    this.router.navigate(['/policy/intakes']);
  }
}
