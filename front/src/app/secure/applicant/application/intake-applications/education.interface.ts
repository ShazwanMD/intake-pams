import {MetaObject} from '../../../../core/meta-object.interface';

export interface Education extends MetaObject {
  id: number;
  entryDate: Date;
  graduationDate: Date;
  courseName: String;
  schoolName: String;
  current: boolean;
  startDate: Date;
  endDate: Date;
  provider: string;
}
