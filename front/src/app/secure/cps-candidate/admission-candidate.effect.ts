import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {AdmissionCandidateActions} from './admission-candidate.action';
import {AdmissionService} from '../../../services/admission.service';
import {from} from 'rxjs/observable/from';

@Injectable()
export class AdmissionCandidateEffects {

  private INTAKE_TASKS: string[] = 'admissionModuleState.intakeTasks'.split('.');
  private CANDIDATES: string[] = 'admissionModuleState.candidates'.split('.');

  constructor(private actions$: Actions,
              private admissionActions: AdmissionCandidateActions,
              private admissionService: AdmissionService) {
  }
}
