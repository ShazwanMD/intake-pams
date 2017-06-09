import {MetaObject} from "../../core/meta-object.interface";
import {IntakeSession} from "../intake-sessions/intake-session.interface";
import {GraduateCenter} from "../../common/graduate-centers/graduate-center.interface";
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
  intakeSession:IntakeSession;
  graduateCenter:GraduateCenter;

  // transient
  applied?:boolean;
  intakeApplicationReferenceNo?:string;
}
