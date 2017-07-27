import { AdmissionModuleState } from '..';
import { Candidate } from '../../../shared/model/admission/candidate.interface';
import { IntakeApplication } from '../../../shared/model/application/intake-application.interface';
import { Intake } from '../../../shared/model/policy/intake.interface';
import { AdmissionActions } from '../admission.action';
import { CandidateProfilePreSelectDialog } from '../dialog/candidate-profile-pre-select.dialog';
import { CandidateProfileRegisterDialog } from '../dialog/candidate-profile-register.dialog';
import { CandidateProfileSelectDialog } from '../dialog/candidate-profile-select.dialog';
import { CandidateProfileDialog } from '../dialog/candidate-profile.dialog';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import { MdDialogConfig, MdDialogRef, MdDialog } from '@angular/material';
import {Store} from '@ngrx/store';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'pams-candidate-accept-list',
  templateUrl: './candidate-accept-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class CandidateAcceptListComponent {

  @Input() candidate: Candidate;
  @Input() intake: Intake;
  
  private editorDialogRef: MdDialogRef<CandidateProfileRegisterDialog>;

  constructor(private store: Store<AdmissionModuleState>,
              private route: ActivatedRoute,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private actions: AdmissionActions) {
  }
  
  profileDialog(candidate : Candidate) {
    console.log('candidate :' + candidate.identityNo);
    this.showDialog(candidate);
  }

  showDialog(candidate): void {
    console.log('showDialog');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '90%';
    config.height = '90%';
    config.position = {top: '0px'};
    this.editorDialogRef = this.dialog.open(CandidateProfileRegisterDialog, config);
    this.editorDialogRef.componentInstance.candidate = candidate;
  }

  ngOnInit(): void {
  }

  filter(): void {
  }
}
