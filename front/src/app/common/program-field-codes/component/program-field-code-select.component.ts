import {Component, Input, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {FormControl} from '@angular/forms';
import {CommonActions} from '../../common.action';
import {CommonModuleState} from '../../index';
import {ProgramCode} from '../../../shared/model/common/program-code.interface';
import {ProgramLevel} from '../../../shared/model/policy/program-level.interface';
import { ProgramFieldCode } from "../../../shared/model/common/program-field-code.interface";

@Component({
  selector: 'pams-program-field-code-select',
  templateUrl: './program-field-code-select.component.html',
  styleUrls: ['./program-field-code-select.scss'],
})
export class ProgramFieldCodeSelectComponent implements OnInit {

  private PROGRAM_FIELD_CODES: string[] = 'commonModuleState.programFieldCodes'.split('.');
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;
  @Input() programLevel: ProgramLevel;
  programFieldCodes$: Observable<ProgramFieldCode[]>;

  constructor(private store: Store<CommonModuleState>,
              private actions: CommonActions) {
    this.programFieldCodes$ = this.store.select(...this.PROGRAM_FIELD_CODES);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findProgramFieldCodesByProgramLevel(this.programLevel));
  }

  selectChangeEvent(event: ProgramFieldCode) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}
