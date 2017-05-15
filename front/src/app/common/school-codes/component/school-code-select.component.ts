import {Component, Input, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {Store} from "@ngrx/store";
import {FormControl} from "@angular/forms";
import {CommonActions} from "../../common.action";
import { CommonModuleState } from "../../index";
import { SchoolCode } from "../school-code.interface";

@Component({
  selector: 'pams-school-code-select',
  templateUrl: './school-code-select.component.html',
})
export class SchoolCodeSelectComponent implements OnInit {

  private SCHOOL_CODE = "commonModuleState.schoolCodes".split(".");
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;
  schoolCodes$: Observable<SchoolCode[]>;

  constructor(private store: Store<CommonModuleState>,
              private actions: CommonActions) {
    this.schoolCodes$ = this.store.select(...this.SCHOOL_CODE);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findSchoolCodes());
  }

  selectChangeEvent(event: SchoolCode) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

