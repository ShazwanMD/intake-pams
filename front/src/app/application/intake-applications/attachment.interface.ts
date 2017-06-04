import {MetaObject} from "../../core/meta-object.interface";
import { AttachmentType } from "./attachment-type.enum";
export interface Attachment extends MetaObject {
  id:number;
  name: string;
  mimeType: string;
  size: number;
  attachmentType:AttachmentType;

  // transient
  selected?:boolean;
}
