import {Component, Input, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {FormControl} from '@angular/forms';
import {CommonActions} from '../../common.action';
import {CommonModuleState} from '../../index';
import {FieldCode} from '../../../shared/model/common/field-code.interface';

@Component({
  selector: 'pams-field-code-select',
  templateUrl: './field-code-select.component.html',
  styleUrls: ['./field-code-select.scss'],
  
})
export class FieldCodeSelectComponent implements OnInit {

  private FIELD_CODE: string[] = 'commonModuleState.fieldCodes'.split('.');
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;
  fieldCodes$: Observable<FieldCode[]>;

  constructor(private store: Store<CommonModuleState>,
              private actions: CommonActions) {
    this.fieldCodes$ = this.store.select(...this.FIELD_CODE);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findFieldCodes());
  }

  selectChangeEvent(event: FieldCode) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

