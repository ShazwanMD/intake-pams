import { Candidate } from './candidate.interface';
import { FlowState } from '../../../core/flow-state.enum';
import {Document} from '../../../core/document.interface';

export interface CandidateTask extends Document {
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