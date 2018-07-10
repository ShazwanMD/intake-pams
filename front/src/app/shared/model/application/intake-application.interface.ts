import { Attachment } from './attachment.interface';
import { CountryCode } from '../common/country-code.interface';
import { StateCode } from '../common/state-code.interface';
import {EthnicityCode} from '../common/ethnicity-code.interface';
import {DisabilityCode} from '../common/disability-code.interface';
import {NationalityCode} from '../common/nationality-code.interface';
import {MaritalCode} from '../common/marital-code.interface';
import {RaceCode} from '../common/race-code.interface';
import {ReligionCode} from '../common/religion-code.interface';
import {StudyCenterCode} from '../common/study-center-code.interface';
import {Intake} from '../policy/intake.interface';
import {Applicant} from '../../../secure/identity/applicant.interface';
import {ProgramOffering} from '../policy/program-offering.interface';
import {SupervisorOffering} from '../policy/supervisor-offering.interface';
import {StudyModeOffering} from '../policy/study-mode-offering.interface';
import {MetaObject} from '../../../core/meta-object.interface';
import {GenderCode} from '../common/gender-code.interface';
import {PromoCode} from '../common/promo-code.interface';
import {BidStatus} from './bid-status.enum';
import {BidType} from './bid-type.enum';

export interface IntakeApplication extends MetaObject {
    id: number;
  referenceNo: string;
  promoCode?: PromoCode;
  researchTitle: string;
  rank: number;
  merit: number;
  name: string;
  credentialNo: string;
  passExpDate: Date;
  okuNo: string;
  email: string;
  reason: string;
  phone: string;
  mobile: string;
  fax: string;
  age: number;
  birthDate: Date;
  gender: string;
  religion: string;
  race: string;
  marital: string;

  mailingAddress1: string;
  mailingAddress2: string;
  mailingAddress3: string;
  mailingPostcode: string;
  officialAddress1: string;
  officialAddress2: string;
  officialAddress3: string;
  officialPostcode: string;

  paid: boolean;
  declared: boolean;
  verified: boolean;
  sponsored: boolean;
  selfSponsored: boolean;
  processingReceipt: boolean;
  foreignResult: boolean;
  educationResult: boolean;
  academic: boolean;
  refereeForm: boolean;
  bankStatement: boolean;
  researchProposal: boolean;
  financialLetter: boolean;

  spmResultAttached: boolean;
  stpmResultAttached: boolean;
  diplomaResultAttached: boolean;
  bachelorResultAttached: boolean;
  masterResultAttached: boolean;
  phdResultAttached: boolean;
  toeflResultAttached: boolean;
  ieltsResultAttached: boolean;
  languageResultAttached: boolean;
  processingFeeAttached: boolean;
  bankStatementAttached: boolean;
  refereeFormAttached: boolean;
  researchProposalAttached: boolean;
  sponsorLetterAttached: boolean;

  bidType: BidType;
  bidStatus: BidStatus;

  applicant: Applicant;
  intake: Intake;
  nationalityCode: NationalityCode;
  maritalCode: MaritalCode;
  studyCenterCode: StudyCenterCode;
  disabilityCode: DisabilityCode;
  ethnicityCode: EthnicityCode;
  religionCode: ReligionCode;
  genderCode: GenderCode;
  raceCode: RaceCode;
  mailingStateCode: StateCode;
  mailingCountryCode: CountryCode;
  officialStateCode: StateCode;
  officialCountryCode: CountryCode;
  programSelection?: ProgramOffering;
  supervisorSelection?: SupervisorOffering;
  studyModeSelection?: StudyModeOffering;

  attachment?: Attachment;
}
