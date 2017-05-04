import { GenderCode } from './../app/common/gender-codes/gender-code.interface';
import { Injectable } from '@angular/core';
import {Response, Http} from '@angular/http';
import { HttpInterceptorService } from '@covalent/http';
import {Observable} from "rxjs";
import {FacultyCode} from "../app/common/faculty-codes/faculty-code.interface";
import {environment} from "../environments/environment";
import {ProgramCode} from "../app/common/program-codes/program-code.interface";
import { GraduateCentre } from "../app/common/graduate-centres/graduate-centre.interface";
import { StudyMode } from "../app/common/study-modes/study-mode.interface";
import { MaritalCode } from "../app/common/marital-codes/marital-code.interface";

@Injectable()
export class CommonService {

  constructor(private http: Http,
              private _http: HttpInterceptorService) {
  }

  
  // ====================================================================================================
  // GENDER CODES
  // ====================================================================================================

  findGenderCodes(): Observable<GenderCode[]> {
    console.log("findGenderCodes");
    return this.http.get(environment.endpoint + '/api/common/genderCodes')
      .map((res: Response) => <GenderCode[]>res.json());
  }

  findGenderCodeByCode(code:string): Observable<GenderCode> {
    console.log("findGenderCodeByCode");
    return this.http.get(environment.endpoint + '/api/common/genderCodes/' + code)
      .map((res: Response) => <GenderCode>res.json());
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

  findStudyModes(): Observable<StudyMode[]> {
    console.log("findStudyModes");
    return this.http.get(environment.endpoint + '/api/common/studyModes')
      .map((res: Response) => <StudyMode[]>res.json());
  }

  findStudyModeByCode(code:string): Observable<ProgramCode> {
    console.log("findStudyModeByCode");
    return this.http.get(environment.endpoint + '/api/common/studyModes/' + code)
      .map((res: Response) => <StudyMode>res.json());
  }
  
  //====================================================================================================
  //MARITALCODE
  //====================================================================================================

  findMaritalCodes(): Observable<MaritalCode[]> {
      console.log("findMaritalCodes()");
      return this.http.get(environment.endpoint + '/api/common/maritalCodes')
      .map((res: Response) => <MaritalCode[]>res.json());
  }

  findMaritalCodeByCode(code:string): Observable<MaritalCode> {
      console.log("findMaritalCodeByCode");
      return this.http.get(environment.endpoint + '/api/common/maritalCodes/' + code)
      .map((res: Response) => <MaritalCode>res.json());
  }

}
