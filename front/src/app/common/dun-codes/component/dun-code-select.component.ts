import {Component, Input, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {FormControl} from '@angular/forms';
import {DunCode} from '../../../shared/model/common/dun-code.interface';
import {SetupModuleState} from '../../../secure/administrator/setup/index';
import {SetupActions} from '../../../secure/administrator/setup/setup.action';

@Component({
  selector: 'pams-dun-code-select',
  templateUrl: './dun-code-select.component.html',
})
export class DunCodeSelectComponent implements OnInit {

  private DUN_CODE: string[] = 'setupModuleState.dunCodes'.split('.');
  private dunCodes$: Observable<DunCode[]>;
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

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

