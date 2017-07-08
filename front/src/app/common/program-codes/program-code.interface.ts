import {GraduateCenter} from '../graduate-centers/graduate-center.interface';
import {FacultyCode} from '../faculty-codes/faculty-code.interface';
import {MetaObject} from '../../core/meta-object.interface';
import {ProgramLevel} from '../../shared/model/policy/program-level.interface';
export interface ProgramCode extends MetaObject {
  code: string;
  descriptionEn: string;
  descriptionMs: string;
  programLevel: ProgramLevel;
  facultyCode: FacultyCode;
  graduateCenter: GraduateCenter;
}
