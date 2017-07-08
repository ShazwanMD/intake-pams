import {Component, Input, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {FormControl} from '@angular/forms';
import {ParliamentCode} from '../../../shared/model/common/parliament-code.interface';
import {SetupModuleState} from '../../../secure/administrator/setup/index';
import {SetupActions} from '../../../secure/administrator/setup/setup.action';

@Component({
  selector: 'pams-parliament-code-select',
  templateUrl: './parliament-code-select.component.html',
})
export class ParliamentCodeSelectComponent implements OnInit {

  private PARLIAMENT_CODE: string[] = 'setupModuleState.parliamentCodes'.split('.');
  private parliamentCodes$: Observable<ParliamentCode[]>;
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor(private store: Store<SetupModuleState>,
              private actions: SetupActions) {
    this.parliamentCodes$ = this.store.select(...this.PARLIAMENT_CODE);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findParliamentCodes());
  }

  selectChangeEvent(event: ParliamentCode) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

