import {Component, Input, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {Store} from "@ngrx/store";
import {FormControl} from "@angular/forms";
import {IntakeApplicationActions} from "../intake-application.action";
import {SpmResult} from "../spm-result.interface";
import {ApplicationModuleState} from "../../index";


@Component({
  selector: 'pams-spm-result-select',
  templateUrl: './spm-result-select.component.html',
})
export class SpmResultSelectComponent implements OnInit {

  private SPM_RESULT = "applicationModuleState.result".split(".");
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  spmResult$: Observable<SpmResult[]>;

  constructor(private store: Store<ApplicationModuleState>,
              private actions: IntakeApplicationActions) {
    this.spmResult$ = this.store.select(...this.SPM_RESULT);
  }

  ngOnInit() {
    this.spmResult$.subscribe(application => this.store.dispatch(this.actions.findSpmResultsByIntakeApplication(application)));
  }


  selectChangeEvent(event: SpmResult) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}
