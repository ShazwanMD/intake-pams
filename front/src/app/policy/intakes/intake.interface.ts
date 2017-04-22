import {MetaObject} from "../../core/meta-object.interface";
import {IntakeSession} from "../intake-sessions/intake-session.interface";
import {GraduateCentre} from "../../common/graduate-centre.interface";
export interface Intake extends MetaObject{

  id: number;
  referenceNo: string;
  sourceNo: string;
  description: string;
  projection: number;
  startDate: Date;
  endDate: Date;
  intakeSession:IntakeSession;
  graduateCentre:GraduateCentre;
}
