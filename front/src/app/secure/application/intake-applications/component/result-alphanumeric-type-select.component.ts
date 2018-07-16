import { OnInit, Component, Input } from '@angular/core';
import {FormControl} from '@angular/forms';
import { ResultAlphaNumericType } from '../../../../shared/model/application/result-alpha-numeric-type.enum';


@Component({
  selector: 'pams-result-alphanumeric-type-select',
  templateUrl: './result-alphanumeric-type-select.component.html',
  styleUrls: ['./result-alphanumeric-type-select.scss'],
})
export class ResultAlphanumericTypeSelectComponent implements OnInit {

  private resultAlphaNumericTypes : ResultAlphaNumericType[] = <ResultAlphaNumericType[]>[];
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor() {
    for (let n in ResultAlphaNumericType) {
      if (typeof ResultAlphaNumericType[n] === 'string')
        this.resultAlphaNumericTypes.push(ResultAlphaNumericType[n.toString()]);
    }
  }

  ngOnInit() {
  }

  selectChangeEvent(event: ResultAlphaNumericType) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

