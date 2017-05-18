import {Component, Input, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {Store} from "@ngrx/store";
import {FormControl} from "@angular/forms";
import {CommonActions} from "../../common.action";
import { CommonModuleState } from "../../index";
import { EthnicityCode } from "../ethnicity-code.interface";

@Component({
  selector: 'pams-ethnicity-code-select',
  templateUrl: './ethnicity-code-select.component.html',
})
export class EthnicityCodeSelectComponent implements OnInit {

  private ETHNICITY_CODE = "commonModuleState.ethnicityCodes".split(".");
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;
  ethnicityCodes$: Observable<EthnicityCode[]>;

  constructor(private store: Store<CommonModuleState>,
              private actions: CommonActions) {
    this.ethnicityCodes$ = this.store.select(...this.ETHNICITY_CODE);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findEthnicityCodes());
  }

  selectChangeEvent(event: EthnicityCode) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

