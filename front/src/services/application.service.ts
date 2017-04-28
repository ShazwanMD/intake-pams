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
    console.log("findIntakeByReferenceNo");
    let encoded = referenceNo.replace(/\//g, '%252F');
    return this.http.get(environment.endpoint + '/api/application/intakes/' + encoded)
      .map((res: Response) => <Intake>res.json());
  }


  applyIntake(intake: Intake): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    let encoded = intake.referenceNo.replace(/\//g, '%252F');
    return this.http.post(environment.endpoint + '/api/application/intakes/' + encoded + '/apply', options)
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
    let encoded = referenceNo.replace(/\//g, '%252F');
    return this.http.get(environment.endpoint + '/api/application/intakeApplications/' + encoded)
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
    let encoded = application.referenceNo.replace(/\//g, '%252F');
    return this.http.post(environment.endpoint + '/api/application/intakeApplications/' + encoded + '/educations', JSON.stringify(education), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteEducation(application: IntakeApplication, education: Education): Observable<String> {
    let encoded = application.referenceNo.replace(/\//g, '%252F');
    return this.http.delete(environment.endpoint + '/api/application/intakeApplications/' + encoded + '/educations/' + education.id)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  addEmployment(application: IntakeApplication, employment: Employment): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    let encoded = application.referenceNo.replace(/\//g, '%252F');
    return this.http.post(environment.endpoint + '/api/application/intakeApplications/' + encoded + '/employments', JSON.stringify(employment), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteEmployment(application: IntakeApplication, employment: Employment): Observable<String> {
    let encoded = application.referenceNo.replace(/\//g, '%252F');
    return this.http.delete(environment.endpoint + '/api/application/intakeApplications/' + encoded + '/employments/' + employment.id)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  addAddress(application: IntakeApplication, address: Address): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    let encoded = application.referenceNo.replace(/\//g, '%252F');
    return this.http.post(environment.endpoint + '/api/application/intakeApplications/' + encoded + '/addresses', JSON.stringify(address), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteAddress(application: IntakeApplication, address: Address): Observable<String> {
    let encoded = application.referenceNo.replace(/\//g, '%252F');
    return this.http.delete(environment.endpoint + '/api/application/intakeApplications/' + encoded + '/addresses/' + address.id)
      .flatMap((res: Response) => Observable.of(res.text()));
  }
}
