import {Component, Input, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {FormControl} from '@angular/forms';
import {GradeCode} from '../../../shared/model/common/grade-code.interface';
import {SetupModuleState} from '../../../secure/administrator/setup/index';
import {SetupActions} from '../../../secure/administrator/setup/setup.action';

@Component({
  selector: 'pams-grade-code-select',
  templateUrl: './grade-code-select.component.html',
})
export class GradeCodeSelectComponent implements OnInit {

  private GRADE_CODE: string[] = 'setupModuleState.gradeCodes'.split('.');
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;
  gradeCodes$: Observable<GradeCode[]>;

  constructor(private store: Store<SetupModuleState>,
              private actions: SetupActions) {
    this.gradeCodes$ = this.store.select(...this.GRADE_CODE);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findGradeCodes());
  }

  selectChangeEvent(event: GradeCode) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}
