import {MetaObject} from "../../core/meta-object.interface";
import {IntakeSession} from "./intake-session.interface";
export interface Intake extends MetaObject{

  id: number;
  referenceNo: string;
  sourceNo: string;
  description: string;
  paid: Boolean;
  totalPretaxAmount: number;
  totalTaxAmount: number;
  totalAmount: number;
  balanceAmount: number;
  intakeSession:IntakeSession;
}
