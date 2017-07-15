import {Component, Input, OnInit} from '@angular/core';
import {FormControl} from '@angular/forms';
import {ResultType} from '../../../../shared/model/application/result-type.enum';

@Component({
  selector: 'pams-result-type-select',
  templateUrl: './result-type-select.component.html',
})
export class ResultTypeSelectComponent implements OnInit {

  private resultTypes: ResultType[] = <ResultType[]>[];
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor() {
    for (let n in ResultType) {
      if (typeof ResultType[n] === 'string')
        this.resultTypes.push(ResultType[n.toString()]);
    }
  }

  ngOnInit() {
  }

  selectChangeEvent(event: ResultType) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

