import { Injectable } from '@angular/core';
import {Response, Http, Headers, RequestOptions} from '@angular/http';
import { HttpInterceptorService } from '@covalent/http';
import {Intake} from "../app/policy/intakes/intake.interface";
import {Observable} from "rxjs";
import {environment} from "../environments/environment";
import {IntakeTask} from "../app/policy/intakes/intake-task.interface";
import {ProgramOffering} from "../app/policy/intakes/program-offering.interface";
import {SupervisorOffering} from "../app/policy/intakes/supervisor-offering.interface";
import {StudyModeOffering} from "../app/policy/intakes/study-mode-offering.interface";

@Injectable()
export class PolicyService {

  constructor(private http: Http,
              private _http: HttpInterceptorService) {
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
    console.log("encoded uri: " + encodeURI (referenceNo))
    return this.http.get(environment.endpoint + '/api/policy/intakes/' + encodeURI (referenceNo))
      .map((res: Response) => <Intake>res.json());
  }

  findIntakeByTaskId(taskId: string): Observable<Intake> {
    console.log("encoded uri: " + encodeURI (taskId))
    return this.http.get(environment.endpoint + '/api/policy/intakes/' + encodeURI (taskId))
      .map((res: Response) => <Intake>res.json());
  }

  findProgramOfferings(intake:Intake): Observable<ProgramOffering[]> {
    console.log("findIntakeItems");
    return this.http.get(environment.endpoint + '/api/policy/intakes/' + intake.referenceNo + "/programOffering")
      .map((res: Response) => <ProgramOffering[]>res.json());
  }

  findSupervisorOfferings(intake:Intake): Observable<SupervisorOffering[]> {
    console.log("findIntakeItems");
    return this.http.get(environment.endpoint + '/api/policy/intakes/' + intake.referenceNo + "/supervisorOffering")
      .map((res: Response) => <SupervisorOffering[]>res.json());
  }

  findStudyModeOfferings(intake:Intake): Observable<StudyModeOffering[]> {
    console.log("findIntakeItems");
    return this.http.get(environment.endpoint + '/api/policy/intakes/' + intake.referenceNo + "/studyModeOffering")
      .map((res: Response) => <StudyModeOffering[]>res.json());
  }

  startIntakeTask(intake: Intake): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/policy/intakes/startTask', JSON.stringify(intake), options)
      .flatMap((res:Response) => Observable.of(res.text()));
  }

  updateIntake(intake: Intake): Observable<Boolean> {
    return this.http.put(environment.endpoint + '/api/policy/intakes', JSON.stringify(intake))
      .flatMap(data => Observable.of(true));
  }

}
