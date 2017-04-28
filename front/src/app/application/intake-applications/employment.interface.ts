import {MetaObject} from "../../core/meta-object.interface";
export interface Employment extends MetaObject {
  current: boolean;
  startDate: Date;
  endDate: Date,
  employer: string,
  // levelCode:EmploymentLevelCode;
  // sectorCode:EmploymentSectorCode;
// } fieldCode:EmploymentFieldCode;
}
