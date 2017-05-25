import {MetaObject} from "../../core/meta-object.interface";
export interface Referee extends MetaObject {
  name: string;
  officeAddrs: string;
  occupation: string,
  phoneNo: string,

  // levelCode:EmploymentLevelCode;
  // sectorCode:EmploymentSectorCode;
// } fieldCode:EmploymentFieldCode;
}
