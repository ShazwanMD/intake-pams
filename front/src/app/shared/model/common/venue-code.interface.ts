import {MetaObject} from "../../../core/meta-object.interface";
export interface VenueCode extends MetaObject{
  code:string;
  registrationDate:Date;
  registrationLocation:string;
  startTimeEn:string;
  startTimeMs:string;
  endTimeEn:string;
  endTimeMs:string;
}
