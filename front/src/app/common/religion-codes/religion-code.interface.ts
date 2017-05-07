import {MetaObject} from "../../core/meta-object.interface";
export interface ReligionCode extends MetaObject{
    code:string;
    prefix:string;
    name:string;
    descriptionEn:string;
    descriptionMs:string;
}
