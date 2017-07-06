import {Injectable} from '@angular/core';
import {Response, Http, Headers, RequestOptions} from '@angular/http';
import {HttpInterceptorService} from '@covalent/http';
import {Intake} from '../app/policy/intakes/intake.interface';
import {Observable} from 'rxjs';
import {environment} from '../environments/environment';
import {IntakeTask} from '../app/policy/intakes/intake-task.interface';
import {ProgramOffering} from '../app/policy/intakes/program-offering.interface';
import {SupervisorOffering} from '../app/policy/intakes/supervisor-offering.interface';
import {StudyModeOffering} from '../app/policy/intakes/study-mode-offering.interface';
import {IntakeSession} from '../app/policy/intake-sessions/intake-session.interface';
import {ProgramLevel} from '../app/policy/program-levels/program-level.interface';
import {IntakeApplication} from '../app/application/intake-applications/intake-application.interface';
import {AuthenticationService} from './authentication.service';

@Injectable()
export class PolicyService {

  constructor(private http: Http,
              private _http: HttpInterceptorService,
              private authnService: AuthenticationService) {
  }

  // ====================================================================================================
  // INTAKE SESSION
  // ====================================================================================================

  findIntakeSessions(): Observable<IntakeSession[]> {
    console.log('findIntakeSessions');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/policy/intakeSessions', options)
      .map((res: Response) => <IntakeSession[]>res.json());
  }

  saveIntakeSession(sessions: IntakeSession): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/policy/intake-sessions', JSON.stringify(sessions), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeIntakeSession(session: IntakeSession): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/policy/intake-sessions/' + session.id, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateIntakeSession(code: IntakeSession): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/policy/intake-sessions/' + code.code, JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // PROGRAM LEVEL
  // ====================================================================================================

  findProgramLevels(): Observable<ProgramLevel[]> {
    console.log('findProgramLevels');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/policy/programLevels', options)
      .map((res: Response) => <ProgramLevel[]>res.json());
  }

  // ====================================================================================================
  // INTAKE
  // ====================================================================================================

  findAssignedIntakeTasks(): Observable<IntakeTask[]> {
    console.log('findAssignedIntakeTasks');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/policy/intakes/assignedTasks', options)
      .map((res: Response) => <IntakeTask[]>res.json());
  }

  findPooledIntakeTasks(): Observable<IntakeTask[]> {
    console.log('findPooledIntakeTasks');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/policy/intakes/pooledTasks', options)
      .map((res: Response) => <IntakeTask[]>res.json());
  }

  findIntakeTaskByTaskId(taskId: string): Observable<IntakeTask> {
    console.log('findIntakeTaskByTaskId');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/policy/intakes/viewTask/' + taskId, options)
      .map((res: Response) => <IntakeTask>res.json());
  }

  findIntakeByReferenceNo(referenceNo: string): Observable<Intake> {
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/policy/intakes/' + referenceNo, options)
      .map((res: Response) => <Intake>res.json());
  }

  findIntakeByTaskId(taskId: string): Observable<Intake> {
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/policy/intakes/' + taskId, options)
      .map((res: Response) => <Intake>res.json());
  }

  findProgramOfferings(intake: Intake): Observable<ProgramOffering[]> {
    console.log('findProgramOfferings: ' + intake.referenceNo);
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/policy/intakes/' + intake.referenceNo + '/programOfferings', options)
      .map((res: Response) => <ProgramOffering[]>res.json());
  }

  findSupervisorOfferings(intake: Intake): Observable<SupervisorOffering[]> {
    console.log('findSupervisorOfferings');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/policy/intakes/' + intake.referenceNo + '/supervisorOfferings', options)
      .map((res: Response) => <SupervisorOffering[]>res.json());
  }

  findStudyModeOfferings(intake: Intake): Observable<StudyModeOffering[]> {
    console.log('findStudyModeOfferings');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/policy/intakes/' + intake.referenceNo + '/studyModeOfferings', options)
      .map((res: Response) => <StudyModeOffering[]>res.json());
  }

  findIntakeApplications(intake: Intake): Observable<IntakeApplication[]> {
    console.log('findIntakeApplications :' + intake.referenceNo);
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/policy/intakes/' + intake.referenceNo + '/intakeApplications', options)
      .map((res: Response) => <IntakeApplication[]>res.json());
  }

  findSubmittedIntakeApplications(intake: Intake): Observable<IntakeApplication[]> {
    console.log('findSubmittedIntakeApplications :' + intake);
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/policy/intakes/' + intake.referenceNo + '/intakeApplications/bidStatus/SUBMITTED', options)
      .map((res: Response) => <IntakeApplication[]>res.json());
  }

  findRejectedIntakeApplications(intake: Intake): Observable<IntakeApplication[]> {
    console.log('findIntakeApplications');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/policy/intakes/' + intake.referenceNo + '/intakeApplications/bidStatus/REJECTED', options)
      .map((res: Response) => <IntakeApplication[]>res.json());
  }

  findSelectedIntakeApplications(intake: Intake): Observable<IntakeApplication[]> {
    console.log('findIntakeApplications');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/policy/intakes/' + intake.referenceNo + '/intakeApplications/bidStatus/SELECTED', options)
      .map((res: Response) => <IntakeApplication[]>res.json());
  }

  startIntakeTask(intake: Intake): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/policy/intakes/startTask', JSON.stringify(intake), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  copyIntakeTask(intake: Intake): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/policy/intakes/' + intake.referenceNo + '/copy', JSON.stringify(intake), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  completeIntakeTask(intakeTask: IntakeTask): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/policy/intakes/completeTask', JSON.stringify(intakeTask), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  claimIntakeTask(intakeTask: IntakeTask): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/policy/intakes/claimTask', JSON.stringify(intakeTask), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  releaseIntakeTask(intakeTask: IntakeTask): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/policy/intakes/releaseTask', JSON.stringify(intakeTask), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateIntake(intake: Intake): Observable<String> {
    console.log('referenceNo :' + intake.referenceNo);
    console.log('description :' + intake.description);
    console.log('description :' + intake.startDate);
    console.log('description :' + intake.endDate);
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/policy/intakes/' + intake.referenceNo, JSON.stringify(intake), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  addProgramOffering(intake: Intake, offering: ProgramOffering): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/policy/intakes/' + intake.referenceNo + '/programOfferings',
      JSON.stringify(offering), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateProgramOffering(intake: Intake, offering: ProgramOffering): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    console.log('offering gen criteria :' + offering.generalCriteria);
    console.log('offering spes criteria :' + offering.specificCriteria);
    return this.http.put(environment.endpoint + '/api/policy/intakes/' + intake.referenceNo + '/programOfferings/'
      + offering.id, JSON.stringify(offering), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteProgramOffering(intake: Intake, offering: ProgramOffering): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/policy/intakes/' + intake.referenceNo + '/programOfferings/' + offering.id, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  addSupervisorOffering(intake: Intake, offering: SupervisorOffering): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/policy/intakes/' + intake.referenceNo + '/supervisorOfferings',
      JSON.stringify(offering), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteSupervisorOffering(intake: Intake, offering: SupervisorOffering): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/policy/intakes/' + intake.referenceNo + '/supervisorOfferings/' + offering.id, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  addStudyModeOffering(intake: Intake, offering: StudyModeOffering): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/policy/intakes/' + intake.referenceNo + '/studyModeOfferings',
      JSON.stringify(offering), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deleteStudyModeOffering(intake: Intake, offering: StudyModeOffering): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/policy/intakes/' + intake.referenceNo + '/studyModeOfferings/' + offering.id, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

}
