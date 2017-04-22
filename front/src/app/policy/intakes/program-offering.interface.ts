import {MetaObject} from "../../core/meta-object.interface";
import {ProgramCode} from "../../common/program-code.interface";
import {Intake} from "./intake.interface";
export interface ProgramOffering extends MetaObject {
  projection:number;
  interview:boolean;
  programCode:ProgramCode;
}
