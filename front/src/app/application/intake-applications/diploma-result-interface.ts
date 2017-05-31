import {MetaObject} from "../../core/meta-object.interface";
import {ResultType} from "./result-type.enum";
export interface DiplomaResult extends MetaObject {
  name: string;
  year: number;
  resultType: ResultType;
  cgpa: number;

}
