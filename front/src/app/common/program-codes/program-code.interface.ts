import { ProgramLevel } from './../../policy/program-levels/program-level.interface';
import { GraduateCentre } from './../graduate-centres/graduate-centre.interface';
import { FacultyCode } from './../faculty-codes/faculty-code.interface';
import { MetaObject } from "../../core/meta-object.interface";
export interface ProgramCode extends MetaObject {
  code: string;
  descriptionEn: string;
  descriptionMs: string;
  programLevel: ProgramLevel;
  facultyCode: FacultyCode;
  graduateCentre: GraduateCentre;
}
