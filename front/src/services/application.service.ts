import { Result } from './../app/application/intake-applications/result.interface';
import {Attachment} from './../app/application/intake-applications/attachment.interface';
import {Referee} from './../app/application/intake-applications/referee.interface';
import {Injectable} from '@angular/core';
import {Response, Http, Headers, RequestOptions, ResponseContentType} from '@angular/http';
import {HttpInterceptorService} from '@covalent/http';
import {IntakeApplication} from "../app/application/intake-applications/intake-application.interface";
import {Observable} from "rxjs/Observable";
import {environment} from "../environments/environment";
import {Education} from "../app/application/intake-applications/education.interface";
import {Employment} from "../app/application/intake-applications/employment.interface";
import {Intake} from "../app/policy/intakes/intake.interface";
import {ProgramOffering} from "../app/policy/intakes/program-offering.interface";
import {StudyModeOffering} from "../app/policy/intakes/study-mode-offering.interface";
import {Language} from "../app/application/intake-applications/language.interface";
import {SupervisorOffering} from "../app/policy/intakes/supervisor-offering.interface";
import {AttachmentType} from "../app/application/intake-applications/attachment-type.enum";



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

  findSupervisorOfferingsByIntake(intake: Intake): Observable<SupervisorOffering[]> {
    return this.http.get(environment.endpoint + '/api/application/intakes/' + intake.referenceNo + '/supervisorOfferings')
      .map((res: Response) => <SupervisorOffering[]>res.json());
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
    let options = new RequestOptions({ headers: headers });
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
    let options = new RequestOptions({ headers: headers });
    return this.http.post(environment.endpoint + '/api/application/intakeApplications/'
      + application.referenceNo + '/submit', JSON.stringify(application), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }
  
  selectIntakeApplication(application: IntakeApplication): Observable<String> {
      let headers = new Headers({
        'Content-Type': 'application/json',
        //'Authorization': 'Bearer ' + this.authService.token
      });
      let options = new RequestOptions({ headers: headers });
      return this.http.post(environment.endpoint + '/api/application/intakeApplications/'
        + application.referenceNo + '/select', JSON.stringify(application), options)
        .flatMap((res: Response) => Observable.of(res.text()));
  }
  
  rejectIntakeApplication(application: IntakeApplication): Observable<String> {
      let headers = new Headers({
        'Content-Type': 'application/json',
        //'Authorization': 'Bearer ' + this.authService.token
      });
      let options = new RequestOptions({ headers: headers });
      return this.http.post(environment.endpoint + '/api/application/intakeApplications/'
        + application.referenceNo + '/reject', JSON.stringify(application), options)
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
    let options = new RequestOptions({ headers: headers });
    return this.http.put(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo, JSON.stringify(application), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }
  
  findSubmittedIntakeApplications(intake: Intake): Observable<IntakeApplication[]> {
      console.log("findSubmittedIntakeApplications "+intake.referenceNo);
      return this.http.get(environment.endpoint + '/api/application/intakes/' + intake.referenceNo + "/intakeApplications/bidStatus/SUBMITTED")
        .map((res: Response) => <IntakeApplication[]>res.json());
    }
  
    findRejectedIntakeApplications(intake: Intake): Observable<IntakeApplication[]> {
      console.log("findIntakeApplications");
      return this.http.get(environment.endpoint + '/api/application/intakes/' + intake.referenceNo + "/intakeApplications/bidStatus/REJECTED")
        .map((res: Response) => <IntakeApplication[]>res.json());
    }
    findSelectedIntakeApplications(intake: Intake): Observable<IntakeApplication[]> {
      console.log("findIntakeApplications");
      return this.http.get(environment.endpoint + '/api/application/intakes/' + intake.referenceNo + "/intakeApplications/bidStatus/SELECTED")
        .map((res: Response) => <IntakeApplication[]>res.json());
    }

  // ====================================================================================================
  // EDUCATION
  // ==================================================================================================== 

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
    let options = new RequestOptions({ headers: headers });
    return this.http.post(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/educations', JSON.stringify(education), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteEducation(application: IntakeApplication, education: Education): Observable<String> {
    return this.http.delete(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/educations/' + education.id)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // EMPLOYMENT
  // ====================================================================================================   

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
    let options = new RequestOptions({ headers: headers });
    return this.http.post(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/employments', JSON.stringify(employment), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateEmployment(application: IntakeApplication, employment: Employment): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({ headers: headers });
    return this.http.put(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/employments/' + employment.id, JSON.stringify(employment), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteEmployment(application: IntakeApplication, employment: Employment): Observable<String> {
    return this.http.delete(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/employments/' + employment.id)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // LANGUAGE
  // ====================================================================================================   

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
    let options = new RequestOptions({ headers: headers });
    return this.http.post(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/languages', JSON.stringify(language), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateLanguage(application: IntakeApplication, language: Language): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({ headers: headers });
    return this.http.put(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/languages/' + language.id, JSON.stringify(language), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteLanguage(application: IntakeApplication, language: Language): Observable<String> {
    return this.http.delete(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/languages/' + language.id)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // ATTACHMENT
  // ====================================================================================================   

  findAttachmentsByIntakeApplication(application: IntakeApplication): Observable<Attachment[]> {
    console.log("findAttachments");
    return this.http.get(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + "/attachments")
      .map((res: Response) => <Attachment[]>res.json());
  }
  
  downloadAttachment(attachment: Attachment): Observable<Blob> {
      console.log('downloadAttachment');
      let options = new RequestOptions({responseType: ResponseContentType.ArrayBuffer});
      return this.http.get(environment.endpoint + '/api/application/intakeApplications/download/attachment/' + attachment.id, options)
        .map((res: Response) => new Blob([res.arrayBuffer()], {type: 'application/pdf'}));
    }

  addAttachment(application: IntakeApplication, file: File, attachmentType: AttachmentType): Observable<String> {
    console.log("addAttachment");
    console.log("file: " + file.name);
    console.log("attachmentType: " + attachmentType);
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({ headers: headers });
    let formData = new FormData();
    formData.append("attachmentType", attachmentType.toString())
    formData.append("file", file)
    return this.http.post(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/attachments', formData)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // REFEREE
  // ====================================================================================================   

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
    let options = new RequestOptions({ headers: headers });
    return this.http.post(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/referees', JSON.stringify(referee), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateReferee(application: IntakeApplication, referee: Referee): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({ headers: headers });
    return this.http.put(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/referees/' + referee.id, JSON.stringify(referee), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteReferee(application: IntakeApplication, referee: Referee): Observable<String> {
    return this.http.delete(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/referees/' + referee.id)
      .flatMap((res: Response) => Observable.of(res.text()));
  }


  // ====================================================================================================
  // RESULT
  // ====================================================================================================   

  findResultsByIntakeApplication(application: IntakeApplication): Observable<Result[]> {
    console.log("findSpmResults");
    return this.http.get(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + "/results")
      .map((res: Response) => <Result[]>res.json());
  }

  addResult(application: IntakeApplication, result: Result): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({ headers: headers });
    return this.http.post(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/results', JSON.stringify(result), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateResult(application: IntakeApplication, result: Result): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({ headers: headers });
    return this.http.put(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/results/' + result.id, JSON.stringify(result), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteResult(application: IntakeApplication, result: Result): Observable<String> {
    return this.http.delete(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/results/' + result.id)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // SELECT
  // ==================================================================================================== 

  selectProgramOffering(application, offering): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({ headers: headers });
    return this.http.post(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/programOfferingSelection', JSON.stringify(offering), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  selectSupervisorOffering(application, offering): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({ headers: headers });
    return this.http.post(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/supervisorOfferingSelection', JSON.stringify(offering), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  selectStudyModeOffering(application, offering): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({ headers: headers });
    return this.http.post(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/studyModeOfferingSelection', JSON.stringify(offering), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }


}
