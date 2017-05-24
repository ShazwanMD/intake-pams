import {MetaObject} from "../../core/meta-object.interface";
import {ProgramCode} from "../../common/program-codes/program-code.interface";
export interface ProgramOffering extends MetaObject {
  id:number;
  projection:number;
  interview:boolean;
  generalCriteria:string;
  specificCriteria:string;
  programCode:ProgramCode;
}
