import {MetaObject} from "../../../core/meta-object.interface";
import { SupervisorCode } from "./supervisor-code.interface";
import { ProgramLevel } from "../policy/program-level.interface";
export interface SupervisorOffering extends MetaObject{
  supervisorCode : SupervisorCode;
  programLevel : ProgramLevel;
}
