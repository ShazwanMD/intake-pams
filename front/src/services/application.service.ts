import { DiplomaResult } from './../app/application/intake-applications/diploma-result-interface';
import { BachelorResult } from './../app/application/intake-applications/bachelor-result-interface';
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
import {StudyModeOffering} from "../app/policy/intakes/study-mode-offering.interface";
import {Language} from "../app/application/intake-applications/language.interface";
import {Attachment} from "../app/application/intake-applications/attachment.interface";


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
    return this.http.get(environment.endpoint + '/api/application/intakes/' + intake.referenceNo + '/programOfferings')
      .map((res: Response) => <ProgramOffering[]>res.json());
  }

  findStudyModeOfferingsByIntake(intake: Intake): Observable<StudyModeOffering[]> {
    return this.http.get(environment.endpoint + '/api/application/intakes/' + intake.referenceNo + '/studyModeOfferings')
      .map((res: Response) => <StudyModeOffering[]>res.json());
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
    console.log("researchTitle: " + application.researchTitle);
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

  findLanguagesByIntakeApplication(application: IntakeApplication): Observable<Language[]> {
    console.log("findLanguages");
    return this.http.get(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + "/languages")
      .map((res: Response) => <Language[]>res.json());
  }

  addLanguage(application: IntakeApplication, language: Language): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/languages', JSON.stringify(language), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  findAttachmentsByIntakeApplication(application: IntakeApplication): Observable<Attachment[]> {
    console.log("findAttachments");
    return this.http.get(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + "/attachments")
      .map((res: Response) => <Attachment[]>res.json());
  }

  addAttachment(application: IntakeApplication, file:File): Observable<String> {
    console.log("addAttachment");
    console.log("file: " + file.name);
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    let formData = new FormData();
    formData.append("file", file);
    return this.http.post(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/attachments', formData)
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

  updateReferee(application: IntakeApplication, referee: Referee): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/referees' + referee.id, JSON.stringify(referee), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

 deleteReferee(application: IntakeApplication, referee: Referee): Observable<String> {
    return this.http.delete(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/referees/' + referee.id)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  addSpmResult(application: IntakeApplication, spmResult: SpmResult): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/spmResults', JSON.stringify(spmResult), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  findSpmResultsByIntakeApplication(application: IntakeApplication): Observable<SpmResult[]> {
    console.log("findSpmResults");
    return this.http.get(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + "/spmResults")
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

  selectProgramOffering(application, offering):Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/programOfferingSelection', JSON.stringify(offering), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  selectStudyModeOffering(application, offering):Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/studyModeOfferingSelection', JSON.stringify(offering), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  findBachelorResultsByIntakeApplication(application: IntakeApplication): Observable<BachelorResult[]> {
    console.log("findBachelorResultsByIntakeApplication");
    return this.http.get(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + "/bachelorResults")
      .map((res: Response) => <BachelorResult[]>res.json());
  }

  addBachelorResult(application: IntakeApplication, bachelorResult: BachelorResult): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/bachelorResults', JSON.stringify(bachelorResult), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  findDiplomaResultsByIntakeApplication(application: IntakeApplication): Observable<DiplomaResult[]> {
    console.log("findDiplomaResultsByIntakeApplication");
    return this.http.get(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + "/diplomaResults")
      .map((res: Response) => <DiplomaResult[]>res.json());
  }

  addDiplomaResult(application: IntakeApplication, diplomaResult: DiplomaResult): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/diplomaResults', JSON.stringify(diplomaResult), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }



}
