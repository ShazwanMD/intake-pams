import {StudyMode} from '../../../common/study-modes/study-mode.interface';
import {Intake} from '../policy/intake.interface';
import {IntakeApplication} from '../application/intake-application.interface';
import {SupervisorOffering} from '../policy/supervisor-offering.interface';
import {ProgramOffering} from '../policy/program-offering.interface';
export interface Candidate {
  name: string;
  identityNo: string;
  matricNo: string;
  email: string;
  studyMode: StudyMode;
  intake: Intake;
  programOffering?: ProgramOffering;
  supervisorOffering?: SupervisorOffering;
  application?: IntakeApplication;
}
