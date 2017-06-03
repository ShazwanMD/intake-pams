import { EthnicityCode } from './../../common/ethnicity-codes/ethnicity-code.interface';
import { DisabilityCode } from './../../common/disability-codes/disability-code.interface';
import { NationalityCode } from './../../common/nationality-codes/nationality-code.interface';
import { MaritalCode } from './../../common/marital-codes/marital-code.interface';
import { RaceCode } from './../../common/race-codes/race-code.interface';
import { ReligionCode } from './../../common/religion-codes/religion-code.interface';
import { StudyCenterCode } from './../../common/study-center-codes/study-center-code.interface';
import {Intake} from "../../policy/intakes/intake.interface";
import {Applicant} from "../../identity/applicant.interface";
import {ProgramOffering} from "../../policy/intakes/program-offering.interface";
import {SupervisorOffering} from "../../policy/intakes/supervisor-offering.interface";
import {StudyModeOffering} from "../../policy/intakes/study-mode-offering.interface";
import {MetaObject} from "../../core/meta-object.interface";
import { GenderCode } from "../../common/gender-codes/gender-code.interface";
import {BidStatus} from "./bid-status.enum";
import {BidType} from "./bid-type.enum";

export interface IntakeApplication extends MetaObject {
  referenceNo: string;
  researchTitle?: string;
  rank: number;
  merit: number;
  name: string;
  credentialNo: string;
  okuNo: string;
  email: string;
  phone: string;
  mobile: string;
  fax: string;
  age: number;
  birthDate: Date;
  gender: string;
  religion:string;
  race:string;
  marital:string;

  paid: boolean;
  verified: boolean;
  sponsored: boolean;
  selfSponsored: boolean;

  bidType:BidType;
  bidStatus:BidStatus;

  applicant: Applicant;
  intake: Intake;
  nationalityCode: NationalityCode;
  maritalCode: MaritalCode;
  studyCenterCode: StudyCenterCode;
  disabilityCode: DisabilityCode;
  ethnicityCode: EthnicityCode;
  religionCode : ReligionCode;
  genderCode : GenderCode;
  raceCode : RaceCode;
  programSelection?: ProgramOffering;
  supervisorSelection?: SupervisorOffering;
  studyModeSelection?: StudyModeOffering;
}
