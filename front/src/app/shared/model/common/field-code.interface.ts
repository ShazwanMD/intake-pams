import {MetaObject} from "../../../core/meta-object.interface";
import {FacultyCode} from './faculty-code.interface';
export interface FieldCode extends MetaObject{
  code:string;
  descriptionEn:string;
  descriptionMs:string;
}
