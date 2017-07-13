import { Applicant } from './../../../administrator/identity/applicant.interface';
import { Observable } from 'rxjs/Observable';

import {Component, Input, ChangeDetectionStrategy} from '@angular/core';


@Component({
  selector: 'pams-applicant',
  templateUrl: './applicant.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ApplicantComponent {
 @Input() applicant: Applicant;
//   private applicant$: Observable<Applicant>;
}
