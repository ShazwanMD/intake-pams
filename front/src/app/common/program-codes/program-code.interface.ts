import { ProgramLevel } from './../../policy/program-levels/program-level.interface';
import { GraduateCenter } from '../graduate-centers/graduate-center.interface';
import { FacultyCode } from './../faculty-codes/faculty-code.interface';
import { MetaObject } from "../../core/meta-object.interface";
export interface ProgramCode extends MetaObject {
  code: string;
  descriptionEn: string;
  descriptionMs: string;
  programLevel: ProgramLevel;
  facultyCode: FacultyCode;
  graduateCenter: GraduateCenter;
}
