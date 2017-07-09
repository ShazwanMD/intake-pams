import {Injectable} from '@angular/core';
import {Response} from '@angular/http';
import {HttpInterceptorService} from '@covalent/http';
import {Observable} from 'rxjs/Observable';
import {environment} from '../environments/environment';
import {IntakeApplication} from '../app/shared/model/application/intake-application.interface';
import {Applicant} from '../app/identity/applicant.interface';

@Injectable()
export class AccountService {

  private account_api: string = environment.endpoint + '/api/account';

  constructor(private _http: HttpInterceptorService) {
  }

  findDraftedIntakeApplications(): Observable<IntakeApplication[]> {
    console.log('findDraftedIntakeApplications');
    return this._http.get(this.account_api + '/intakeApplications/bidStatus/DRAFTED')
      .map((res: Response) => <IntakeApplication[]>res.json());
  }

  findSubmittedIntakeApplications(): Observable<IntakeApplication[]> {
    console.log('findSubmittedIntakeApplications');
    return this._http.get(this.account_api + '/intakeApplications/bidStatus/SUBMITTED')
      .map((res: Response) => <IntakeApplication[]>res.json());
  }

  updateApplicant(applicant: Applicant): Observable<String> {
    console.log('updateApplicant');
    return this._http.post(this.account_api + '/applicant', JSON.stringify(applicant))
      .flatMap((res: Response) => Observable.of(res.text()));
  }
}
