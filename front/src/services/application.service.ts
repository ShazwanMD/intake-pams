import {Injectable} from '@angular/core';
import {Response, Http, Headers, RequestOptions} from '@angular/http';
import {HttpInterceptorService} from '@covalent/http';
import {IntakeApplication} from "../app/application/intake-applications/intake-application.interface";
import {Observable} from "rxjs/Observable";
import {environment} from "../environments/environment";
import {Education} from "../app/application/intake-applications/education.interface";
import {Employment} from "../app/application/intake-applications/employment.interface";
import {Address} from "../app/application/intake-applications/address.interface";
import {Intake} from "../app/policy/intakes/intake.interface";

@Injectable()
export class ApplicationService {

  constructor(private http: Http,
              private _http: HttpInterceptorService) {
  }

  // ====================================================================================================
  // INTAKE
  // ====================================================================================================

  // published intake
  findIntakes(): Observable<Intake[]> {
    console.log("findIntakes");
    return this.http.get(environment.endpoint + '/api/application/intakes')
      .map((res: Response) => <Intake[]>res.json());
  }

  findIntakeByReferenceNo(referenceNo:string): Observable<Intake> {
    console.log("findIntakeByReferenceNo : "+referenceNo);
    return this.http.get(environment.endpoint + '/api/application/intakes/' + referenceNo)
      .map((res: Response) => <Intake>res.json());
  }


  applyIntake(intake: Intake): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/application/intakes/' + intake.referenceNo + '/apply', options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // INTAKE APPLICATION
  // ====================================================================================================

  findIntakeApplications(): Observable<IntakeApplication[]> {
    console.log("findIntakeApplications");
    return this.http.get(environment.endpoint + '/api/application/intakeApplications')
      .map((res: Response) => <IntakeApplication[]>res.json());
  }

  findIntakeApplicationByReferenceNo(referenceNo: string): Observable<IntakeApplication> {
    return this.http.get(environment.endpoint + '/api/application/intakeApplications/' + referenceNo)
      .map((res: Response) => <IntakeApplication>res.json());
  }

  submitIntakeApplication(application: IntakeApplication): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/application/intakeApplications/'
      + application.referenceNo + '/submit', JSON.stringify(application), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateIntakeApplication(application: IntakeApplication): Observable<Boolean> {
    return this.http.put(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo, JSON.stringify(application))
      .flatMap(data => Observable.of(true));
  }

  addEducation(application: IntakeApplication, education: Education): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/educations', JSON.stringify(education), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteEducation(application: IntakeApplication, education: Education): Observable<String> {
    return this.http.delete(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/educations/' + education.id)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  addEmployment(application: IntakeApplication, employment: Employment): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/employments', JSON.stringify(employment), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteEmployment(application: IntakeApplication, employment: Employment): Observable<String> {
    return this.http.delete(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/employments/' + employment.id)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  addAddress(application: IntakeApplication, address: Address): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/addresses', JSON.stringify(address), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteAddress(application: IntakeApplication, address: Address): Observable<String> {
    return this.http.delete(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/addresses/' + address.id)
      .flatMap((res: Response) => Observable.of(res.text()));
  }
}
