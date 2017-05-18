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
  spmResult$: Observable<SpmResult[]>;

  constructor(private store: Store<ApplicationModuleState>,
              private actions: IntakeApplicationActions) {
    this.spmResult$ = this.store.select(...this.SPM_RESULT);
  }

  ngOnInit(application) {
   this.store.dispatch(this.actions.findSpmResults(application));
  }

  selectChangeEvent(event: SpmResult) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
} 