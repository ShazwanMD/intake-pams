import { Result } from './../../../shared/model/application/result.interface';
import { Referee } from './../../../shared/model/application/referee.interface';
import { Attachment } from './../../../shared/model/application/attachment.interface';
import { Candidate } from '../../../shared/model/admission/candidate.interface';
import { Employment } from '../../../shared/model/application/employment.interface';
import { IntakeApplication } from '../../../shared/model/application/intake-application.interface';
import { Language } from '../../../shared/model/application/language.interface';
import { ApplicationModuleState } from '../../application';
import { IntakeApplicationActions } from '../../application/intake-applications/intake-application.action';
import { IntakeActions } from '../../policy/intakes/intake.action';
import {Component, OnInit, ChangeDetectionStrategy, state, ViewContainerRef, Input} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs/Observable';
import {MdSnackBar, MdDialogRef, MdDialogConfig, MdDialog} from '@angular/material';
import { SupervisorOffering } from "../../../shared/model/policy/supervisor-offering.interface";
import { AdmissionActions } from "../../admission/admission.action";
import { AdmissionCandidateActions } from "../admission-candidate.action";
import { AdmissionCandidateModuleState } from "../index";

@Component({
  selector: 'pams-edit-supervisor',
  templateUrl: './edit-supervisor.dialog.html',
})

export class EditSupervisorDialog implements OnInit {
    
    private _candidate: Candidate;
    private rejectForm: FormGroup;

    constructor(private router: Router,
        private route: ActivatedRoute,
        private formBuilder: FormBuilder,
        private vcf: ViewContainerRef,
        private actions: AdmissionCandidateActions,
        private dialog: MdDialogRef<EditSupervisorDialog>,
        private snackBar: MdSnackBar,
        private store: Store<AdmissionCandidateModuleState>) {
    }
    
    set candidate(candidate: Candidate) {
        console.log('candidate.id :'+candidate.id);
        this._candidate = candidate;
      }
    
    ngOnInit(): void {
        console.log(this._candidate.programSelection.programFieldCode.programCode.programLevel);
        this.rejectForm = this.formBuilder.group(<Candidate>{
          id: null,
          supervisorOffering: <SupervisorOffering>{},
        });

        this.rejectForm.patchValue(this._candidate);
      }
    
    submit(candidate : Candidate) {
        this.store.dispatch(this.actions.updateCandidate(candidate));
        this.dialog.close();
        window.location.reload();
      }
}
