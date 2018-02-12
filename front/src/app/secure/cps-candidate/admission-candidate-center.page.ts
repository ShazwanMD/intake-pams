import { Intake } from './../../shared/model/policy/intake.interface';
import { IntakeActions } from './../policy/intakes/intake.action';
import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import {AdmissionCandidateModuleState} from './index';
import {Observable} from 'rxjs/Observable';
import {IntakeTask} from '../../shared/model/policy/intake-task.interface';
import { CandidateTask } from '../../shared/model/admission/candidate-task.interface';

@Component({
  selector: 'pams-admission-candidate-center.page',
  templateUrl: './admission-candidate-center.page.html',
})

export class AdmissionCandidateCenterPage{

}
