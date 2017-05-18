import {MetaObject} from "../../core/meta-object.interface";
export interface IntakeSession extends MetaObject{
  code: string;
  label: string;
  descriptionMs: string;
  descriptionEn: string;
  current: boolean;
  year: number;
  id: number;
}
