import {
  Component, OnInit, Input,
} from '@angular/core';
import { MdSnackBar } from '@angular/material';
import {Router, ActivatedRoute} from '@angular/router';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import { AdmissionCandidateActions } from "./admission-candidate.action";
import { Candidate } from "../../shared/model/admission/candidate.interface";
import {AdmissionCandidateModuleState} from './index';
import { IntakeApplication } from "../../shared/model/application/intake-application.interface";
import { ApplicationModuleState } from "../application/index";
import { IntakeApplicationActions } from "../application/intake-applications/intake-application.action";

@Component({
  selector: 'pams-admission-candidate-detail',
  templateUrl: './admission-candidate-detail.page.html',
})
export class AdmissionCandidateDetailPage implements OnInit {
  
  private CANDIDATE: string[] = 'admissionCandidateModuleState.candidate'.split('.');
  
  private candidate$: Observable<Candidate>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private store: Store<AdmissionCandidateModuleState>,
              private stores: Store<ApplicationModuleState>,
              private snackBar: MdSnackBar,
              private actions: AdmissionCandidateActions,
              private action: IntakeApplicationActions) {
     
      this.candidate$ = this.store.select(...this.CANDIDATE);
  }

  ngOnInit(): void {
      this.route.params.subscribe((params: { referenceNo: string }) => {
          let referenceNo: string = params.referenceNo;
          this.store.dispatch(this.actions.findCandidateByReferenceNo(referenceNo));
        });
  }

  select(){
      //this.store.dispatch(this.actions.completeCandidateTask(this.candidateTask));
      this.goBack();
  }

  goBack(): void {
    this.router.navigate(['/secure/cps-candidate']);
    window.location.reload();
  }

}
