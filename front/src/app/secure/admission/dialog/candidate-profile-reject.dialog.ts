import { Candidate } from '../../../shared/model/admission/candidate.interface';
import { IntakeApplication } from '../../../shared/model/application/intake-application.interface';
import { ApplicationModuleState } from '../../application';
import { IntakeApplicationActions } from '../../application/intake-applications/intake-application.action';
import { AdmissionActions } from '../admission.action';
import {Component, OnInit, ChangeDetectionStrategy, state, ViewContainerRef, Input} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import {MdSnackBar, MdDialogRef, MdDialogConfig} from '@angular/material';

@Component({
  selector: 'pams-candidate-profile-reject',
  templateUrl: './candidate-profile-reject.dialog.html',
})

export class CandidateProfileRejectDialog implements OnInit {

  private rejectForm: FormGroup;
  private _candidate: Candidate;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private vcf: ViewContainerRef,
              private actions: AdmissionActions,
              private dialog: MdDialogRef<CandidateProfileRejectDialog>,
              private snackBar: MdSnackBar,
              private store: Store<ApplicationModuleState>) {
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
    console.log("submit candidate : "+candidate.id);
    let snackBarRef = this.snackBar.open('Confirm to Reject This candidate?', 'Ok');

    snackBarRef.afterDismissed().subscribe(() => {
      console.log("submit candidate in snck bar: "+candidate.id);
      this.store.dispatch(this.actions.rejectCandidate(this._candidate));
      this.dialog.close();
    });
  }

}
