import {Component, Input, OnInit} from '@angular/core';
import {FormControl} from "@angular/forms";
import {EmploymentType} from "../employment-type.enum";

@Component({
  selector: 'pams-employment-type-select',
  templateUrl: './employment-type-select.component.html',
})
export class EmploymentTypeSelectComponent implements OnInit {

  private employmentTypes: EmploymentType[] = <EmploymentType[]>[];
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor() {
    for (var n in EmploymentType) {
      if (typeof EmploymentType[n] === 'string')
        this.employmentTypes.push(EmploymentType[n.toString()]);
    }
  }

  ngOnInit() {
  }

  selectChangeEvent(event: EmploymentType) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}
