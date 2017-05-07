import {MetaObject} from "../../core/meta-object.interface";
import {GraduateCentre} from "../../common/graduate-centres/graduate-centre.interface";
import {ProgramLevel} from "../program-levels/program-level.interface";
export interface Intake extends MetaObject{

  id: number;
  referenceNo: string;
  sourceNo: string;
  description: string;
  projection: number;
  startDate: Date;
  endDate: Date;
  programLevel:ProgramLevel;
  graduateCentre:GraduateCentre;

  // transient
  applied?:boolean;
}
