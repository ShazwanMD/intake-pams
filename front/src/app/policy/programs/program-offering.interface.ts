import {MetaObject} from "../../core/meta-object.interface";
import {ProgramCode} from "../../common/program-codes/program-code.interface";

export interface ProgramOffering extends MetaObject {
  projection:number;
  interview:boolean;
  programCode:ProgramCode;
}
