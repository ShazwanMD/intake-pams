import { Candidate } from '../../shared/model/admission/candidate.interface';
import {
  Component, OnInit, Input,
} from '@angular/core';
import { MdSnackBar } from '@angular/material';
import {Router, ActivatedRoute} from '@angular/router';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {AdmissionCandidateModuleState} from './index';
import { AdmissionCandidateActions } from "./admission-candidate.action";
import { IntakeApplication } from "../../shared/model/application/intake-application.interface";
import { ApplicationModuleState } from "../application/index";
import { IntakeApplicationActions } from "../application/intake-applications/intake-application.action";
import { CandidateTask } from "../../shared/model/admission/candidate-task.interface";

@Component({
  selector: 'pams-candidate-view-detail',
  templateUrl: './candidate-view-detail.page.html',
})
export class CandidateDetailPage implements OnInit {
  
  private CANDIDATE: string[] = 'admissionCandidateModuleState.candidate'.split('.');
  private INTAKE_APPLICATION: string[] = 'applicationModuleState.intakeApplication'.split('.');
  
  private candidate$: Observable<Candidate[]>;
  private intakeApplication$: Observable<IntakeApplication>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private store: Store<AdmissionCandidateModuleState>,
              private stores: Store<ApplicationModuleState>,
              private snackBar: MdSnackBar,
              private action: IntakeApplicationActions,
              private actions: AdmissionCandidateActions) {
     
      this.candidate$ = this.store.select(...this.CANDIDATE);
      this.intakeApplication$ = this.stores.select(...this.INTAKE_APPLICATION);
  }

  ngOnInit(): void {
      this.route.params.subscribe((params: { referenceNo: string }) => {
        let referenceNo: string = params.referenceNo;
        this.store.dispatch(this.actions.findCandidateByReferenceNo(referenceNo));
        //this.stores.dispatch(this.action.findIntakeApplicationByCandidate(referenceNo));
        console.log('ref No', referenceNo);
      });
      
      
    }


}
