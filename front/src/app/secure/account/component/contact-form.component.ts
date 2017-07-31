import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { Checkpassword } from "./check-password";
import { OnInit, Component } from "@angular/core";

@Component({
  selector: 'app-contact-form',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.css']
})
export class ContactFormComponent implements OnInit {

  signUpForm: FormGroup;
  constructor(fb: FormBuilder) {
      this.signUpForm = fb.group({
          oldpassword: ['', Validators.compose([
            Validators.required,
            Checkpassword.checkPasswordLength
          ])],
          passwords: fb.group({
            newpassword1: ['', Validators.required],
            newpassword2: ['', Validators.required]
          },{validator: Checkpassword.isSamePassword})    
      });
  }

  ngOnInit() {
  }

  onSubmit(){
    console.dir(this.signUpForm.controls);
  }

}