import { Candidate } from './candidate.interface';
import { FlowState } from '../../../core/flow-state.enum';
import { StudyModeOffering } from "../policy/study-mode-offering.interface";
import { IntakeApplication } from "../application/intake-application.interface";
import { ProgramOffering } from "../policy/program-offering.interface";
import { IntakeSession } from "../policy/intake-session.interface";

export interface CandidateTask extends Document{
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
    matricNo: string;
    studyMode: StudyModeOffering;
    programSelection?: ProgramOffering;
    intakeSession: IntakeSession;
}