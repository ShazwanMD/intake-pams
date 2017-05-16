import {Intake} from "../../policy/intakes/intake.interface";
import {Applicant} from "../../identity/applicant.interface";
import { ProgramOffering } from "../../policy/intakes/program-offering.interface";
export interface IntakeApplication {
  referenceNo:string;
  rank:number;
  merit:number;
  name:string;
  credentialNo:string;
  okuNo:string;
  phone:string;
  fax:string;
  age:number;
  applicant:Applicant;
  intake:Intake;
  programOffering: ProgramOffering;

}
