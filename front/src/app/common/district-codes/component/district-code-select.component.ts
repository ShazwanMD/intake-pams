import {Component, Input, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {FormControl} from '@angular/forms';
import {DistrictCode} from '../../../shared/model/common/district-code.interface';
import {SetupModuleState} from '../../../secure/administrator/setup/index';
import {SetupActions} from '../../../secure/administrator/setup/setup.action';

@Component({
  selector: 'pams-district-code-select',
  templateUrl: './district-code-select.component.html',
})
export class DistrictCodeSelectComponent implements OnInit {

  private DISTRICT_CODE: string[] = 'setupModuleState.districtCodes'.split('.');
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;
  districtCodes$: Observable<DistrictCode[]>;

  constructor(private store: Store<SetupModuleState>,
              private actions: SetupActions) {
    this.districtCodes$ = this.store.select(...this.DISTRICT_CODE);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findDistrictCodes());
  }

  selectChangeEvent(event: DistrictCode) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}
