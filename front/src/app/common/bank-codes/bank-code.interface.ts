import {MetaObject} from "../../core/meta-object.interface";
export interface BankCode extends MetaObject{
    code:string;
    prefix:string;
    description:string;
}
