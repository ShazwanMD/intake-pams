import {Component, Input, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {Store} from "@ngrx/store";
import {FormControl} from "@angular/forms";
import {CommonActions} from "../../common.action";
import { CommonModuleState } from "../../index";
import { StateCode } from "../state-code.interface";


@Component({
  selector: 'pams-state-code-select',
  templateUrl: './state-code-select.component.html',
})
export class StateCodeSelectComponent implements OnInit {


  private STATE_CODE = "commonModuleState.stateCodes".split(".");
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;
  stateCodes$: Observable<StateCode[]>;

  constructor(private store: Store<CommonModuleState>,
              private actions: CommonActions) {
    this.stateCodes$ = this.store.select(...this.STATE_CODE);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findStateCodes());
  }

  selectChangeEvent(event: StateCode) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

