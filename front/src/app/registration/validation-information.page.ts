import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {FormBuilder, FormGroup} from "@angular/forms";
import { UserRegistration } from "./user-registration.interface";

import {Store} from "@ngrx/store";
import {RegistrationModuleState} from "./index";
import {RegistrationActions} from "./registration.action";

@Component({
  selector: 'pams-validation-information-page',
  templateUrl: './validation-information.page.html',
})

  export class ValidationInformationPage{ 
  //implements OnInit {

  private validationForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private store: Store<RegistrationModuleState>,
              private registrationActions:RegistrationActions
              ) {
  }
  
  getDate()
  {
      
     // Date now = new Date();

      var date = new Date();
      
      var expiryDate = Date.now() + date.getDate()+3;
      
      

//      var span = document.createElement("span");
//
//      span.innerText = "getDate Method \n Today Date is-> " + date.getDate() + "\n";
//
//      document.body.appendChild(span);

  }
  
  
 token(){
    ////// email+expiryDate = token;
 } 

  ngOnInit(): void {
    this.route.params.subscribe((params: { email: string }) => {


       let email: string = params.email;
        
//        Date date = Date.now() + (3);
    
        var CryptoJS = require("crypto-js");
    
        var data = [{id: 1}, {id: 2}]

        // Encrypt 
        var ciphertext = CryptoJS.AES.encrypt(JSON.stringify(data), 'secret key 123');

        // Decrypt 
        var bytes  = CryptoJS.AES.decrypt(ciphertext.toString(), 'secret key 123');
        var decryptedData = JSON.parse(bytes.toString(CryptoJS.enc.Utf8));

        console.log(decryptedData);      




    
     

//       trigger validation wording to email

//      if (null != email) 
//          this.store.dispatch(this.actions.(email));
   });
  }

      validationInfo() {
  }
}
