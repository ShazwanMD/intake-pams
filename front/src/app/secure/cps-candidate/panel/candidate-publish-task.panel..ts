import { AdmissionCandidateModuleState } from '..';
import { Candidate } from '../../../shared/model/admission/candidate.interface';
import { CandidateTask } from '../../../shared/model/admission/candidate-task.interface';
import { IntakeActions } from '../../policy/intakes/intake.action';
import {
  Component, OnInit, Input, ViewContainerRef,
} from '@angular/core';
import { MdSnackBar, MdDialog, MdDialogRef, MdDialogConfig } from '@angular/material';
import {Router, ActivatedRoute} from '@angular/router';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import { ReportActions } from '../../../shared/report/report.action';
import { AdmissionCandidateActions } from "../admission-candidate.action";
import { IntakeApplication } from "../../../shared/model/application/intake-application.interface";
import { ApplicationModuleState } from "../../application/index";
import { EditSupervisorDialog } from "../dialog/edit-supervisor.dialog";

@Component({
  selector: 'pams-candidate-publish-task',
  templateUrl: './candidate-publish-task.panel.html',
})
export class CandidatePublishTaskPanel implements OnInit {
  
  @Input() candidateTask: CandidateTask;
  
  private CANDIDATE_BY_ID: string[] = 'admissionCandidateModuleState.candidate'.split('.');
  
  private candidate$: Observable<Candidate>;
  private editorDialogRef: MdDialogRef<EditSupervisorDialog>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private store: Store<AdmissionCandidateModuleState>,
              private snackBar: MdSnackBar,
              private reportActions: ReportActions,
              private intakeActions: IntakeActions,
              private dialog: MdDialog,
              private vcf: ViewContainerRef,
              private actions: AdmissionCandidateActions) {
     
      this.candidate$ = this.store.select(...this.CANDIDATE_BY_ID);
  }

  ngOnInit(): void {
      console.log("candidateTask.candidate" + this.candidateTask.candidateIntake.id);
      this.store.dispatch(this.actions.findCandidateById(this.candidateTask.candidateIntake.id));
  }

  select(){
    if (confirm('Confirm to Register This Candidate?')) {
      this.store.dispatch(this.actions.completeCandidateTask(this.candidateTask));
      this.goBack();
    } else {
      // return false;
    }
  }
  
  reject(){
      this.store.dispatch(this.actions.removeCandidateTask(this.candidateTask));
      this.goBack();
  }

  goBack(): void {
    this.router.navigate(['/secure/cps-candidate']);
    window.location.reload();
  }
  
  editSupervisor(candidate): void {
      let config = new MdDialogConfig();
      config.viewContainerRef = this.vcf;
      config.role = 'dialog';
      config.width = '50%';
      config.height = '40%';
      config.position = {top: '0px'};
      this.editorDialogRef = this.dialog.open(EditSupervisorDialog, config);
      this.editorDialogRef.componentInstance.candidate = candidate;
      
/*      this.editorDialogRef.afterClosed().subscribe((res) => {
       this.route.params.subscribe((params: { taskId: string }) => {
        let taskId: string = params.taskId;
        console.log('intake: ' + taskId);
        this.store.dispatch(this.actions.findCandidateById(taskId));
      });
      });*/
    }

}
