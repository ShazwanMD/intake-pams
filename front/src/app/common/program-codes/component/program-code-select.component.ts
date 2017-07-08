import {Component, Input, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {FormControl} from '@angular/forms';
import {CommonActions} from '../../common.action';
import {CommonModuleState} from '../../index';
import {ProgramCode} from '../../../shared/model/common/program-code.interface';
import {ProgramLevel} from '../../../shared/model/policy/program-level.interface';

@Component({
  selector: 'pams-program-code-select',
  templateUrl: './program-code-select.component.html',
  styleUrls: ['./program-code-select.scss'],
})
export class ProgramCodeSelectComponent implements OnInit {

  private PROGRAM_CODES: string[] = 'commonModuleState.programCodes'.split('.');
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;
  @Input() programLevel: ProgramLevel;
  programCodes$: Observable<ProgramCode[]>;

  constructor(private store: Store<CommonModuleState>,
              private actions: CommonActions) {
    this.programCodes$ = this.store.select(...this.PROGRAM_CODES);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findProgramCodesByProgramLevel(this.programLevel));
  }

  selectChangeEvent(event: ProgramCode) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}
