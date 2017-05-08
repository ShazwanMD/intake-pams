import {FlowState} from "../../core/flow-state.enum";
import {Program} from "./program.interface";

export interface ProgramOfferingTask {
  
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
  program: Program;
  flowState:FlowState;
}
