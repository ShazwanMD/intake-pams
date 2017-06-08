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
import { IntakeTaskCreatorDialog } from "../dialog/intake-task-creator.dialog";


@Component({
  selector: 'pams-intake-draft-task',
  templateUrl: './intake-draft-task.panel.html',
})

export class IntakeDraftTaskPanel implements OnInit {editorDialogRef: MdDialogRef<IntakeTaskCreatorDialog>;

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

  verify() {
    let snackBarRef = this.snackBar.open("Verify this intake?", "Yes");
    snackBarRef.afterDismissed().subscribe(() => {
    this.store.dispatch(this.actions.completeIntakeTask(this.intakeTask));
    this.goBack();
    });
  }
  
  edit() {
      this.showDialog(this.intakeTask);
  }
  
  showDialog(intake : IntakeTask): void {
      console.log("showDialog");
      let config = new MdDialogConfig();
      config.viewContainerRef = this.viewContainerRef;
      config.role = 'dialog';
      config.width = '50%';
      config.height = '60%';
      config.position = {top: '0px'};
      this.editorDialogRef = this.dialog.open(IntakeTaskCreatorDialog, config);
      this.editorDialogRef.componentInstance.intakeTask = this.intakeTask;

      this.editorDialogRef.afterClosed().subscribe(res => {
          console.log("close dialog");
          
        });
  }

  goBack(): void {
    this.router.navigate(['/policy/intakes']);
  }
}
