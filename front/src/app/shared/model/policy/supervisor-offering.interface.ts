import {MetaObject} from "../../../core/meta-object.interface";
import {SupervisorCode} from "../common/supervisor-code.interface";
import { ProgramLevel } from "./program-level.interface";
export interface SupervisorOffering extends MetaObject {
  supervisorCode:SupervisorCode;
  programLevel: ProgramLevel;
}
