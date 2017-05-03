import { Injectable } from '@angular/core';
import {Response, Http} from '@angular/http';
import { HttpInterceptorService } from '@covalent/http';
import {Observable} from "rxjs";
import {FacultyCode} from "../app/common/faculty-codes/faculty-code.interface";
import {environment} from "../environments/environment";
import {ProgramCode} from "../app/common/program-codes/program-code.interface";
import { GraduateCentre } from "../app/common/graduate-centres/graduate-centre.interface";
import { StudyMode } from "../app/common/study-modes/study-mode.interface";

@Injectable()
export class CommonService {


  constructor(private http: Http,
              private _http: HttpInterceptorService) {
  }

  // ====================================================================================================
  // GRADUATE CENTRE
  // ====================================================================================================

  findGraduateCentres(): Observable<GraduateCentre[]> {
    console.log("findGraduateCentres");
    return this.http.get(environment.endpoint + '/api/common/graduateCentres')
      .map((res: Response) => <GraduateCentre[]>res.json());
  }

  findGraduateCentreByCode(code:string): Observable<GraduateCentre> {
    console.log("findGraduateCentreByCode");
    return this.http.get(environment.endpoint + '/api/common/graduateCentres/' + code)
      .map((res: Response) => <GraduateCentre>res.json());
  }

  findProgramCodesByGraduateCentre(graduateCentre: GraduateCentre): Observable<ProgramCode[]> {
    console.log("findProgramCodesByGraduateCentre");
    return this.http.get(environment.endpoint + '/api/common/graduateCentres/' + graduateCentre.code + '/programCodes')
      .map((res: Response) => <ProgramCode[]>res.json());
  }

  // ====================================================================================================
  // FACULTY CODES
  // ====================================================================================================

  findFacultyCodes(): Observable<FacultyCode[]> {
    console.log("findFacultyCodes");
    return this.http.get(environment.endpoint + '/api/common/facultyCodes')
      .map((res: Response) => <FacultyCode[]>res.json());
  }

  findFacultyCodeByCode(code:string): Observable<FacultyCode> {
    console.log("findFacultyCodeByCode");
    return this.http.get(environment.endpoint + '/api/common/facultyCodes/' + code)
      .map((res: Response) => <FacultyCode>res.json());
  }

  findProgramCodesByFacultyCode(facultyCode: FacultyCode): Observable<ProgramCode[]> {
    console.log("findProgramCodesByFacultyCode");
    return this.http.get(environment.endpoint + '/api/common/facultyCodes/' + facultyCode.code + '/programCodes')
      .map((res: Response) => <ProgramCode[]>res.json());
  }

  // ====================================================================================================
  // PROGRAM CODES
  // ====================================================================================================

  findProgramCodes(): Observable<ProgramCode[]> {
    console.log("findProgramCodes");
    return this.http.get(environment.endpoint + '/api/common/programCodes')
      .map((res: Response) => <ProgramCode[]>res.json());
  }

  findProgramCodeByCode(code:string): Observable<ProgramCode> {
    console.log("findProgramCodeByCode");
    return this.http.get(environment.endpoint + '/api/common/programCodes/' + code)
      .map((res: Response) => <ProgramCode>res.json());
  }

  // ====================================================================================================
  // STUDY MODE
  // ====================================================================================================

  findStudyMode(): Observable<StudyMode[]> {
    console.log("findStudyMode");
    return this.http.get(environment.endpoint + '/api/common/studyMode')
      .map((res: Response) => <StudyMode[]>res.json());
  }

  findStudyModeByCode(code:string): Observable<ProgramCode> {
    console.log("findStudyModeByCode");
    return this.http.get(environment.endpoint + '/api/common/studyMode/' + code)
      .map((res: Response) => <StudyMode>res.json());
  }
}
