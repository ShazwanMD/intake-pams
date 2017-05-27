import { CountryCode } from './../../common/country-codes/country-code.interface';
import { StateCode } from './../../common/state-codes/state-code.interface';
import {MetaObject} from "../../core/meta-object.interface";
import {AddressType} from "./address-type.enum";
export interface Address extends MetaObject {
  address1: string;
  address2: string;
  address3: string;
  postcode: string;
  stateCode: StateCode;
  countryCode: CountryCode;
  addressType:AddressType;
}
