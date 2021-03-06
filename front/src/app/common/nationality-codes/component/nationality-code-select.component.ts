import {Component, Input, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {FormControl} from '@angular/forms';
import {CommonActions} from '../../common.action';
import {CommonModuleState} from '../../index';
import {NationalityCode} from '../../../shared/model/common/nationality-code.interface';

@Component({
  selector: 'pams-nationality-code-select',
  templateUrl: './nationality-code-select.component.html',
  styleUrls: ['./nationality-code-select.scss'],
})
export class NationalityCodeSelectComponent implements OnInit {

  private NATIONALITY_CODE: string[] = 'commonModuleState.nationalityCodes'.split('.');
  private nationalityCodes$: Observable<NationalityCode[]>;
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor(private store: Store<CommonModuleState>,
              private actions: CommonActions) {
    this.nationalityCodes$ = this.store.select(...this.NATIONALITY_CODE);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findNationalityCodes());
  }

  selectChangeEvent(event: NationalityCode) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

