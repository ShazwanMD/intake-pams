import { IntakeUpdaterDialog } from './dialog/intake-updater.dialog';
import { PolicyModuleState } from './../index';
import { IntakeActions } from './intake.action';
import { StudyModeOffering } from './../../../shared/model/policy/study-mode-offering.interface';
import { SupervisorOffering } from './../../../shared/model/policy/supervisor-offering.interface';
import { ProgramOffering } from './../../../shared/model/policy/program-offering.interface';
import { Intake } from './../../../shared/model/policy/intake.interface';
import {Component, Input, OnInit, ViewContainerRef} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar} from '@angular/material';

import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';


@Component({
  selector: 'pams-intake-process-detail',
  templateUrl: './intake-process-detail.page.html',
})

export class IntakeProcessDetailPage implements OnInit {
    

  private INTAKES = 'policyModuleState.intake'.split('.');
  private PROGRAM_OFFERINGS: string[] = 'policyModuleState.programOfferings'.split('.');
  private SUPERVISOR_OFFERINGS: string[] = 'policyModuleState.supervisorOfferings'.split('.');
  private STUDY_MODE_OFFERINGS: string[] = 'policyModuleState.studyModeOfferings'.split('.');
  private editorDialogRef: MdDialogRef<IntakeUpdaterDialog>;
  private intakes$: Observable<Intake[]>;
  private programOfferings$: Observable<ProgramOffering[]>;
  private supervisorOfferings$: Observable<SupervisorOffering[]>;
  private studyModeOfferings$: Observable<StudyModeOffering[]>;

  @Input() intake: Intake;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private viewContainerRef: ViewContainerRef,
              private actions: IntakeActions,
              private store: Store<PolicyModuleState>,
              private dialog: MdDialog,
              private snackBar: MdSnackBar) {
    this.intakes$ = this.store.select(...this.INTAKES);             
    this.programOfferings$ = this.store.select(...this.PROGRAM_OFFERINGS);
    this.supervisorOfferings$ = this.store.select(...this.SUPERVISOR_OFFERINGS);
    this.studyModeOfferings$ = this.store.select(...this.STUDY_MODE_OFFERINGS);
  }



  ngOnInit(): void {
    this.route.params.subscribe((params: { referenceNo: string }) => {
      let referenceNo: string = params.referenceNo;
      if (null != referenceNo)
        this.store.dispatch(this.actions.findIntakeByReferenceNo(referenceNo));
    });
  }

  remove(): void {
    if(confirm('Confirm remove this intake?')){
    this.store.dispatch(this.actions.removeIntake(this.intake));
    this.goBack();
 } 
    else {
   }
}

  edit(): void {
    console.log('edit');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.viewContainerRef;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '60%';
    config.position = {top: '0px'};
    this.editorDialogRef = this.dialog.open(IntakeUpdaterDialog, config);
    this.editorDialogRef.componentInstance.intake = this.intake;
    this.editorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
    });
  }

  goBack(): void {
    this.router.navigate(['/secure/policy/intakes']);
  }
}
