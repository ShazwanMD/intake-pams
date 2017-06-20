import {Component, Input, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {Store} from "@ngrx/store";
import {FormControl} from "@angular/forms";
import {CommonActions} from "../../common.action";
import { CommonModuleState } from "../../index";
import { ReligionCode } from "../religion-code.interface";

@Component({
  selector: 'pams-religion-code-select',
  templateUrl: './religion-code-select.component.html',
  styleUrls: ['./religion-code-select.scss'],

})
export class ReligionCodeSelectComponent implements OnInit {

  private RELIGION_CODE = "commonModuleState.religionCodes".split(".");
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;
  religionCodes$: Observable<ReligionCode[]>;

  constructor(private store: Store<CommonModuleState>,
              private actions: CommonActions) {
    this.religionCodes$ = this.store.select(...this.RELIGION_CODE);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findReligionCodes());
  }

  selectChangeEvent(event: ReligionCode) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

