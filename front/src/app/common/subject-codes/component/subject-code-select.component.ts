import {Component, Input, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {FormControl} from '@angular/forms';
import {CommonActions} from '../../common.action';
import {CommonModuleState} from '../../index';
import {SubjectCode} from '../../../shared/model/common/subject-code.interface';

@Component({
  selector: 'pams-subject-code-select',
  templateUrl: './subject-code-select.component.html',
})
export class SubjectCodeSelectComponent implements OnInit {

  private SUBJECT_CODE: string[] = 'commonModuleState.subjectCodes'.split('.');
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;
  subjectCodes$: Observable<SubjectCode[]>;

  constructor(private store: Store<CommonModuleState>,
              private actions: CommonActions) {
    this.subjectCodes$ = this.store.select(...this.SUBJECT_CODE);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findSubjectCodes());
  }

  selectChangeEvent(event: SubjectCode) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}
