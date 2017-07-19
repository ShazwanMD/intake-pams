import {Injectable} from '@angular/core';
import {Response} from '@angular/http';
import {HttpInterceptorService} from '@covalent/http';
import {Observable} from 'rxjs/Observable';
import {environment} from '../environments/environment';
import {IntakeTask} from '../app/shared/model/policy/intake-task.interface';
import {Candidate} from '../app/shared/model/admission/candidate.interface';
import {Intake} from '../app/shared/model/policy/intake.interface';

@Injectable()
export class AdmissionService {

  private ADMISSION_API: string = environment.endpoint + '/api/admission';

  constructor(private _http: HttpInterceptorService) {
  }

  // ====================================================================================================
  // INTAKE
  // ====================================================================================================

  findAssignedIntakeTasks(): Observable<IntakeTask[]> {
    console.log('findAssignedIntakeTasks');
    return this._http.get(this.ADMISSION_API + '/intakes/assignedTasks')
      .map((res: Response) => <IntakeTask[]>res.json());
  }

  findPooledIntakeTasks(): Observable<IntakeTask[]> {
    console.log('findPooledIntakeTasks');
    return this._http.get(this.ADMISSION_API + '/intakes/pooledTasks')
      .map((res: Response) => <IntakeTask[]>res.json());
  }

  findIntakeTaskByTaskId(taskId: string): Observable<IntakeTask> {
    console.log('findIntakeTaskByTaskId');
    return this._http.get(this.ADMISSION_API + '/intakes/viewTask/' + taskId)
      .map((res: Response) => <IntakeTask>res.json());
  }

  // ====================================================================================================
  // INTAKE
  // ====================================================================================================

  findCandidates(intake: Intake): Observable<Candidate[]> {
    console.log('findCandidates');
    console.log('findCandidates intake.referenceNo: ' + intake.referenceNo);
    return this._http.get(this.ADMISSION_API + '/intakes/' + intake.referenceNo + '/candidates')
      .map((res: Response) => <Candidate[]>res.json());
  }

  findSelectedCandidates(intake: Intake): Observable<Candidate[]> {
    console.log('findSelectedCandidates');
    return this._http.get(this.ADMISSION_API + '/intakes/' + intake.referenceNo + '/candidates/candidateStatus/SELECTED')
      .map((res: Response) => <Candidate[]>res.json());
  }

  findRejectedCandidates(intake: Intake): Observable<Candidate[]> {
    console.log('findRejectedCandidates');
    return this._http.get(this.ADMISSION_API + '/intakes/' + intake.referenceNo + '/candidates/candidateStatus/REJECTED')
      .map((res: Response) => <Candidate[]>res.json());
  }

  findAcceptedCandidates(intake: Intake): Observable<Candidate[]> {
    console.log('findAcceptedCandidates');
    return this._http.get(this.ADMISSION_API + '/intakes/' + intake.referenceNo + '/candidates/candidateStatus/ACCEPTED')
      .map((res: Response) => <Candidate[]>res.json());
  }
  
  preSelectCandidate(candidate: Candidate): Observable<String> {
    return this._http.put(this.ADMISSION_API + '/application/'
      + candidate.application.referenceNo + '/candidates/candidateStatus/preSelect', JSON.stringify(candidate))
      .flatMap((res: Response) => Observable.of(res.text()));
  }
}
