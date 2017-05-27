import {MetaObject} from "../../core/meta-object.interface";
import {AddressType} from "./address-type.enum";
export interface Address extends MetaObject {
  address1: string;
  address2: string;
  address3: string;
  postcode: string;
  addressType:AddressType;
}
