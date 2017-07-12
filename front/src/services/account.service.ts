import {Injectable} from '@angular/core';
import {Response} from '@angular/http';
import {HttpInterceptorService} from '@covalent/http';
import {Observable} from 'rxjs/Observable';
import {environment} from '../environments/environment';
import {IntakeApplication} from '../app/shared/model/application/intake-application.interface';
import {Applicant} from '../app/identity/applicant.interface';
import {Intake} from '../app/shared/model/policy/intake.interface';

@Injectable()
export class AccountService {

  private ACCOUNT_API: string = environment.endpoint + '/api/account';

  constructor(private _http: HttpInterceptorService) {
  }

  findPublishedIntakes(): Observable<Intake[]> {
    console.log('findPublishedIntakes');
    return this._http.get(this.ACCOUNT_API + '/intakes/flowState/PUBLISHED  ')
      .map((res: Response) => <Intake[]>res.json());
  }

  findIntakeApplications(): Observable<IntakeApplication[]> {
    console.log('findIntakeApplications');
    return this._http.get(this.ACCOUNT_API + '/intakeApplications')
      .map((res: Response) => <IntakeApplication[]>res.json());
  }

  findDraftedIntakeApplications(): Observable<IntakeApplication[]> {
    console.log('findDraftedIntakeApplications');
    return this._http.get(this.ACCOUNT_API + '/intakeApplications/bidStatus/DRAFTED')
      .map((res: Response) => <IntakeApplication[]>res.json());
  }

  findSubmittedIntakeApplications(): Observable<IntakeApplication[]> {
    console.log('findSubmittedIntakeApplications');
    return this._http.get(this.ACCOUNT_API + '/intakeApplications/bidStatus/SUBMITTED')
      .map((res: Response) => <IntakeApplication[]>res.json());
  }

  updateApplicant(applicant: Applicant): Observable<String> {
    console.log('updateApplicant');
    return this._http.post(this.ACCOUNT_API + '/applicant', JSON.stringify(applicant))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  findApplicant(): Observable<Applicant> {
    console.log('findApplicant');
    return this._http.get(this.ACCOUNT_API + '/applicant')
      .map((res: Response) => <Applicant>res.json());
  }

}
