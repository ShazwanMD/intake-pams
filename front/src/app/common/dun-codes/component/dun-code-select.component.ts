import { SetupActions } from './../../../setup/setup.action';
import { SetupModuleState } from './../../../setup/index';
import {Component, Input, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {Store} from "@ngrx/store";
import {FormControl} from "@angular/forms";
import { DunCode } from "../dun-code.interface";



@Component({
  selector: 'pams-dun-code-select',
  templateUrl: './dun-code-select.component.html',
})
export class DunCodeSelectComponent implements OnInit {

  private DUN_CODE = "setupModuleState.dunCodes".split(".");
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;
  dunCodes$: Observable<DunCode[]>;

  constructor(private store: Store<SetupModuleState>,
              private actions: SetupActions) {
    this.dunCodes$ = this.store.select(...this.DUN_CODE);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findDunCodes());
  }

  selectChangeEvent(event: DunCode) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

