import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {Intake} from '../../../../shared/model/policy/intake.interface';
import {IntakeActions} from '../intake.action';
import {PolicyModuleState} from '../../index';
import {Store} from '@ngrx/store';

import {ActivatedRoute} from '@angular/router';
import {IntakeApplication} from '../../../../shared/model/application/intake-application.interface';
import {MdDialogConfig, MdDialogRef, MdDialog} from '@angular/material';
import {ApplicantProfileDialog} from '../dialog/applicant-profile.dialog';

@Component({
  selector: 'pams-intake-application-evaluate-list',
  templateUrl: './intake-application-evaluate-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class IntakeApplicationEvaluateListComponent {

  @Input() intake: Intake;
  @Input() intakeApplications: IntakeApplication;
  private editorDialogRef: MdDialogRef<ApplicantProfileDialog>;

  constructor(private store: Store<PolicyModuleState>,
              private route: ActivatedRoute,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private actions: IntakeActions) {
  }

  ngOnInit(): void {
  }

  filter(): void {
  }

  profileDialog(intakeApplication) {
    console.log('intakeApplication :' + intakeApplication);
    this.showDialog(intakeApplication);
  }

  showDialog(intakeApplication: IntakeApplication): void {
    console.log('showDialog');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '90%';
    config.height = '90%';
    config.position = {top: '0px'};
    this.editorDialogRef = this.dialog.open(ApplicantProfileDialog, config);
    this.editorDialogRef.componentInstance.intakeApplication = intakeApplication;

    /*this.editorDialogRef.afterClosed().subscribe(res => {
     console.log("closeDialog");
     // reload program offerings
     this.store.dispatch(this.actions.findProgramOfferings(this.intake));
     });*/
  }
}
