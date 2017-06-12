import {Component, Input, OnInit} from '@angular/core';
import {FormControl} from "@angular/forms";
import {RefereeType} from "../referee-type.enum";

@Component({
  selector: 'pams-referee-type-select',
  templateUrl: './referee-type-select.component.html',
})
export class RefereeTypeSelectComponent implements OnInit {

  private refereeTypes: RefereeType[] = <RefereeType[]>[];
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor() {
    for (var n in RefereeType) {
      if (typeof RefereeType[n] === 'string')
        this.refereeTypes.push(RefereeType[n.toString()]);
    }
  }

  ngOnInit() {
  }

  selectChangeEvent(event: RefereeType) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}
