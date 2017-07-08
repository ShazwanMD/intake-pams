import {ParliamentCode} from '../app/common/parliament-codes/parliament-code.interface';
import {StudyCenterCode} from '../app/common/study-center-codes/study-center-code.interface';
import {StudyMode} from '../app/common/study-modes/study-mode.interface';
import {NationalityCode} from '../app/common/nationality-codes/nationality-code.interface';
import {EthnicityCode} from '../app/common/ethnicity-codes/ethnicity-code.interface';
import {RaceCode} from '../app/common/race-codes/race-code.interface';
import {StateCode} from '../app/common/state-codes/state-code.interface';
import {SupervisorCode} from '../app/common/supervisor-codes/supervisor-code.interface';
import {CountryCode} from '../app/common/country-codes/country-code.interface';
import {ReligionCode} from '../app/common/religion-codes/religion-code.interface';
import {GenderCode} from '../app/common/gender-codes/gender-code.interface';
import {Injectable} from '@angular/core';
import {Response, Http, Headers, RequestOptions} from '@angular/http';
import {HttpInterceptorService} from '@covalent/http';
import {Observable} from 'rxjs';
import {FacultyCode} from '../app/common/faculty-codes/faculty-code.interface';
import {environment} from '../environments/environment';
import {ProgramCode} from '../app/common/program-codes/program-code.interface';
import {GraduateCenter} from '../app/common/graduate-centers/graduate-center.interface';
import {MaritalCode} from '../app/common/marital-codes/marital-code.interface';
import {DunCode} from '../app/common/dun-codes/dun-code.interface';
import {BankCode} from '../app/common/bank-codes/bank-code.interface';
import {DisabilityCode} from '../app/common/disability-codes/disability-code.interface';
import {SchoolCode} from '../app/common/school-codes/school-code.interface';
import {DistrictCode} from '../app/common/district-codes/district-code.interface';
import {ResidencyCode} from '../app/common/residency-codes/residency-code.interface';
import {LanguageCode} from '../app/common/language-codes/language-code.interface';
import {SubjectCode} from '../app/common/subject-codes/subject-code.interface';
import {GradeCode} from '../app/common/grade-codes/grade-code.interface';
import {ProgramLevel} from '../app/shared/model/policy/program-level.interface';
import {AuthenticationService} from './authentication.service';

@Injectable()
export class CommonService {

  constructor(private http: Http,
              private _http: HttpInterceptorService,
              private authnService: AuthenticationService) {
  }

  // ====================================================================================================
  // BANK CODES
  // ====================================================================================================

  findBankCodes(): Observable<BankCode[]> {
    console.log('findBankCodes');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/bankCodes', options)
      .map((res: Response) => <BankCode[]>res.json());
  }

  findBankCodeByCode(code: string): Observable<BankCode> {
    console.log('findBankCodeByCode');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/bankCodes/' + code, options)
      .map((res: Response) => <BankCode>res.json());
  }

  // ====================================================================================================
  // DISTRICT CODES
  // ====================================================================================================

  findDistrictCodes(): Observable<DistrictCode[]> {
    console.log('findDistrictCodes');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/districtCodes', options)
      .map((res: Response) => <DistrictCode[]>res.json());
  }

  findDistrictCodeByCode(code: string): Observable<DistrictCode> {
    console.log('findDistrictCodeByCode');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/districtCodes/' + code, options)
      .map((res: Response) => <DistrictCode>res.json());
  }

  saveDistrictCode(code: DistrictCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/common/districtCodes', JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateDistrictCode(code: DistrictCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/common/districtCodes/' + code.code, JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeDistrictCode(code: DistrictCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/common/districtCodes/' + code.code, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // DUN CODES
  // ====================================================================================================

  findDunCodes(): Observable<DunCode[]> {
    console.log('findDunCodes');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/dunCodes', options)
      .map((res: Response) => <DunCode[]>res.json());
  }

  findDunCodeByCode(code: string): Observable<DunCode> {
    console.log('findDunCodeByCode');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/dunCodes/' + code, options)
      .map((res: Response) => <DunCode>res.json());
  }

  saveDunCode(code: DunCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/common/dunCodes', JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateDunCode(code: DunCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/common/dunCodes/' + code.code, JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeDunCode(code: DunCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/common/dunCodes/' + code.code, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // PARLIAMENT CODES
  // ====================================================================================================

  findParliamentCodes(): Observable<ParliamentCode[]> {
    console.log('findParliamentCodes');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/parliamentCodes', options)
      .map((res: Response) => <ParliamentCode[]>res.json());
  }

  findParliamentCodeByCode(code: string): Observable<ParliamentCode> {
    console.log('findParliamentCodeByCode');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/parliamentCodes/' + code, options)
      .map((res: Response) => <ParliamentCode>res.json());
  }

  saveParliamentCode(code: ParliamentCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/common/parliamentCodes', JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateParliamentCode(code: ParliamentCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/common/parliamentCodes/' + code.code, JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeParliamentCode(code: ParliamentCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/common/parliamentCodes/' + code.code, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // GENDER CODES
  // ====================================================================================================

  findGenderCodes(): Observable<GenderCode[]> {
    console.log('findGenderCodes');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/genderCodes', options)
      .map((res: Response) => <GenderCode[]>res.json());
  }

  findGenderCodeByCode(code: string): Observable<GenderCode> {
    console.log('findGenderCodeByCode');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/genderCodes/' + code, options)
      .map((res: Response) => <GenderCode>res.json());
  }

  saveGenderCode(code: GenderCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/common/genderCodes', JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // MARITAL CODES
  // ====================================================================================================

  findMaritalCodes(): Observable<MaritalCode[]> {
    console.log('findMaritalCodes');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/maritalCodes', options)
      .map((res: Response) => <MaritalCode[]>res.json());
  }

  findMaritalCodeByCode(code: string): Observable<MaritalCode> {
    console.log('findMaritalCodeByCode');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/maritalCodes/' + code, options)
      .map((res: Response) => <MaritalCode>res.json());
  }

  saveMaritalCode(code: MaritalCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/common/maritalCodes', JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateMaritalCode(code: MaritalCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/common/maritalCodes/' + code.code, JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeMaritalCode(code: MaritalCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/common/maritalCodes/' + code.code, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // LANGUAGE CODES
  // ====================================================================================================

  findLanguageCodes(): Observable<LanguageCode[]> {
    console.log('findLanguageCodes');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/languageCodes', options)
      .map((res: Response) => <LanguageCode[]>res.json());
  }

  findLanguageCodeByCode(code: string): Observable<LanguageCode> {
    console.log('findLanguageCodeByCode');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/languageCodes/' + code, options)
      .map((res: Response) => <LanguageCode>res.json());
  }

  saveLanguageCode(code: LanguageCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/common/languageCodes', JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateLanguageCode(code: LanguageCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/common/languageCodes/' + code.code, JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeLanguageCode(code: LanguageCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/common/languageCodes/' + code.code, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // GRADUATE CENTER
  // ====================================================================================================

  findGraduateCenters(): Observable<GraduateCenter[]> {
    console.log('findGraduateCenters');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/graduateCenters', options)
      .map((res: Response) => <GraduateCenter[]>res.json());
  }

  findGraduateCenterByCode(code: string): Observable<GraduateCenter> {
    console.log('findGraduateCenterByCode');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/graduateCenters/' + code, options)
      .map((res: Response) => <GraduateCenter>res.json());
  }

  findProgramCodesByGraduateCenter(graduateCenter: GraduateCenter): Observable<ProgramCode[]> {
    console.log('findProgramCodesByGraduateCenter');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/graduateCenters/' + graduateCenter.code + '/programCodes', options)
      .map((res: Response) => <ProgramCode[]>res.json());
  }

  saveGraduateCenter(code: GraduateCenter): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/common/graduateCenters', JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateProgramCode(code: ProgramCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/common/programCodes/' + code.code, JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // FACULTY CODES
  // ====================================================================================================

  findFacultyCodes(): Observable<FacultyCode[]> {
    console.log('findFacultyCodes');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/facultyCodes', options)
      .map((res: Response) => <FacultyCode[]>res.json());
  }

  findFacultyCodeByCode(code: string): Observable<FacultyCode> {
    console.log('findFacultyCodeByCode');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/facultyCodes/' + code, options)
      .map((res: Response) => <FacultyCode>res.json());
  }

  saveFacultyCode(code: FacultyCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/common/facultyCodes', JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateFacultyCode(code: FacultyCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/common/facultyCodes/' + code.code, JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeFacultyCode(code: FacultyCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/common/facultyCodes/' + code.code, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // PROGRAM CODES
  // ====================================================================================================

  findProgramCodes(): Observable<ProgramCode[]> {
    console.log('findProgramCodes');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/programCodes', options)
      .map((res: Response) => <ProgramCode[]>res.json());
  }

  findProgramCodeByCode(code: string): Observable<ProgramCode> {
    console.log('findProgramCodeByCode');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/programCodes/' + code, options)
      .map((res: Response) => <ProgramCode>res.json());
  }

  findProgramCodesByProgramLevel(programLevel: ProgramLevel): Observable<ProgramCode> {
    console.log('findProgramCodeByProgramLevel :' + programLevel.code);
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/programCodes/programLevel/' + programLevel.code, options)
      .map((res: Response) => <ProgramCode>res.json());
  }

  saveProgramCode(code: ProgramCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/common/programCodes', JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeProgramCode(code: ProgramCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/common/programCodes/' + code.code, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // STUDY MODE
  // ====================================================================================================

  findStudyModes(): Observable<StudyMode[]> {
    console.log('findStudyModes');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/studyModes', options)
      .map((res: Response) => <StudyMode[]>res.json());
  }

  findStudyModeByCode(code: string): Observable<StudyMode> {
    console.log('findStudyModeByCode');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/studyModes/' + code, options)
      .map((res: Response) => <StudyMode>res.json());
  }

  saveStudyMode(code: StudyMode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/common/studyModes', JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateStudyMode(code: StudyMode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/common/studyModes/' + code.code, JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeStudyMode(code: StudyMode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/common/studyModes/' + code.code, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // RELIGION CODES
  // ====================================================================================================

  findReligionCodes(): Observable<ReligionCode[]> {
    console.log('findReligionCodes');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/religionCodes', options)
      .map((res: Response) => <ReligionCode[]>res.json());
  }

  findReligionCodeByCode(code: string): Observable<ReligionCode> {
    console.log('findReligionCodeByCode');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/religionCodes/' + code, options)
      .map((res: Response) => <ReligionCode>res.json());
  }

  saveReligionCode(code: ReligionCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/common/religionCodes', JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateReligionCode(code: ReligionCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/common/religionCodes/' + code.code, JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeReligionCode(code: ReligionCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/common/religionCodes/' + code.code, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

// ====================================================================================================
// COUNTRY CODES
// ====================================================================================================

  findCountryCodes(): Observable<CountryCode[]> {
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/countryCodes', options)
      .map((res: Response) => <CountryCode[]>res.json());
  }

  findCountryCodeByCode(code: string): Observable<CountryCode> {
    console.log('findCountryCodeByCode');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/countryCodes/' + code, options)
      .map((res: Response) => <CountryCode>res.json());
  }

  saveCountryCode(code: CountryCode): Observable<String> {
    let headers: Headers = new Headers({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.authnService.token,
      })
    ;
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/common/countryCodes', JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateCountryCode(code: CountryCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/common/countryCodes/' + code.code, JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeCountryCode(code: CountryCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/common/countryCodes/' + code.code, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

// ====================================================================================================
// SUPERVISOR CODES
// ====================================================================================================

  findSupervisorCodes(): Observable<SupervisorCode[]> {
    console.log('findSupervisorCodes()');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/supervisorCodes', options)
      .map((res: Response) => <SupervisorCode[]>res.json());
  }

  findSupervisorCodesByFilter(filter: string): Observable<SupervisorCode[]> {
    console.log('findSupervisorCodesByFilter');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/supervisorCodes/byFilter/' + filter, options)
      .map((res: Response) => <SupervisorCode[]>res.json());
  }

  findSupervisorCodeByCode(code: string): Observable<SupervisorCode> {
    console.log('findSupervisorCodeByCode');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/supervisorCodes/' + code, options)
      .map((res: Response) => <SupervisorCode>res.json());
  }

  saveSupervisorCode(code: SupervisorCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/common/supervisorCodes', JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeSupervisorCode(code: SupervisorCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/common/supervisorCodes/' + code.code, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateSupervisorCode(code: SupervisorCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/common/supervisorCodes/' + code.code, JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

// ====================================================================================================
// STATE CODES
// ====================================================================================================

  findStateCodes(): Observable<StateCode[]> {
    console.log('findStateCodes()');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/stateCodes', options)
      .map((res: Response) => <StateCode[]>res.json());
  }

  findStateCodeByCode(code: string): Observable<StateCode> {
    console.log('findStateCodeByCode');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/stateCodes/' + code, options)
      .map((res: Response) => <StateCode>res.json());
  }

  saveStateCode(code: StateCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/common/stateCodes', JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateStateCode(code: StateCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/common/stateCodes/' + code.code, JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeStateCode(code: StateCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/common/stateCodes/' + code.code, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

// ====================================================================================================
// RACE CODES
// ====================================================================================================

  findRaceCodes(): Observable<RaceCode[]> {
    console.log('findRaceCodes()');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/raceCodes', options)
      .map((res: Response) => <RaceCode[]>res.json());
  }

  findRaceCodeByCode(code: string): Observable<RaceCode> {
    console.log('findRaceCodeByCode');
    console.log('findRaceCodeByCode');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/raceCodes/' + code, options)
      .map((res: Response) => <RaceCode>res.json());
  }

  saveRaceCode(code: RaceCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/common/raceCodes', JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

// ====================================================================================================
// ETHNICITY CODES
// ====================================================================================================

  findEthnicityCodes(): Observable<EthnicityCode[]> {
    console.log('findEthnicityCodes');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/ethnicityCodes', options)
      .map((res: Response) => <EthnicityCode[]>res.json());
  }

  findEthnicityCodeByCode(code: string): Observable<EthnicityCode> {
    console.log('findEthnicityCodeByCode');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/ethnicityCodes/' + code, options)
      .map((res: Response) => <EthnicityCode>res.json());
  }

  saveEthnicityCode(code: EthnicityCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/common/ethnicityCodes', JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateEthnicityCode(code: EthnicityCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/common/ethnicityCodes/' + code.code, JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeEthnicityCode(code: EthnicityCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/common/ethnicityCodes/' + code.code, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // NATIONALITY CODES
  // ====================================================================================================

  findNationalityCodes(): Observable<NationalityCode[]> {
    console.log('findNationalityCodes');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/nationalityCodes', options)
      .map((res: Response) => <NationalityCode[]>res.json());
  }

  findNationalityCodeByCode(code: string): Observable<NationalityCode> {
    console.log('findNationalityCodeByCode');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/nationalityCodes/' + code, options)
      .map((res: Response) => <NationalityCode>res.json());
  }

  saveNationalityCode(code: NationalityCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/common/nationalityCodes', JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateNationalityCode(code: NationalityCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/common/nationalityCodes/' + code.code, JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeNationalityCode(code: NationalityCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/common/nationalityCodes/' + code.code, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // RESIDENCY CODES
  // ====================================================================================================

  findResidencyCodes(): Observable<ResidencyCode[]> {
    console.log('findResidencyCodes');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/residencyCodes', options)
      .map((res: Response) => <ResidencyCode[]>res.json());
  }

  findResidencyCodeByCode(code: string): Observable<ResidencyCode> {
    console.log('findResidencyCodeByCode');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/residencyCodes/' + code, options)
      .map((res: Response) => <ResidencyCode>res.json());
  }

  saveResidencyCode(code: ResidencyCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/common/residencyCodes', JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateResidencyCode(code: ResidencyCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/common/residencyCodes/' + code.code, JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeResidencyCode(code: ResidencyCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/common/residencyCodes/' + code.code, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // DISABILITY CODES
  // ====================================================================================================

  findDisabilityCodes(): Observable<DisabilityCode[]> {
    console.log('findDisabilityCodes');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/disabilityCodes', options)
      .map((res: Response) => <DisabilityCode[]>res.json());
  }

  findDisabilityCodeByCode(code: string): Observable<DisabilityCode> {
    console.log('findDisabilityCodeByCode');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/disabilityCodes/' + code, options)
      .map((res: Response) => <DisabilityCode>res.json());
  }

  saveDisabilityCode(code: DisabilityCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/common/disabilityCodes', JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateDisabilityCode(code: DisabilityCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/common/disabilityCodes/' + code.code, JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeDisabilityCode(code: DisabilityCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/common/disabilityCodes/' + code.code, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // SCHOOL CODES
  // ====================================================================================================

  findSchoolCodes(): Observable<SchoolCode[]> {
    console.log('findSchoolCodes');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/schoolCodes', options)
      .map((res: Response) => <SchoolCode[]>res.json());
  }

  findSchoolCodeByCode(code: string): Observable<SchoolCode> {
    console.log('findSchoolCodeByCode');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/schoolCodes/' + code, options)
      .map((res: Response) => <SchoolCode>res.json());
  }

  saveSchoolCode(code: SchoolCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/common/schoolCodes', JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateSchoolCode(code: SchoolCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/common/schoolCodes/' + code.code, JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeSchoolCode(code: SchoolCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/common/schoolCodes/' + code.code, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // STUDY CENTER CODES
  // ====================================================================================================

  findStudyCenterCodes(): Observable<StudyCenterCode[]> {
    console.log('findStudyCenterCodes');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/studyCenterCodes', options)
      .map((res: Response) => <StudyCenterCode[]>res.json());
  }

  findStudyCenterCodeByCode(code: string): Observable<StudyCenterCode> {
    console.log('findStudyCenterCodeByCode');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/studyCenterCodes/' + code, options)
      .map((res: Response) => <StudyCenterCode>res.json());
  }

  saveStudyCenterCode(code: StudyCenterCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/common/studyCenterCodes', JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateStudyCenterCode(code: StudyCenterCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/common/studyCenterCodes/' + code.code, JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeStudyCenterCode(code: StudyCenterCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/common/studyCenterCodes/' + code.code, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // SUBJECT CODES
  // ====================================================================================================

  findSubjectCodes(): Observable<SubjectCode[]> {
    console.log('findSubjectCodes');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/subjectCodes', options)
      .map((res: Response) => <SubjectCode[]>res.json());
  }

  findSubjectCodeByCode(code: string): Observable<SubjectCode> {
    console.log('findSubjectCodeByCode');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/subjectCodes/' + code, options)
      .map((res: Response) => <SubjectCode>res.json());
  }

  saveSubjectCode(code: SubjectCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/common/subjectCodes', JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateSubjectCode(code: SubjectCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/common/subjectCodes/' + code.code, JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeSubjectCode(code: SubjectCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/common/subjectCodes/' + code.code, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // GRADE CODES
  // ====================================================================================================

  findGradeCodes(): Observable<GradeCode[]> {
    console.log('findGradeCodes');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/gradeCodes', options)
      .map((res: Response) => <GradeCode[]>res.json());
  }

  findGradeCodeByCode(code: string): Observable<GradeCode> {
    console.log('findGradeCodeByCode');
    let headers: Headers = new Headers({'Authorization': 'Bearer ' + this.authnService.token});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/common/gradeCodes/' + code, options)
      .map((res: Response) => <GradeCode>res.json());
  }

  saveGradeCode(code: GradeCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/common/gradeCodes', JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateGradeCode(code: GradeCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/common/gradeCodes/' + code.code, JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeGradeCode(code: GradeCode): Observable<String> {
    let headers: Headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authnService.token,
    });
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.delete(environment.endpoint + '/api/common/gradeCodes/' + code.code, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }
}
