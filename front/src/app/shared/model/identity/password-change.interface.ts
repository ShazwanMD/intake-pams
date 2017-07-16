import {User} from '../../../secure/identity/user.interface';

export interface PasswordChange {
  user: User;
  newPassword: string;
  currentPassword: string;
}
