import {Injectable} from '@angular/core';
import {Response, Http, Headers, RequestOptions} from '@angular/http';
import {HttpInterceptorService} from '@covalent/http';
import {Observable} from 'rxjs/Observable';
import {environment} from '../environments/environment';
import {IntakeTask} from '../app/shared/model/policy/intake-task.interface';
import {Candidate} from '../app/shared/model/admission/candidate.interface';
import {Intake} from '../app/shared/model/policy/intake.interface';
import {AuthenticationService} from './authentication.service';

@Injectable()
export class AdmissionService {

  constructor(private http: Http,
              private _http: HttpInterceptorService,
              private authnService: AuthenticationService) {
  }

  // ====================================================================================================
  // INTAKE
  // ====================================================================================================

  findAssignedIntakeTasks(): Observable<IntakeTask[]> {
    console.log('findAssignedIntakeTasks');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/admission/intakes/assignedTasks', options)
      .map((res: Response) => <IntakeTask[]>res.json());
  }

  findPooledIntakeTasks(): Observable<IntakeTask[]> {
    console.log('findPooledIntakeTasks');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/admission/intakes/pooledTasks', options)
      .map((res: Response) => <IntakeTask[]>res.json());
  }

  findIntakeTaskByTaskId(taskId: string): Observable<IntakeTask> {
    console.log('findIntakeTaskByTaskId');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/admission/intakes/viewTask/' + taskId, options)
      .map((res: Response) => <IntakeTask>res.json());
  }

  // ====================================================================================================
  // INTAKE
  // ====================================================================================================

  findCandidates(intake: Intake): Observable<Candidate[]> {
    console.log('findCandidates');
    console.log('findCandidates intake.referenceNo: ' + intake.referenceNo);
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/admission/intakes/' + intake.referenceNo + '/candidates', options)
      .map((res: Response) => <Candidate[]>res.json());
  }

  findSelectedCandidates(intake: Intake): Observable<Candidate[]> {
    console.log('findSelectedCandidates');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/admission/intakes/' + intake.referenceNo + '/candidates/candidateStatus/SELECTED', options)
      .map((res: Response) => <Candidate[]>res.json());
  }

  findRejectedCandidates(intake: Intake): Observable<Candidate[]> {
    console.log('findRejectedCandidates');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/admission/intakes/' + intake.referenceNo + '/candidates/candidateStatus/REJECTED', options)
      .map((res: Response) => <Candidate[]>res.json());
  }

  findAcceptedCandidates(intake: Intake): Observable<Candidate[]> {
    console.log('findAcceptedCandidates');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/admission/intakes/' + intake.referenceNo + '/candidates/candidateStatus/ACCEPTED', options)
      .map((res: Response) => <Candidate[]>res.json());
  }
}
