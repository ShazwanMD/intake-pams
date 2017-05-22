import { SetupActions } from './../../../setup/setup.action';
import { SetupModuleState } from './../../../setup/index';
import {Component, Input, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {Store} from "@ngrx/store";
import {FormControl} from "@angular/forms";

import { ParliamentCode } from "../parliament-code.interface";



@Component({
  selector: 'pams-parliament-code-select',
  templateUrl: './parliament-code-select.component.html',
})
export class ParliamentCodeSelectComponent implements OnInit {

  private PARLIAMENT_CODE = "setupModuleState.parliamentCodes".split(".");
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;
  parliamentCodes$: Observable<ParliamentCode[]>;

  constructor(private store: Store<SetupModuleState>,
              private actions: SetupActions) {
    this.parliamentCodes$ = this.store.select(...this.PARLIAMENT_CODE);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findParliamentCodes());
  }

  selectChangeEvent(event: ParliamentCode) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

