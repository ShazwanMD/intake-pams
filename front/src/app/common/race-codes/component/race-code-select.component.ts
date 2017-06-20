import {Component, Input, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {Store} from "@ngrx/store";
import {FormControl} from "@angular/forms";
import {CommonActions} from "../../common.action";
import { CommonModuleState } from "../../index";
import { RaceCode } from "../race-code.interface";


@Component({
  selector: 'pams-race-code-select',
  templateUrl: './race-code-select.component.html',
  styleUrls: ['./race-code-select.scss'],
})
export class RaceCodeSelectComponent implements OnInit {

  private RACE_CODE = "commonModuleState.raceCodes".split(".");
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;
  raceCodes$: Observable<RaceCode[]>;

  constructor(private store: Store<CommonModuleState>,
              private actions: CommonActions) {
    this.raceCodes$ = this.store.select(...this.RACE_CODE);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findRaceCodes());
  }

  selectChangeEvent(event: RaceCode) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

