import { AdmissionCandidateModuleState } from '..';
import { Candidate } from '../../../shared/model/admission/candidate.interface';
import { CandidateTask } from '../../../shared/model/admission/candidate-task.interface';
import { IntakeActions } from '../../policy/intakes/intake.action';
import {
  Component, OnInit, Input, ViewContainerRef,
} from '@angular/core';
import { MdSnackBar, MdDialogConfig, MdDialogRef, MdDialog } from '@angular/material';
import {Router, ActivatedRoute} from '@angular/router';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import { ReportActions } from '../../../shared/report/report.action';
import { AdmissionCandidateActions } from "../admission-candidate.action";
import { IntakeApplication } from "../../../shared/model/application/intake-application.interface";
import { ApplicationModuleState } from "../../application/index";
import { CandidateProfileRejectDialog } from '../../admission/dialog/candidate-profile-reject.dialog';
import { AdmissionActions } from '../../admission/admission.action';

@Component({
  selector: 'pams-candidate-draft-task',
  templateUrl: './candidate-draft-task.panel.html',
})
export class CandidateDraftTaskPanel implements OnInit {
  
  private editorDialogRef: MdDialogRef<CandidateProfileRejectDialog>;

  @Input() candidateTask: CandidateTask;

  
  private CANDIDATE_BY_ID: string[] = 'admissionCandidateModuleState.candidate'.split('.');
  
  private candidate$: Observable<Candidate>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private store: Store<AdmissionCandidateModuleState>,
              private snackBar: MdSnackBar,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private reportActions: ReportActions,
              private intakeActions: IntakeActions,
              private admissionActions: AdmissionActions,
              private actions: AdmissionCandidateActions) {
     
      this.candidate$ = this.store.select(...this.CANDIDATE_BY_ID);
  }

  ngOnInit(): void {
      console.log("candidateTask.candidate:" + this.candidateTask.candidateIntake.id);
      this.store.dispatch(
        this.actions.findCandidateById(this.candidateTask.candidateIntake.id
        ));
  }

  select(){
    if (confirm('Confirm to Approve This Candidate?')) {
      this.store.dispatch(this.actions.completeCandidateTask(this.candidateTask));
      this.goBack();
    } else {
      // return false;
    }
  }
  // reject(){
  //     this.store.dispatch(this.actions.removeCandidateTask(this.candidateTask));
  //     this.goBack();
  // }

// reject(): void {
//   console.log('rejectDialog');
//   let config = new MdDialogConfig();
//   config.viewContainerRef = this.vcf;
//   config.role = 'dialog';
//   config.width = '70%';
//   config.height = '65%';
//   config.position = {top: '0px'};
//   this.editorDialogRef = this.dialog.open(CandidateProfileRejectDialog, config);

//   // this.editorDialogRef.componentInstance.candidate = this.candidateTask;
//   this.editorDialogRef.afterClosed().subscribe((res) => {
//     console.log('close dialog');
//     // load something here
//   });
// }

reject(): void {
  console.log('edit');
  let config = new MdDialogConfig();
  config.viewContainerRef = this.vcf;
  config.role = 'dialog';
  config.width = '50%';
  config.height = '60%';
  config.position = {top: '0px'};
  this.editorDialogRef = this.dialog.open(CandidateProfileRejectDialog, config);
  //this.editorDialogRef.componentInstance.candidate = this.candidateTask.candidate;
  //this.editorDialogRef.componentInstance.intake = this.intakeTask.intake;
  this.editorDialogRef.afterClosed().subscribe((res) => {
    console.log('close dialog');
  });
}


  goBack(): void {
    this.router.navigate(['/secure/cps-candidate']);
    window.location.reload();
  }

}
