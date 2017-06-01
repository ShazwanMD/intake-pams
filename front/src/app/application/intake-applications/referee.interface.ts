import {MetaObject} from "../../core/meta-object.interface";
export interface Referee extends MetaObject {
  id:number;
  name: string;
  officeAddrs: string;
  occupation: string;
  phoneNo: string;


  selected?:boolean;
}
