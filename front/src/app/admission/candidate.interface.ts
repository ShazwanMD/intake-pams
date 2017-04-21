import {StudyMode} from "../common/study-mode.interface";
import {Intake} from "../policy/intakes/intake.interface";
import {IntakeApplication} from "../application/intake-applications/intake-application.interface";
export interface Candidate {
  name: string;
  identityNo: string;
  matricNo: string;
  email: string;
  studyMode: StudyMode;
  intake: Intake;
  application?: IntakeApplication;

}
