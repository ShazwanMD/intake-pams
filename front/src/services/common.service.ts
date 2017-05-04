import {GenderCode} from './../app/common/gender-codes/gender-code.interface';
import {Injectable} from '@angular/core';
import {Response, Http} from '@angular/http';
import {HttpInterceptorService} from '@covalent/http';
import {Observable} from "rxjs";
import {FacultyCode} from "../app/common/faculty-codes/faculty-code.interface";
import {environment} from "../environments/environment";
import {ProgramCode} from "../app/common/program-codes/program-code.interface";
import {GraduateCentre} from "../app/common/graduate-centres/graduate-centre.interface";
import {StudyMode} from "../app/common/study-modes/study-mode.interface";
import {MaritalCode} from "../app/common/marital-codes/marital-code.interface";
import {ParliamentCode} from "../app/common/parliament-codes/parliament-code.interface";
import {DunCode} from "../app/common/dun-codes/dun-code.interface";
import {BankCode} from "../app/common/bank-codes/bank-code.interface";

@Injectable()
export class CommonService {


  constructor(private http: Http,
              private _http: HttpInterceptorService) {
  }

  // ====================================================================================================
  // BANKCODE
  // ====================================================================================================

  findBankCodes(): Observable<BankCode[]> {
    console.log("findBankCodes()");
    return this.http.get(environment.endpoint + '/api/common/bankCodes')
      .map((res: Response) => <BankCode[]>res.json());
  }

  findBankCodeByCode(code: string): Observable<BankCode> {
    console.log("findBankCodeByCode");
    return this.http.get(environment.endpoint + '/api/common/bankCodes/' + code)
      .map((res: Response) => <BankCode>res.json());
  }


  // ====================================================================================================
  // DUNCODE
  // ====================================================================================================

  findDunCodes(): Observable<DunCode[]> {
    console.log("findDunCodes()");
    return this.http.get(environment.endpoint + '/api/common/dunCodes')
      .map((res: Response) => <DunCode[]>res.json());
  }

  findDunCodeByCode(code: string): Observable<DunCode> {
    console.log("findDunCodeByCode");
    return this.http.get(environment.endpoint + '/api/common/dunCodes/' + code)
      .map((res: Response) => <DunCode>res.json());
  }


  // ====================================================================================================
  // PARLIAMENTCODE
  // ====================================================================================================

  findParliamentCodes(): Observable<ParliamentCode[]> {
    console.log("findParliamentCodes()");
    return this.http.get(environment.endpoint + '/api/common/parliamentCodes')
      .map((res: Response) => <ParliamentCode[]>res.json());
  }

  findParliamentCodeByCode(code: string): Observable<ParliamentCode> {
    console.log("findParliamentCodeByCode");
    return this.http.get(environment.endpoint + '/api/common/parliamentCodes/' + code)
      .map((res: Response) => <ParliamentCode>res.json());
  }

  // ====================================================================================================
  // GENDER CODES
  // ====================================================================================================

  findGenderCodes(): Observable<GenderCode[]> {
    console.log("findGenderCodes");
    return this.http.get(environment.endpoint + '/api/common/genderCodes')
      .map((res: Response) => <GenderCode[]>res.json());
  }

  findGenderCodeByCode(code: string): Observable<GenderCode> {
    console.log("findGenderCodeByCode");
    return this.http.get(environment.endpoint + '/api/common/genderCodes/' + code)
      .map((res: Response) => <GenderCode>res.json());
  }


  // ====================================================================================================
  // MARITAL CODES
  // ====================================================================================================

  findMaritalCodes(): Observable<MaritalCode[]> {
    console.log("findMaritalCodes");
    return this.http.get(environment.endpoint + '/api/common/maritalCodes')
      .map((res: Response) => <MaritalCode[]>res.json());
  }

  findMaritalCodeByCode(code: string): Observable<MaritalCode> {
    console.log("findMaritalCodeByCode");
    return this.http.get(environment.endpoint + '/api/common/maritalCodes/' + code)
      .map((res: Response) => <MaritalCode>res.json());
  }

  // ====================================================================================================
  // GRADUATE CENTRE
  // ====================================================================================================

  findGraduateCentres(): Observable<GraduateCentre[]> {
    console.log("findGraduateCentres");
    return this.http.get(environment.endpoint + '/api/common/graduateCentres')
      .map((res: Response) => <GraduateCentre[]>res.json());
  }

  findGraduateCentreByCode(code: string): Observable<GraduateCentre> {
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

  findFacultyCodeByCode(code: string): Observable<FacultyCode> {
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

  findProgramCodeByCode(code: string): Observable<ProgramCode> {
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

  findStudyModeByCode(code: string): Observable<ProgramCode> {
    console.log("findStudyModeByCode");
    return this.http.get(environment.endpoint + '/api/common/studyModes/' + code)
      .map((res: Response) => <StudyMode>res.json());
  }
}
