
import {MetaObject} from "../../core/meta-object.interface";
import {AddressType} from "./address-type.enum";
import {ResultType} from "./result-type.enum";
export interface BachelorResult extends MetaObject {
  matricNo: string;
  year: number;
  resultType: ResultType;
  cgpa: number;

}
