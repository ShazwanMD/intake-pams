import {FlowState} from "../../core/flow-state.enum";
export interface IntakeSessionTask {
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
  flowState:FlowState;
}
