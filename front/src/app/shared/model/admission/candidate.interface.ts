import { Applicant } from '../../../secure/identity/applicant.interface';
import { BidStatus } from '../application/bid-status.enum';
import {StudyMode} from '../common/study-mode.interface';
import {Intake} from '../policy/intake.interface';
import {IntakeApplication} from '../application/intake-application.interface';
import {SupervisorOffering} from '../policy/supervisor-offering.interface';
import {ProgramOffering} from '../policy/program-offering.interface';
export interface Candidate {
  name: string;
  identityNo: string;
  matricNo: string;
  email: string;
  status: BidStatus;
  studyMode: StudyMode;
  intake: Intake;
  applicant: Applicant;
  programOffering?: ProgramOffering;
  supervisorOffering?: SupervisorOffering;
  application?: IntakeApplication;
}
