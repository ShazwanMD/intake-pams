import { AdmissionModuleState } from '..';
import { Candidate } from '../../../shared/model/admission/candidate.interface';
import { IntakeApplication } from '../../../shared/model/application/intake-application.interface';
import { Intake } from '../../../shared/model/policy/intake.interface';
import { AdmissionActions } from '../admission.action';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {Store} from '@ngrx/store';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'pams-candidate-list',
  templateUrl: './candidate-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class CandidateListComponent {

  @Input() candidate: Candidate;
  @Input() intake: Intake;

  constructor(private store: Store<AdmissionModuleState>,
              private route: ActivatedRoute,
              private actions: AdmissionActions) {
  }

  ngOnInit(): void {
  }

  filter(): void {
  }
}
