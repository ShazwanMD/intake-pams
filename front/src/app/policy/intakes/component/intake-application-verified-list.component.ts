import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {Intake} from "../intake.interface";
import {IntakeActions} from "../intake.action";
import {PolicyModuleState} from "../../index";
import {Store} from "@ngrx/store";

import {ActivatedRoute} from "@angular/router";
import {IntakeApplication} from "../../../application/intake-applications/intake-application.interface";
import { MdDialogConfig, MdDialogRef, MdDialog } from "@angular/material";
import { ApplicantProfileDialog } from "../dialog/applicant-profile.dialog";
import { ApplicantProfileVerifyDialog } from "../dialog/applicant-profile-verify.dialog";

@Component({
  selector: 'pams-intake-application-verified-list',
  templateUrl: './intake-application-verified-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class IntakeApplicationVerifiedListComponent {

  @Input() intake: Intake;
  @Input() intakeVerifiedApplications: IntakeApplication;
  private editorDialogRef: MdDialogRef<ApplicantProfileVerifyDialog>;

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
      console.log("intakeApplication :" + intakeApplication);
      this.showDialog(intakeApplication);
  }
  
  showDialog(intakeApplication : IntakeApplication): void {
      console.log("showDialog");
      let config = new MdDialogConfig();
      config.viewContainerRef = this.vcf;
      config.role = 'dialog';
      config.width = '90%';
      config.height = '90%';
      config.position = {top: '0px'};
      this.editorDialogRef = this.dialog.open(ApplicantProfileVerifyDialog, config);
      this.editorDialogRef.componentInstance.intakeApplication = intakeApplication;
  }
}
