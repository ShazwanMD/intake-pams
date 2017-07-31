import { FormControl, FormGroup } from '@angular/forms'

export class Checkpassword {
    static checkPasswordLength(control: FormControl){
        if(control.value.length > 0 && control.value.length < 5 ) return {smallPassword: true};
        return null;
    }

    static isSamePassword(group: FormGroup){
        let newpassword = group.controls['newpassword'].value;
        let confirmPassword = group.controls['confirmPassword'].value;

        if(newpassword !== confirmPassword){
            return {notSamePassword: true};
        } 
       // console.dir(group.controls);

        return null;
    }
}