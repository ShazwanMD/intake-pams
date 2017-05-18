import {Component, Input, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {Store} from "@ngrx/store";
import {FormControl} from "@angular/forms";
import { IntakeApplicationActions } from "./intake-application.action";
import { ApplicationModuleState } from "../index";
import {SpmResult} from "./spmResult.interface";


@Component({
  selector: 'pams-spmResult-select',
  templateUrl: './spmResult-select.component.html',
})
export class SPMResultSelectComponent implements OnInit {

  private SPM_RESULT = "applicationModuleState.spmResult".split(".");
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;
  spmResult$: Observable<spmResult[]>;

  constructor(private store: Store<ApplicationModuleState>,
              private actions: IntakeApplicationActions) {
    this.spmResult$ = this.store.select(...this.SPM_RESULT);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.addSPMresult());
  }

  selectChangeEvent(event: spmResult) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}