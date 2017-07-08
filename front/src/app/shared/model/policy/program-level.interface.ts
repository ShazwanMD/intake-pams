import {MetaObject} from "../../../core/meta-object.interface";
export interface ProgramLevel extends MetaObject{
  code: string;
  prefix: string;
  description: string;
}
