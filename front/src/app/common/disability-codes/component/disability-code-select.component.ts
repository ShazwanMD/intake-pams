import {Component, Input, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {FormControl} from '@angular/forms';
import {CommonActions} from '../../common.action';
import {CommonModuleState} from '../../index';
import {DisabilityCode} from '../../../shared/model/common/disability-code.interface';

@Component({
  selector: 'pams-disability-code-select',
  templateUrl: './disability-code-select.component.html',
})
export class DisabilityCodeSelectComponent implements OnInit {

  private DISABILITY_CODE: string[] = 'commonModuleState.disabilityCodes'.split('.');
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;
  disabilityCodes$: Observable<DisabilityCode[]>;

  constructor(private store: Store<CommonModuleState>,
              private actions: CommonActions) {
    this.disabilityCodes$ = this.store.select(...this.DISABILITY_CODE);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findDisabilityCodes());
  }

  selectChangeEvent(event: DisabilityCode) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}
