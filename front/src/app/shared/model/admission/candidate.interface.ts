import { Applicant } from '../../../secure/identity/applicant.interface';
import { BidStatus } from '../application/bid-status.enum';
import {StudyMode} from '../common/study-mode.interface';
import {Intake} from '../policy/intake.interface';
import {IntakeApplication} from '../application/intake-application.interface';
import {SupervisorOffering} from '../policy/supervisor-offering.interface';
import {ProgramOffering} from '../policy/program-offering.interface';
import {MetaObject} from '../../../core/meta-object.interface';
export interface Candidate extends MetaObject{
  name: string;
  identityNo: string;
  matricNo: string;
  email: string;
  status: BidStatus;
  acception : boolean;
  studyMode: StudyMode;
  intake: Intake;
  applicant: Applicant;
  programSelection?: ProgramOffering;
  supervisorOffering?: SupervisorOffering;
  application?: IntakeApplication;
  reason: string;
}
