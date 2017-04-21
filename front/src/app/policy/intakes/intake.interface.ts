import {MetaObject} from "../../core/meta-object.interface";
import {IntakeSession} from "./intake-session.interface";
export interface Intake extends MetaObject{

  id: number;
  referenceNo: string;
  sourceNo: string;
  description: string;
  projection: number;
  startDate: Date;
  endDate: Date;
  intakeSession:IntakeSession;
}
