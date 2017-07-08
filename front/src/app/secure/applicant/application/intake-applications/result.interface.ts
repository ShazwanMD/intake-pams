import {MetaObject} from '../../../../core/meta-object.interface';
import {ResultType} from './result-type.enum';
export interface Result extends MetaObject {
  id: number;
  name: string;
  field: string;
  graduationYear: number;
  resultAlphanumeric: string;
  resultNumeric: number;
  malayResult: string;
  englishResult: string;
  resultType: ResultType;

  selected?: boolean;
}
