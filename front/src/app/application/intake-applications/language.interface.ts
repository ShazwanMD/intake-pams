import {MetaObject} from "../../core/meta-object.interface";
import {LanguageCode} from "../../common/language-codes/language-code.interface";
export interface Language extends MetaObject {
  languageCode: LanguageCode;
  oral: number,
  written: number,
}
