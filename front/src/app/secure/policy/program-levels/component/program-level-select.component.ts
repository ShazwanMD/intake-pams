import {Component, Input, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {ProgramLevelActions} from '../program-level.action';
import {Store} from '@ngrx/store';
import {PolicyModuleState} from '../../index';
import {FormControl} from '@angular/forms';
import {ProgramLevel} from '../../../../shared/model/policy/program-level.interface';

@Component({
  selector: 'pams-program-level-select',
  templateUrl: './program-level-select.component.html',
  styleUrls: ['./program-level-select.scss'],
})
export class ProgramLevelSelectComponent implements OnInit {

  private PROGRAM_LEVELS = 'policyModuleState.programLevels'.split('.');
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;
  programLevels$: Observable<ProgramLevel[]>;

  constructor(private store: Store<PolicyModuleState>,
              private actions: ProgramLevelActions) {
    this.programLevels$ = this.store.select(...this.PROGRAM_LEVELS);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findProgramLevels());
  }

  selectChangeEvent(event: ProgramLevel) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

