import {GraduateCenter} from './graduate-center.interface';
import {FieldCode} from './field-code.interface';
import {MetaObject} from '../../../core/meta-object.interface';
import {ProgramCode} from './program-code.interface';
export interface ProgramFieldCode extends MetaObject {
  code: string;
  fieldCode:FieldCode;
  programCode:ProgramCode;
}
