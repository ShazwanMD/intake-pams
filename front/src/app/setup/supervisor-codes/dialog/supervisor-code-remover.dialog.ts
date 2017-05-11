import { SupervisorCode } from './../../../common/supervisor-codes/supervisor-code.interface';
import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";
import {SetupModuleState} from "../../index";
import {SetupActions} from "../../setup.action";



@Component({
  selector: 'pams-supervisor-code-remover',
  templateUrl: './supervisor-code-remover.dialog.html',
})

export class SupervisorCodeRemoverDialog implements OnInit {

  private createForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<SupervisorCodeRemoverDialog>,
              private store: Store<SetupModuleState>,
              private actions: SetupActions
  ) {
  }

  ngOnInit(): void {

    this.createForm = this.formBuilder.group(<SupervisorCode>{
      id: null,
      code: '',
     

    });
  }


    remove(code: SupervisorCode, isValid: boolean) {
    this.store.dispatch(this.actions.removeSupervisorCode(code));
    this.dialog.close();
  }

}
    
    