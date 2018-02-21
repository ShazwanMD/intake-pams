import { Candidate } from './candidate.interface';
import { FlowState } from '../../../core/flow-state.enum';

export interface CandidateTask {
    taskId:string;
    taskName:string;
    candidate:string;
    assignee:string;
    referenceNo: string;
    sourceNo: string;
    accountCode: string;
    descriptionEn: string;
    descriptionMs: string;
    projection: number;
    startDate: number;
    endDate: number;
    candidateCount?:number;
    candidateIntake: Candidate;
    flowState:FlowState;

}