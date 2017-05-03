import {Component, Input, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {Store} from "@ngrx/store";
import {FormControl} from "@angular/forms";
import {CommonActions} from "../../common.action";
import {CommonModuleState} from "../../index";
import {StudyMode} from "../study-mode.interface";


@Component({
  selector: 'pams-study-mode-select',
  templateUrl: './study-mode-select.component.html',
})
export class StudyModeCodeSelectComponent implements OnInit {

  private STUDY_MODE_CODES = "commonModuleState.StudyModeCodes".split(".");
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;
  studyModeCodes$: Observable<StudyMode[]>;

  constructor(private store: Store<CommonModuleState>,
              private actions: CommonActions) {
    this.studyModeCodes$ = this.store.select(...this.STUDY_MODE_CODES);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findStudyModeCodes());
  }

  selectChangeEvent(event: StudyMode) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

