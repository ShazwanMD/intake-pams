import {Injectable} from '@angular/core';
import {Response} from '@angular/http';
import {HttpInterceptorService} from '@covalent/http';
import {Observable} from 'rxjs/Observable';
import {environment} from '../environments/environment';
import {IntakeApplication} from '../app/shared/model/application/intake-application.interface';
import {Applicant} from '../app/secure/identity/applicant.interface';
import {Intake} from '../app/shared/model/policy/intake.interface';
import {User} from '../app/secure/identity/user.interface';
import {PasswordChange} from "../app/shared/model/identity/password-change.interface";
import { EmailChange } from "../app/shared/model/identity/email-change.interface";

@Injectable()
export class AccountService {

  private ACCOUNT_API: string = environment.endpoint + '/api/account';

  constructor(private _http: HttpInterceptorService) {
  }

  findPublishedIntakes(): Observable<Intake[]> {
    console.log('findPublishedIntakes');
    return this._http.get(this.ACCOUNT_API + '/intakes/flowState/PUBLISHED  ')
      .map((res: Response) => <Intake[]>res.json())
      .catch((error) => this.handleError(error));
  }

  findIntakeApplications(): Observable<IntakeApplication[]> {
    console.log('findIntakeApplications');
    return this._http.get(this.ACCOUNT_API + '/intakeApplications')
      .map((res: Response) => <IntakeApplication[]>res.json())
      .catch((error) => this.handleError(error));
  }

  findDraftedIntakeApplications(): Observable<IntakeApplication[]> {
    console.log('findDraftedIntakeApplications');
    return this._http.get(this.ACCOUNT_API + '/intakeApplications/bidStatus/DRAFTED')
      .map((res: Response) => <IntakeApplication[]>res.json())
      .catch((error) => this.handleError(error));
  }

  findSubmittedIntakeApplications(): Observable<IntakeApplication[]> {
    console.log('findSubmittedIntakeApplications');
    return this._http.get(this.ACCOUNT_API + '/intakeApplications/bidStatus/SUBMITTED')
      .map((res: Response) => <IntakeApplication[]>res.json())
      .catch((error) => this.handleError(error));
  }

  updateApplicant(applicant: Applicant): Observable<String> {
    console.log('updateApplicant');
    return this._http.post(this.ACCOUNT_API + '/applicant', JSON.stringify(applicant))
      .flatMap((res: Response) => Observable.of(res.text()))
      .catch((error) => this.handleError(error));
  }

  findApplicant(): Observable<Applicant> {
    console.log('findApplicant');
    return this._http.get(this.ACCOUNT_API + '/applicant')
      .map((res: Response) => <Applicant>res.json())
      .catch((error) => this.handleError(error));
  }

  findUser(): Observable<User[]> {
    console.log('findUser');
    return this._http.get(this.ACCOUNT_API + '/user')
      .map((res: Response) => <User[]>res.json())
      .catch((error) => this.handleError(error));
  }

  saveUser(user: User): Observable<String> {
    return this._http.post(this.ACCOUNT_API + '/user', JSON.stringify(user))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateUser(user: User): Observable<String> {
    return this._http.put(this.ACCOUNT_API + '/updateUser', JSON.stringify(user))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  changeUserPassword(change: PasswordChange): Observable<String> {
    return this._http.post(this.ACCOUNT_API + '/passwordChange', JSON.stringify(change))
      .flatMap((res: Response) => Observable.of(res.text()))
      .catch((error) => this.handleError(error));
  }

  changeApplicantEmail(change: EmailChange): Observable<String> {
    console.log('EmailChange: ', change);
    return this._http.post(this.ACCOUNT_API + '/emailChange/' + change.currentEmail, JSON.stringify(change))
      .map((res: Response) => <String>res.text());
  }

  // ====================================================================================================
  // PRIVATE METHODS
  // ====================================================================================================

  private handleError(error: Response | any) {
    let body: any = error.json();
    return Observable.throw(body);
  }
}

