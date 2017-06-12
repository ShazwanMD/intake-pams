import {SubjectCode} from '../../common/subject-codes/subject-code.interface';
import {SpmResult} from './spm-result.interface';
import {MetaObject} from "../../core/meta-object.interface";
export interface SpmResult extends MetaObject {
  name: string;
  year: number;
  grade: string;
  subjectCode: SubjectCode;
  aggregate: number;
}
