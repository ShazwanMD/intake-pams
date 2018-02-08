import { AbstractControl } from "@angular/forms";

export class PasswordValidation {

    public static passwordsMatch(password: string, confirmPassword: string) {
        return (AC: AbstractControl) : { [s: string]: boolean } =>{
       console.log(password,confirmPassword);
       if (AC.get('password').value !== AC.get('confirmPassword').value) {
        return { 'passwordMismatch': true }
      } else {
        //it always gets here no matter what
        return null;
      }
  }
    }
}
