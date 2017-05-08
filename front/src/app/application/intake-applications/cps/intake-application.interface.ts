import {ProgramLevel} from "../../../policy/program-levels/program-level.interface";
export interface IntakeApplication{
  id: number;
  startDate: Date;
  endDate: Date;
  employer:String;

  // transient
  current?:boolean;
}
