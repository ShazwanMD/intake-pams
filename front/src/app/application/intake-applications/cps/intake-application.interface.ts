import {ProgramLevel} from "../../../policy/program-levels/program-level.interface";
export interface IntakeApplicationPersonal{
  name:string;
  identityNo:string;
  birthdate:Date;
  programLevel:ProgramLevel;
}
