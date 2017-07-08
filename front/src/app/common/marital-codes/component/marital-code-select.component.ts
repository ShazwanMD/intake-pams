import {Component, Input, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {FormControl} from '@angular/forms';
import {CommonActions} from '../../common.action';
import {CommonModuleState} from '../../index';
import {MaritalCode} from '../../../shared/model/common/marital-code.interface';

@Component({
  selector: 'pams-marital-code-select',
  templateUrl: './marital-code-select.component.html',
  styleUrls: ['./marital-code-select.scss'],
})
export class MaritalCodeSelectComponent implements OnInit {

  private MARITAL_CODE: string[] = 'commonModuleState.maritalCodes'.split('.');
  private maritalCodes$: Observable<MaritalCode[]>;
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor(private store: Store<CommonModuleState>,
              private actions: CommonActions) {
    this.maritalCodes$ = this.store.select(...this.MARITAL_CODE);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findMaritalCodes());
  }

  selectChangeEvent(event: MaritalCode) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}
