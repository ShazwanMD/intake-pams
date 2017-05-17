import {MetaObject} from "../../core/meta-object.interface";
export interface Education extends MetaObject {
  current: boolean;
  startDate: Date;
  endDate: Date,
  provider: string,
  
  // levelCode:EmploymentLevelCode;
  // sectorCode:EmploymentSectorCode;
}
