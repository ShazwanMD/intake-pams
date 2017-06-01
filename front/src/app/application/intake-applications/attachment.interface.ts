import {MetaObject} from "../../core/meta-object.interface";
export interface Attachment extends MetaObject {
  id:number;
  name: string;
  mimeType: string;
  size: number;

  // transient
  selected?:boolean;
}
