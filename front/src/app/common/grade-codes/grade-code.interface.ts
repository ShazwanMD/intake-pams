import {MetaObject} from "../../core/meta-object.interface";
export interface GradeCode extends MetaObject{
    code:string;
    description:string;
    ordinal: number;
}
