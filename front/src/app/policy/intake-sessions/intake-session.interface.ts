import {MetaObject} from "../../core/meta-object.interface";
export interface IntakeSession extends MetaObject{
  code: string;
  label: string;
  descriptionMs: string;
  descriptionEn: string;
  current: boolean;
  year: number;

  page: number;
  maxPage: number;
  pageSize: number;
  total: number;
  fromRow: number;
  toRow: number;
}
