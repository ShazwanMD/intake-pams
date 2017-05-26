import {Intake} from "../../policy/intakes/intake.interface";
import {Applicant} from "../../identity/applicant.interface";
import {ProgramOffering} from "../../policy/intakes/program-offering.interface";
import {SupervisorOffering} from "../../policy/intakes/supervisor-offering.interface";
import {StudyModeOffering} from "../../policy/intakes/study-mode-offering.interface";
import {MetaObject} from "../../core/meta-object.interface";
export interface IntakeApplication extends MetaObject{
  referenceNo: string;
  rank: number;
  merit: number;
  name: string;
  credentialNo: string;
  okuNo: string;
  email: string;
  phone: string;
  fax: string;
  age: number;

  paid: boolean;
  verified: boolean;
  sponsored: boolean;
  selfSponsored: boolean;
  applicant: Applicant;
  intake: Intake;

  programSelection?: ProgramOffering;
  supervisorSelection?: SupervisorOffering;
  studyModeSelection?: StudyModeOffering;
}
