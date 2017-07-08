import {FlowState} from "../../../core/flow-state.enum";
import {Intake} from "./intake.interface";
export interface IntakeTask {
  taskId:string;
  taskName:string;
  candidate:string;
  assignee:string;
  referenceNo: string;
  sourceNo: string;
  accountCode: string;
  description: string;
  projection: number;
  startDate: number;
  endDate: number;
  candidateCount?:number;
  intake: Intake;
  flowState:FlowState;
}
