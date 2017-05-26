import {Referee} from './../app/application/intake-applications/referee.interface';
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
import {ProgramOffering} from "../app/policy/intakes/program-offering.interface";
import {SpmResult} from './../app/application/intake-applications/spm-result.interface';


@Injectable()
export class ApplicationService {

  constructor(private http: Http,
              private _http: HttpInterceptorService) {
  }

  // ====================================================================================================
  // INTAKE
  // ====================================================================================================

  findPublishedIntakes(): Observable<Intake[]> {
    console.log("findPublishedIntakes");
    return this.http.get(environment.endpoint + '/api/application/intakes/state/PUBLISHED')
      .map((res: Response) => <Intake[]>res.json());
  }

  findIntakes(): Observable<Intake[]> {
    console.log("findIntakes");
    return this.http.get(environment.endpoint + '/api/application/intakes')
      .map((res: Response) => <Intake[]>res.json());
  }

  findIntakeByReferenceNo(referenceNo: string): Observable<Intake> {
    console.log("findIntakeByReferenceNo : " + referenceNo);
    return this.http.get(environment.endpoint + '/api/application/intakes/' + referenceNo)
      .map((res: Response) => <Intake>res.json());
  }

  findProgramOfferingsByIntake(intake: Intake): Observable<ProgramOffering[]> {
    return this.http.get(environment.endpoint + '/api/policy/intakes/' + intake.referenceNo + '/programOfferings')
      .map((res: Response) => <ProgramOffering[]>res.json());
  }


  applyIntake(intake: Intake): Observable<IntakeApplication> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/application/intakes/' + intake.referenceNo + '/apply', options)
      .map((res: Response) => <IntakeApplication>res.json());
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
    return this.http.get(environment.endpoint + '/api/application/intakeApplication/' + referenceNo)
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

  updateIntakeApplication(application: IntakeApplication): Observable<String> {
    console.log("updateIntakeApplication ");
    console.log("email: " + application.email);
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo, JSON.stringify(application), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  findEducationsByIntakeApplication(application: IntakeApplication): Observable<Education[]> {
    console.log("findEducations");
    return this.http.get(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + "/educations")
      .map((res: Response) => <Education[]>res.json());
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

  findEmploymentsByIntakeApplication(application: IntakeApplication): Observable<Employment[]> {
    console.log("findEmployments");
    return this.http.get(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + "/employments")
      .map((res: Response) => <Employment[]>res.json());
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

  findRefereesByIntakeApplication(application: IntakeApplication): Observable<Referee[]> {
    console.log("findReferees");
    return this.http.get(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + "/referees")
      .map((res: Response) => <Referee[]>res.json());
  }

  addReferee(application: IntakeApplication, referee: Referee): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/referees', JSON.stringify(referee), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  findSpmResultsByIntakeApplication(application: IntakeApplication): Observable<SpmResult[]> {
    console.log("findResults");
    return this.http.get(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + "/employments")
      .map((res: Response) => <SpmResult[]>res.json());
  }

  deleteEmployment(application: IntakeApplication, employment: Employment): Observable<String> {
    return this.http.delete(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/employments/' + employment.id)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  findAddressesByIntakeApplication(application: IntakeApplication): Observable<Address[]> {
    console.log("findAddressesByIntakeApplication");
    return this.http.get(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + "/addresses")
      .map((res: Response) => <Address[]>res.json());
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

  findProgramOfferingsByIntakeApplication(application: IntakeApplication): Observable<ProgramOffering[]> {
    console.log("findProgramOfferingsByIntakeApplication " + application.referenceNo);
    return this.http.get(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/programOfferings')
      .map((res: Response) => <ProgramOffering[]>res.json());
  }
}
