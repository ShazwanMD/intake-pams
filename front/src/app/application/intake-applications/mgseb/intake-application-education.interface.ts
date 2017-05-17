import {ProgramLevel} from "../../../policy/program-levels/program-level.interface";
export interface IntakeApplicationEducation{

  id: number;
  entryDate: Date;
  graduationDate: Date;
  courseName : String;
  schoolName : String;


    // transient
  current?:boolean;
}
