import {Injectable} from '@angular/core';
import {Response, Http, Headers, RequestOptions} from '@angular/http';
import {HttpInterceptorService} from '@covalent/http';
import {Observable} from 'rxjs/Observable';
import {environment} from '../environments/environment';
import {AuthenticationService} from './authentication.service';
import {IntakeApplication} from '../app/shared/model/application/intake-application.interface';
import {Applicant} from '../app/identity/applicant.interface';
import {Intake} from '../app/shared/model/policy/intake.interface';

@Injectable()
export class AccountService {

  constructor(private http: Http,
              private _http: HttpInterceptorService,
              private authnService: AuthenticationService) {
  }

  findPublishedIntakes(): Observable<Intake[]> {
    console.log('findPublishedIntakes');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/account/intake/flowState/PUBLISHED  ', options)
      .map((res: Response) => <Intake[]>res.json());
  }

  findDraftedIntakeApplications(): Observable<IntakeApplication[]> {
    console.log('findDraftedIntakeApplications');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/account/intakeApplications/bidStatus/DRAFTED', options)
      .map((res: Response) => <IntakeApplication[]>res.json());
  }

  findSubmittedIntakeApplications(): Observable<IntakeApplication[]> {
    console.log('findSubmittedIntakeApplications');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/account/intakeApplications/bidStatus/SUBMITTED', options)
      .map((res: Response) => <IntakeApplication[]>res.json());
  }

  updateApplicant(applicant: Applicant): Observable<String> {
    console.log('updateApplicant');
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/account/applicant', JSON.stringify(applicant), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }
}
