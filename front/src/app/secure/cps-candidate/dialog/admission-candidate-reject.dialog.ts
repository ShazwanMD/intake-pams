import { Candidate } from '../../../shared/model/admission/candidate.interface';
import {Component, OnInit, ChangeDetectionStrategy, state, ViewContainerRef, Input} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import {MdSnackBar, MdDialogRef, MdDialogConfig} from '@angular/material';
import { AdmissionCandidateActions } from '../../cps-candidate/admission-candidate.action';
import { Observable } from '../../../../../node_modules/rxjs';
import { AdmissionCandidateModuleState } from '../../cps-candidate';
import { AdmissionActions } from '../../admission/admission.action';
import { CandidateTask } from '../../../shared/model/admission/candidate-task.interface';

@Component({
  selector: 'pams-admission-candidate-reject',
  templateUrl: './admission-candidate-reject.dialog.html',
})

export class AdmissionCandidateRejectDialog implements OnInit {

 private CANDIDATE_BY_ID: string[] = 'admissionCandidateModuleState.candidate'.split('.');
  private _candidate: Candidate;
  private _candidateTask : CandidateTask;
  
  private rejectForm: FormGroup;

  private candidate$: Observable<Candidate>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private vcf: ViewContainerRef,
              private dialog: MdDialogRef<AdmissionCandidateRejectDialog>,
              private snackBar: MdSnackBar,
              private actions: AdmissionActions,
              private action: AdmissionCandidateActions,
              private store: Store<AdmissionCandidateModuleState>) {
              this.candidate$ = this.store.select(...this.CANDIDATE_BY_ID);
  }

  set candidate(candidate: Candidate) {
    console.log('candidate.id :'+candidate.id);
    this._candidate = candidate;
  }

  ngOnInit(): void {
    this.rejectForm = this.formBuilder.group(<Candidate>{
      id: null,
      reason: '',
    });
    this.rejectForm.patchValue(this._candidate);
  }

  submit(candidate : Candidate) {
    
    if(confirm('Confirm to Reject This candidate?')){
      console.log("reject this candidate : "+candidate.id);
    this.store.dispatch(this.actions.rejectCandidate(candidate));
    //this.store.dispatch(this.action.removeCandidateTask(this._candidateTask));
      this.dialog.close();
     // window.location.reload();
    }else {
    }
  }
}
