import {StudyMode} from "../common/study-modes/study-mode.interface";
import {Intake} from "../policy/intakes/intake.interface";
import {IntakeApplication} from "../secure/applicant/application/intake-applications/intake-application.interface";
import {SupervisorOffering} from "../policy/intakes/supervisor-offering.interface";
import {ProgramOffering} from "../policy/intakes/program-offering.interface";
export interface Candidate {
  name: string;
  identityNo: string;
  matricNo: string;
  email: string;
  studyMode: StudyMode;
  intake: Intake;
  programOffering?:ProgramOffering;
  supervisorOffering?:SupervisorOffering;
  application?: IntakeApplication;
}
