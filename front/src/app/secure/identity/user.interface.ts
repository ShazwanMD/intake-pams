import {Principal} from './principal.interface';
export interface User extends Principal{
  id: number;
  email: string;
  password: string;
  realName: string;
}
