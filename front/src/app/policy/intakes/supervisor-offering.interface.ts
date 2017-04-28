import {MetaObject} from "../../core/meta-object.interface";
import {SupervisorCode} from "../../common/supervisor-codes/supervisor-code.interface";
export interface SupervisorOffering extends MetaObject {
  supervisorCode:SupervisorCode;
}
