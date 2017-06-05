import { SetupActions } from './../../../setup/setup.action';
import { SetupModuleState } from './../../../setup/index';
import {Component, Input, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {Store} from "@ngrx/store";
import {FormControl} from "@angular/forms";
import { GradeCode } from "../grade-code.interface";



@Component({
  selector: 'pams-grade-code-select',
  templateUrl: './grade-code-select.component.html',
})
export class GradeCodeSelectComponent implements OnInit {

  private GRADE_CODE = "setupModuleState.gradeCodes".split(".");
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;
  gradeCodes$: Observable<GradeCode[]>;

  constructor(private store: Store<SetupModuleState>,
              private actions: SetupActions) {
    this.gradeCodes$ = this.store.select(...this.GRADE_CODE);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findGradeCodes());
  }

  selectChangeEvent(event: GradeCode) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

