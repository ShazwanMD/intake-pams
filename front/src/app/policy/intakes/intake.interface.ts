import {MetaObject} from "../../core/meta-object.interface";
import {IntakeSession} from "../intake-sessions/intake-session.interface";
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
  intakeSession:IntakeSession;
  graduateCentre:GraduateCentre;

  // transient
  applied?:boolean;
}
