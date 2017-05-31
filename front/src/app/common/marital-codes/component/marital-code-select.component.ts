import {Component, Input, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {Store} from "@ngrx/store";
import {FormControl} from "@angular/forms";
import {CommonActions} from "../../common.action";
import { CommonModuleState } from "../../index";
import { MaritalCode } from "../marital-code.interface";


@Component({
  selector: 'pams-marital-code-select',
  templateUrl: './marital-code-select.component.html',
})
export class MaritalCodeSelectComponent implements OnInit {

  private MARITAL_CODE = "commonModuleState.maritalCodes".split(".");
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;
  maritalCodes$: Observable<MaritalCode[]>;

  constructor(private store: Store<CommonModuleState>,
              private actions: CommonActions) {
    this.maritalCodes$ = this.store.select(...this.MARITAL_CODE);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findMaritalCodes());
  }

  selectChangeEvent(event: MaritalCode) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

