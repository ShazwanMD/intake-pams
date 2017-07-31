import { FormGroup } from "@angular/forms";

export function matchingPasswords(passwordKey: string, confirmPasswordKey: string) {
    return (group: FormGroup): {
        [key: string]: any
    } => {
        let newPassword = group.controls[passwordKey];
        let confirmPassword = group.controls[confirmPasswordKey];

        if (newPassword.value !== confirmPassword.value) {
            return {
                mismatchedPasswords: true
            };
        }
    }
}