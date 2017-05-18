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


    saveIntakeSession(sessions: IntakeSession) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/policy/intake-sessions', JSON.stringify(sessions), options)
      .flatMap((res: Response) => Observable.of(res.text()));
    } 

    removeIntakeSession(id: IntakeSession) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/policy/intake-sessions' + id.id, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

   updateIntakeSession(code: IntakeSession) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/policy/intake-sessions' + code.code, JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
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
    return this.http.get(environment.endpoint + '/api/policy/intakes/' + referenceNo)
      .map((res: Response) => <Intake>res.json());
  }

  findIntakeByTaskId(taskId: string): Observable<Intake> {
    return this.http.get(environment.endpoint + '/api/policy/intakes/' + taskId)
      .map((res: Response) => <Intake>res.json());
  }

  findProgramOfferings(intake: Intake): Observable<ProgramOffering[]> {
    console.log("findProgramOfferings");
    return this.http.get(environment.endpoint + '/api/policy/intakes/' + intake.referenceNo + "/programOfferings")
      .map((res: Response) => <ProgramOffering[]>res.json());
  }

  findSupervisorOfferings(intake: Intake): Observable<SupervisorOffering[]> {
    console.log("findSupervisorOfferings");
    return this.http.get(environment.endpoint + '/api/policy/intakes/' + intake.referenceNo + "/supervisorOfferings")
      .map((res: Response) => <SupervisorOffering[]>res.json());
  }

  findStudyModeOfferings(intake: Intake): Observable<StudyModeOffering[]> {
    console.log("findStudyModeOfferings");
    return this.http.get(environment.endpoint + '/api/policy/intakes/' + intake.referenceNo + "/studyModeOfferings")
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

  completeIntakeTask(intakeTask: IntakeTask): Observable<String> {
    console.log("TaskId: " + intakeTask.taskId);
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/policy/intakes/completeTask', JSON.stringify(intakeTask), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  claimIntakeTask(intakeTask: IntakeTask): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/policy/intakes/claimTask', JSON.stringify(intakeTask), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  releaseIntakeTask(intakeTask: IntakeTask): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/policy/intakes/releaseTask', JSON.stringify(intakeTask), options)
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
    return this.http.post(environment.endpoint + '/api/policy/intakes/' + intake.referenceNo + '/programOfferings', JSON.stringify(offering), options)
      .flatMap((res:Response) => Observable.of(res.text()));
  }

  deleteProgramOffering(intake: Intake, offering: ProgramOffering): Observable<String> {
    return this.http.delete(environment.endpoint + '/api/policy/intakes/' + intake.referenceNo + '/programOfferings/' + offering.id)
      .flatMap((res:Response) => Observable.of(res.text()));
  }

  addSupervisorOffering(intake: Intake, offering: SupervisorOffering): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    let encoded = intake.referenceNo.replace(/\//g, '%252F');
    return this.http.post(environment.endpoint + '/api/policy/intakes/' + encoded + '/supervisorOfferings',
      JSON.stringify(offering), options)
      .flatMap((res:Response) => Observable.of(res.text()));
  }

  deleteSupervisorOffering(intake: Intake, offering: SupervisorOffering): Observable<String> {
    let encoded = intake.referenceNo.replace(/\//g, '%252F');
    return this.http.delete(environment.endpoint + '/api/policy/intakes/' + encoded + '/supervisorOfferings/' + offering.id)
      .flatMap((res:Response) => Observable.of(res.text()));
  }

  addStudyModeOffering(intake: Intake, offering: StudyModeOffering): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/policy/intakes/' + intake.referenceNo + '/studyModeOfferings',
      JSON.stringify(offering), options)
      .flatMap((res:Response) => Observable.of(res.text()));
  }

  deleteStudyModeOffering(intake: Intake, offering: StudyModeOffering): Observable<String> {
    return this.http.delete(environment.endpoint + '/api/policy/intakes/' + intake.referenceNo + '/studyModeOfferings/' + offering.id)
      .flatMap((res:Response) => Observable.of(res.text()));
  }
}
