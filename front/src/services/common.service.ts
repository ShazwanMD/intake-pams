import {StudyMode} from './../app/common/study-modes/study-mode.interface';
import {NationalityCode} from './../app/common/nationality-codes/nationality-code.interface';
import {EthnicityCode} from './../app/common/ethnicity-codes/ethnicity-code.interface';
import {RaceCode} from './../app/common/race-codes/race-code.interface';
import {StateCode} from './../app/common/state-codes/state-code.interface';
import {SupervisorCode} from './../app/common/supervisor-codes/supervisor-code.interface';
import {CountryCode} from './../app/common/country-codes/country-code.interface';
import {ReligionCode} from './../app/common/religion-codes/religion-code.interface';
import {GenderCode} from './../app/common/gender-codes/gender-code.interface';
import {Injectable} from '@angular/core';
import {Response, Http, Headers, RequestOptions} from '@angular/http';
import {HttpInterceptorService} from '@covalent/http';
import {Observable} from "rxjs";
import {FacultyCode} from "../app/common/faculty-codes/faculty-code.interface";
import {environment} from "../environments/environment";
import {ProgramCode} from "../app/common/program-codes/program-code.interface";
import {GraduateCentre} from "../app/common/graduate-centres/graduate-centre.interface";
import {MaritalCode} from "../app/common/marital-codes/marital-code.interface";
import {ParliamentCode} from "../app/common/parliament-codes/parliament-code.interface";
import {DunCode} from "../app/common/dun-codes/dun-code.interface";
import {BankCode} from "../app/common/bank-codes/bank-code.interface";
import {DisabilityCode} from "../app/common/disability-codes/disability-code.interface";


@Injectable()
export class CommonService {


  constructor(private http: Http,
              private _http: HttpInterceptorService) {
  }

  // ====================================================================================================
  // BANK CODES
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
  // DUN CODES
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
  // PARLIAMENT CODES
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

  saveGenderCode(code: GenderCode) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/common/genderCodes', JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
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

  saveMaritalCode(code: MaritalCode) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/common/maritalCodes', JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateMaritalCode(code: MaritalCode) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/common/maritalCodes/' + code.code, JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeMaritalCode(code: MaritalCode) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/common/maritalCodes/' + code.code, options)
      .flatMap((res: Response) => Observable.of(res.text()));
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

  saveGraduateCentre(code: GraduateCentre) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/common/graduateCentres', JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
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

  saveFacultyCode(code: FacultyCode) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/common/facultyCodes', JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
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

  saveProgramCode(code: ProgramCode) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/common/programCodes', JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeProgramCode(code: ProgramCode) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/common/programCodes/' + code.code, options)
      .flatMap((res: Response) => Observable.of(res.text()));
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

  saveStudyMode(code: StudyMode) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/common/studyModes', JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }


  // ====================================================================================================
  // RELIGION CODES
  // ====================================================================================================

  findReligionCodes(): Observable<ReligionCode[]> {
    console.log("findReligionCodes()");
    return this.http.get(environment.endpoint + '/api/common/religionCodes')
      .map((res: Response) => <ReligionCode[]>res.json());
  }

  findReligionCodeByCode(code: string): Observable<ReligionCode> {
    console.log("findReligionCodeByCode");
    return this.http.get(environment.endpoint + '/api/common/religionCodes/' + code)
      .map((res: Response) => <ReligionCode>res.json());
  }


// ====================================================================================================
// COUNTRY CODES
// ====================================================================================================

  findCountryCodes(): Observable<CountryCode[]> {
    console.log("findCountryCodes()");
    return this.http.get(environment.endpoint + '/api/common/countryCodes')
      .map((res: Response) => <CountryCode[]>res.json());
  }

  findCountryCodeByCode(code: string): Observable<CountryCode> {
    console.log("findCountryCodeByCode");
    return this.http.get(environment.endpoint + '/api/common/countryCodes/' + code)
      .map((res: Response) => <CountryCode>res.json());
  }

// ====================================================================================================
// SUPERVISOR CODES
// ====================================================================================================

  findSupervisorCodes(): Observable<SupervisorCode[]> {
    console.log("findSupervisorCodes()");
    return this.http.get(environment.endpoint + '/api/common/supervisorCodes')
      .map((res: Response) => <SupervisorCode[]>res.json());
  }

  findSupervisorCodesByFilter(filter: string): Observable<SupervisorCode[]> {
    console.log("findSupervisorCodesByFilter");
    return this.http.get(environment.endpoint + '/api/common/supervisorCodes/byFilter/' + filter)
      .map((res: Response) => <SupervisorCode[]>res.json());
  }

  findSupervisorCodeByCode(code: string): Observable<SupervisorCode> {
    console.log("findSupervisorCodeByCode");
    return this.http.get(environment.endpoint + '/api/common/supervisorCodes/' + code)
      .map((res: Response) => <SupervisorCode>res.json());
  }

  saveSupervisorCode(code: SupervisorCode) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/common/supervisorCodes', JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeSupervisorCode(code: SupervisorCode) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/common/supervisorCodes/' + code.code, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

 updateSupervisorCode(code: SupervisorCode) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/common/supervisorCodes/' + code.code, JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }


// ====================================================================================================
// STATE CODES
// ====================================================================================================

  findStateCodes(): Observable<StateCode[]> {
    console.log("findStateCodes()");
    return this.http.get(environment.endpoint + '/api/common/stateCodes')
      .map((res: Response) => <StateCode[]>res.json());
  }

  findStateCodeByCode(code: string): Observable<StateCode> {
    console.log("findStateCodeByCode");
    return this.http.get(environment.endpoint + '/api/common/stateCodes/' + code)
      .map((res: Response) => <StateCode>res.json());
  }

// ====================================================================================================
// RACE CODES
// ====================================================================================================

  findRaceCodes(): Observable<RaceCode[]> {
    console.log("findRaceCodes()");
    return this.http.get(environment.endpoint + '/api/common/raceCodes')
      .map((res: Response) => <RaceCode[]>res.json());
  }

  findRaceCodeByCode(code: string): Observable<RaceCode> {
    console.log("findRaceCodeByCode");
    return this.http.get(environment.endpoint + '/api/common/raceCodes/' + code)
      .map((res: Response) => <RaceCode>res.json());
  }

  saveRaceCode(code: RaceCode) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/common/raceCodes', JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

// ====================================================================================================
// ETHNICITY CODES
// ====================================================================================================

  findEthnicityCodes(): Observable<EthnicityCode[]> {
    console.log("findEthinicityCodes()");
    return this.http.get(environment.endpoint + '/api/common/ethnicityCodes')
      .map((res: Response) => <RaceCode[]>res.json());
  }

  findEthnicityCodeByCode(code: string): Observable<EthnicityCode> {
    console.log("findEthnicityCodeByCode");
    return this.http.get(environment.endpoint + '/api/common/ethnicityCodes/' + code)
      .map((res: Response) => <EthnicityCode>res.json());
  }

// ====================================================================================================
// NATIONALITY CODES
// ====================================================================================================

  findNationalityCodes(): Observable<NationalityCode[]> {
    console.log("findNationalityCodes()");
    return this.http.get(environment.endpoint + '/api/common/nationalityCodes')
      .map((res: Response) => <RaceCode[]>res.json());
  }

  findNationalityCodeByCode(code: string): Observable<NationalityCode> {
    console.log("findNationalityCodeByCode");
    return this.http.get(environment.endpoint + '/api/common/nationalityCodes/' + code)
      .map((res: Response) => <NationalityCode>res.json());
  }

  // ====================================================================================================
  // DISABILITY CODES
  // ====================================================================================================

  findDisabilityCodes(): Observable<DisabilityCode[]> {
    console.log("findDisabilityCodes");
    return this.http.get(environment.endpoint + '/api/common/disabilityCodes')
      .map((res: Response) => <DisabilityCode[]>res.json());
  }

  findDisabilityCodeByCode(code: string): Observable<DisabilityCode> {
    console.log("findDisabilityCodeByCode");
    return this.http.get(environment.endpoint + '/api/common/disabilityCodes/' + code)
      .map((res: Response) => <DisabilityCode>res.json());
  }

  saveDisabilityCode(code: DisabilityCode) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/common/disabilityCodes', JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateDisabilityCode(code: DisabilityCode) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/common/disabilityCodes/' + code.code, JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeDisabilityCode(code: DisabilityCode) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/common/disabilityCodes/' + code.code, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

}
