import {Component, Input, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {Store} from "@ngrx/store";
import {FormControl} from "@angular/forms";
import {CommonActions} from "../../common.action";
import { CommonModuleState } from "../../index";
import { DistrictCode } from "../district-code.interface";

@Component({
  selector: 'pams-district-code-select',
  templateUrl: './district-code-select.component.html',
})
export class DistrictCodeSelectComponent implements OnInit {

  private DISTRICT_CODE = "commonModuleState.districtCodes".split(".");
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;
  districtCodes$: Observable<DistrictCode[]>;

  constructor(private store: Store<CommonModuleState>,
              private actions: CommonActions) {
    this.districtCodes$ = this.store.select(...this.DISTRICT_CODE);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findDistrictCodes());
  }

  selectChangeEvent(event: DistrictCode) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

