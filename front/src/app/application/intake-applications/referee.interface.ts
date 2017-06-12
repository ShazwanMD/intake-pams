import {MetaObject} from "../../core/meta-object.interface";
import {RefereeType} from "./referee-type.enum";
export interface Referee extends MetaObject {
  id: number;
  name: string;
  officeAddrs: string;
  occupation: string;
  phoneNo: string;
  refereeType: RefereeType;


  selected?: boolean;
}
