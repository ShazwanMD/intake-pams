import {Result} from '../app/secure/applicant/application/intake-applications/result.interface';
import {Attachment} from '../app/secure/applicant/application/intake-applications/attachment.interface';
import {Referee} from '../app/secure/applicant/application/intake-applications/referee.interface';
import {Injectable} from '@angular/core';
import {Response, Http, Headers, RequestOptions, ResponseContentType} from '@angular/http';
import {HttpInterceptorService} from '@covalent/http';
import {IntakeApplication} from '../app/secure/applicant/application/intake-applications/intake-application.interface';
import {Observable} from 'rxjs/Observable';
import {environment} from '../environments/environment';
import {Education} from '../app/secure/applicant/application/intake-applications/education.interface';
import {Employment} from '../app/secure/applicant/application/intake-applications/employment.interface';
import {Intake} from '../app/policy/intakes/intake.interface';
import {ProgramOffering} from '../app/policy/intakes/program-offering.interface';
import {StudyModeOffering} from '../app/policy/intakes/study-mode-offering.interface';
import {Language} from '../app/secure/applicant/application/intake-applications/language.interface';
import {SupervisorOffering} from '../app/policy/intakes/supervisor-offering.interface';
import {AttachmentType} from '../app/secure/applicant/application/intake-applications/attachment-type.enum';
import {AuthenticationService} from './authentication.service';

@Injectable()
export class ApplicationService {

  constructor(private http: Http,
              private _http: HttpInterceptorService,
              private authnService: AuthenticationService) {
  }

  // ====================================================================================================
  // INTAKE
  // ====================================================================================================

  findPublishedIntakes(): Observable<Intake[]> {
    console.log('findPublishedIntakes');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/application/intakes/state/PUBLISHED', options)
      .map((res: Response) => <Intake[]>res.json());
  }

  findIntakes(): Observable<Intake[]> {
    console.log('findIntakes');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/application/intakes', options)
      .map((res: Response) => <Intake[]>res.json());
  }

  findIntakeByReferenceNo(referenceNo: string): Observable<Intake> {
    console.log('findIntakeByReferenceNo : ' + referenceNo);
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/application/intakes/' + referenceNo, options)
      .map((res: Response) => <Intake>res.json());
  }

  findProgramOfferingsByIntake(intake: Intake): Observable<ProgramOffering[]> {
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/application/intakes/' + intake.referenceNo + '/programOfferings', options)
      .map((res: Response) => <ProgramOffering[]>res.json());
  }

  findSupervisorOfferingsByIntake(intake: Intake): Observable<SupervisorOffering[]> {
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/application/intakes/' + intake.referenceNo + '/supervisorOfferings', options)
      .map((res: Response) => <SupervisorOffering[]>res.json());
  }

  findStudyModeOfferingsByIntake(intake: Intake): Observable<StudyModeOffering[]> {
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/application/intakes/' + intake.referenceNo + '/studyModeOfferings', options)
      .map((res: Response) => <StudyModeOffering[]>res.json());
  }

  applyIntake(intake: Intake): Observable<IntakeApplication> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/application/intakes/' + intake.referenceNo + '/apply', options)
      .map((res: Response) => <IntakeApplication>res.json());
  }

  // ====================================================================================================
  // INTAKE APPLICATION
  // ====================================================================================================

  findIntakeApplications(): Observable<IntakeApplication[]> {
    console.log('findIntakeApplications');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/application/intakeApplications', options)
      .map((res: Response) => <IntakeApplication[]>res.json());
  }

  findIntakeApplicationByReferenceNo(referenceNo: string): Observable<IntakeApplication> {
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/application/intakeApplication/' + referenceNo, options)
      .map((res: Response) => <IntakeApplication>res.json());
  }

  submitIntakeApplication(application: IntakeApplication): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/application/intakeApplications/'
      + application.referenceNo + '/submit', JSON.stringify(application), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  selectIntakeApplication(application: IntakeApplication): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/application/intakeApplications/'
      + application.referenceNo + '/select', JSON.stringify(application), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  verifyIntakeApplication(application: IntakeApplication): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/application/intakeApplications/'
      + application.referenceNo + '/verify', JSON.stringify(application), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  rejectIntakeApplication(application: IntakeApplication): Observable<String> {
    console.log('application {}', application);
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/application/intakeApplications/'
      + application.referenceNo + '/reject', JSON.stringify(application), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateIntakeApplication(application: IntakeApplication): Observable<String> {
    console.log('updateIntakeApplication ');
    console.log('email: ' + application.email);
    console.log('researchTitle: ' + application.researchTitle);
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/application/intakeApplications/'
      + application.referenceNo, JSON.stringify(application), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  findSubmittedIntakeApplications(intake: Intake): Observable<IntakeApplication[]> {
    console.log('findSubmittedIntakeApplications ' + intake.referenceNo);
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/application/intakes/' + intake.referenceNo + '/intakeApplications/bidStatus/SUBMITTED', options)
      .map((res: Response) => <IntakeApplication[]>res.json());
  }

  findRejectedIntakeApplications(intake: Intake): Observable<IntakeApplication[]> {
    console.log('findIntakeApplications');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/application/intakes/' + intake.referenceNo + '/intakeApplications/bidStatus/REJECTED', options)
      .map((res: Response) => <IntakeApplication[]>res.json());
  }

  findSelectedIntakeApplications(intake: Intake): Observable<IntakeApplication[]> {
    console.log('findIntakeApplications');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/application/intakes/' + intake.referenceNo + '/intakeApplications/bidStatus/SELECTED', options)
      .map((res: Response) => <IntakeApplication[]>res.json());
  }

  findVerifiedInternationalIntakeApplications(intake: Intake): Observable<IntakeApplication[]> {
    console.log('findVerifiedInternationalIntakeApplications');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/application/intakes/'
      + intake.referenceNo + '/intakeApplications/bidStatus/SELECTED/verify/false', options)
      .map((res: Response) => <IntakeApplication[]>res.json());
  }

  // ====================================================================================================
  // EDUCATION
  // ====================================================================================================

  findEducationsByIntakeApplication(application: IntakeApplication): Observable<Education[]> {
    console.log('findEducations');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/educations', options)
      .map((res: Response) => <Education[]>res.json());
  }

  addEducation(application: IntakeApplication, education: Education): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo
      + '/educations', JSON.stringify(education), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteEducation(application: IntakeApplication, education: Education): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/educations/' + education.id)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // EMPLOYMENT
  // ====================================================================================================

  findEmploymentsByIntakeApplication(application: IntakeApplication): Observable<Employment[]> {
    console.log('findEmployments');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/employments', options)
      .map((res: Response) => <Employment[]>res.json());
  }

  addEmployment(application: IntakeApplication, employment: Employment): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo
      + '/employments', JSON.stringify(employment), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateEmployment(application: IntakeApplication, employment: Employment): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/application/intakeApplications/'
      + application.referenceNo + '/employments/' + employment.id, JSON.stringify(employment), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteEmployment(application: IntakeApplication, employment: Employment): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo
      + '/employments/' + employment.id, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // LANGUAGE
  // ====================================================================================================

  findLanguagesByIntakeApplication(application: IntakeApplication): Observable<Language[]> {
    console.log('findLanguages');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/languages', options)
      .map((res: Response) => <Language[]>res.json());
  }

  addLanguage(application: IntakeApplication, language: Language): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo
      + '/languages', JSON.stringify(language), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateLanguage(application: IntakeApplication, language: Language): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo
      + '/languages/' + language.id, JSON.stringify(language), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteLanguage(application: IntakeApplication, language: Language): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/application/intakeApplications/'
      + application.referenceNo + '/languages/' + language.id, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // ATTACHMENT
  // ====================================================================================================

  findAttachmentsByIntakeApplication(application: IntakeApplication): Observable<Attachment[]> {
    console.log('findAttachments');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/attachments', options)
      .map((res: Response) => <Attachment[]>res.json());
  }

  downloadAttachment(attachment: Attachment): Observable<File> {
    console.log('downloadAttachment');
    let options: RequestOptions = new RequestOptions({responseType: ResponseContentType.ArrayBuffer});
    return this.http.get(environment.endpoint + '/api/application/intakeApplications/download/attachment/' + attachment.id, options)
      .map((res: Response) => {
        let type: string = attachment.mimeType;
        let filename: string = attachment.name;
        return new File([res.arrayBuffer()], filename, {type: type});
      });
  }

  addAttachment(application: IntakeApplication, file: File, attachmentType: AttachmentType): Observable<String> {
    console.log('addAttachment');
    console.log('file: ' + file.name);
    console.log('attachmentType: ' + attachmentType);
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    let formData: FormData = new FormData();
    formData.append('attachmentType', attachmentType.toString());
    formData.append('file', file);
    return this.http.post(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/attachments', formData, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // REFEREE
  // ====================================================================================================

  findRefereesByIntakeApplication(application: IntakeApplication): Observable<Referee[]> {
    console.log('findReferees');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/referees', options)
      .map((res: Response) => <Referee[]>res.json());
  }

  addReferee(application: IntakeApplication, referee: Referee): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/application/intakeApplications/'
      + application.referenceNo + '/referees', JSON.stringify(referee), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateReferee(application: IntakeApplication, referee: Referee): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/application/intakeApplications/'
      + application.referenceNo + '/referees/' + referee.id, JSON.stringify(referee), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteReferee(application: IntakeApplication, referee: Referee): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/application/intakeApplications/'
      + application.referenceNo + '/referees/' + referee.id, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // RESULT
  // ====================================================================================================

  findResultsByIntakeApplication(application: IntakeApplication): Observable<Result[]> {
    console.log('findResultsByIntakeApplication');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo + '/results', options)
      .map((res: Response) => <Result[]>res.json());
  }

  addResult(application: IntakeApplication, result: Result): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/application/intakeApplications/'
      + application.referenceNo + '/results', JSON.stringify(result), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateResult(application: IntakeApplication, result: Result): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo
      + '/results/' + result.id, JSON.stringify(result), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteResult(application: IntakeApplication, result: Result): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo
      + '/results/' + result.id, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // SELECT
  // ====================================================================================================

  selectProgramOffering(application: IntakeApplication, offering: ProgramOffering): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/application/intakeApplications/'
      + application.referenceNo + '/programOfferingSelection', JSON.stringify(offering), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  selectSupervisorOffering(application, offering): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/application/intakeApplications/' + application.referenceNo
      + '/supervisorOfferingSelection', JSON.stringify(offering), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  selectStudyModeOffering(application, offering): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/application/intakeApplications/'
      + application.referenceNo + '/studyModeOfferingSelection', JSON.stringify(offering), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // PROCESS CANDIDATE
  // ====================================================================================================
  processIntakeCandidate(application: IntakeApplication): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/application/intakeApplications/'
      + application.referenceNo + '/processCandidate', JSON.stringify(application), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }
}
