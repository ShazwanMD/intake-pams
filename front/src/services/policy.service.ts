import {Injectable} from '@angular/core';
import {Response, Http, Headers, RequestOptions} from '@angular/http';
import {HttpInterceptorService} from '@covalent/http';
import {Intake} from "../app/policy/intakes/intake.interface";
import {Observable} from "rxjs";
import {environment} from "../environments/environment";
import {IntakeTask} from "../app/policy/intakes/intake-task.interface";
import {ProgramOffering} from "../app/policy/intakes/program-offering.interface";
import {SupervisorOffering} from "../app/policy/intakes/supervisor-offering.interface";
import {StudyModeOffering} from "../app/policy/intakes/study-mode-offering.interface";
import {IntakeSession} from "../app/policy/intake-sessions/intake-session.interface";
import {ProgramLevel} from "../app/policy/program-levels/program-level.interface";
import { IntakeApplication } from "../app/application/intake-applications/cps/intake-application.interface";

@Injectable()
export class PolicyService {

  constructor(private http: Http,
              private _http: HttpInterceptorService) {
  }

  // ====================================================================================================
  // INTAKE SESSION
  // ====================================================================================================

  findIntakeSessions(): Observable<IntakeSession[]> {
    console.log("findIntakeSessions");
    return this.http.get(environment.endpoint + '/api/policy/intakeSessions')
      .map((res: Response) => <IntakeSession[]>res.json());
  }

  // ====================================================================================================
  // PROGRAM LEVEL
  // ====================================================================================================

  findProgramLevels(): Observable<ProgramLevel[]> {
    console.log("findProgramLevels");
    return this.http.get(environment.endpoint + '/api/policy/programLevels')
      .map((res: Response) => <ProgramLevel[]>res.json());
  }

  // ====================================================================================================
  // INTAKE
  // ====================================================================================================

  findAssignedIntakeTasks(): Observable<IntakeTask[]> {
    console.log("findAssignedIntakeTasks");
    return this.http.get(environment.endpoint + '/api/policy/intakes/assignedTasks')
      .map((res: Response) => <IntakeTask[]>res.json());
  }

  findPooledIntakeTasks(): Observable<IntakeTask[]> {
    console.log("findPooledIntakeTasks");
    return this.http.get(environment.endpoint + '/api/policy/intakes/pooledTasks')
      .map((res: Response) => <IntakeTask[]>res.json());
  }

  findIntakeTaskByTaskId(taskId: string): Observable<IntakeTask> {
    console.log("findIntakeTaskByTaskId");
    return this.http.get(environment.endpoint + '/api/policy/intakes/viewTask/' + taskId)
      .map((res: Response) => <IntakeTask>res.json());
  }

  findIntakeByReferenceNo(referenceNo: string): Observable<Intake> {
    let encoded = referenceNo.replace(/\//g, '%252F');
    return this.http.get(environment.endpoint + '/api/policy/intakes/' + encoded)
      .map((res: Response) => <Intake>res.json());
  }

  findIntakeByTaskId(taskId: string): Observable<Intake> {
    return this.http.get(environment.endpoint + '/api/policy/intakes/' + taskId)
      .map((res: Response) => <Intake>res.json());
  }

  findProgramOfferings(intake: Intake): Observable<ProgramOffering[]> {
    console.log("findProgramOfferings");
    let encoded = intake.referenceNo.replace(/\//g, '%252F');
    return this.http.get(environment.endpoint + '/api/policy/intakes/' + encoded + "/programOfferings")
      .map((res: Response) => <ProgramOffering[]>res.json());
  }

  findSupervisorOfferings(intake: Intake): Observable<SupervisorOffering[]> {
    console.log("findSupervisorOfferings");
    let encoded = intake.referenceNo.replace(/\//g, '%252F');
    return this.http.get(environment.endpoint + '/api/policy/intakes/' + encoded + "/supervisorOfferings")
      .map((res: Response) => <SupervisorOffering[]>res.json());
  }

  findStudyModeOfferings(intake: Intake): Observable<StudyModeOffering[]> {
    console.log("findStudyModeOfferings");
    let encoded = intake.referenceNo.replace(/\//g, '%252F');
    return this.http.get(environment.endpoint + '/api/policy/intakes/' + encoded + "/studyModeOfferings")
      .map((res: Response) => <StudyModeOffering[]>res.json());
  }

  startIntakeTask(intake: Intake): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/policy/intakes/startTask', JSON.stringify(intake), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateIntake(intake: Intake): Observable<Boolean> {
    return this.http.put(environment.endpoint + '/api/policy/intakes', JSON.stringify(intake))
      .flatMap(data => Observable.of(true));
  }

  addProgramOffering(intake: Intake, offering: ProgramOffering): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    let encoded = intake.referenceNo.replace(/\//g, '%252F');
    return this.http.post(environment.endpoint + '/api/policy/intakes/' + encoded + '/programOfferings', JSON.stringify(offering), options)
      .flatMap((res:Response) => Observable.of(res.text()));
  }

  deleteProgramOffering(intake: Intake, offering: ProgramOffering): Observable<Boolean> {
    let encoded = intake.referenceNo.replace(/\//g, '%252F');
    return this.http.delete(environment.endpoint + '/api/policy/intakes/' + encoded + '/programOfferings/' + offering.id)
      .flatMap(data => Observable.of(true));
  }

  addSupervisorOffering(intake: Intake, offering: SupervisorOffering): Observable<Boolean> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    let encoded = intake.referenceNo.replace(/\//g, '%252F');
    return this.http.post(environment.endpoint + '/api/policy/intakes/' + encoded + '/supervisorOfferings',
      JSON.stringify(offering), options)
      .flatMap(data => Observable.of(true));
  }

  deleteSupervisorOffering(intake: Intake, offering: SupervisorOffering): Observable<Boolean> {
    let encoded = intake.referenceNo.replace(/\//g, '%252F');
    return this.http.delete(environment.endpoint + '/api/policy/intakes/' + encoded + '/supervisorOfferings/' + offering.id)
      .flatMap(data => Observable.of(true));
  }

  addStudyModeOffering(intake: Intake, offering: StudyModeOffering): Observable<Boolean> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    let encoded = intake.referenceNo.replace(/\//g, '%252F');
    return this.http.post(environment.endpoint + '/api/policy/intakes/' + encoded + '/studyModeOfferings',
      JSON.stringify(offering), options)
      .flatMap(data => Observable.of(true));
  }

  deleteStudyModeOffering(intake: Intake, offering: StudyModeOffering): Observable<Boolean> {
    let encoded = intake.referenceNo.replace(/\//g, '%252F');
    return this.http.delete(environment.endpoint + '/api/policy/intakes/' + encoded + '/studyModeOfferings/' + offering.id)
      .flatMap(data => Observable.of(true));
  }

/*  addEmployement(employement: IntakeApplication): Observable<Boolean> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/policy/intakes/' + encoded + '/studyModeOfferings',
      JSON.stringify(offering), options)
      .flatMap(data => Observable.of(true));
  }*/
}
