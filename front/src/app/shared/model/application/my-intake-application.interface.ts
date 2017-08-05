import { Candidate } from './../admission/candidate.interface';
import { Intake } from './../policy/intake.interface';
import {MetaObject} from '../../../core/meta-object.interface';
import { BidStatus } from "./bid-status.enum";
export interface MyIntakeApplication extends MetaObject {
  
  bidStatus: BidStatus;
  referenceNo: String; 
  intake: Intake;
  candidate: Candidate;
}
