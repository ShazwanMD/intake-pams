import {Component, Input, OnInit} from '@angular/core';
import {FormControl} from "@angular/forms";
import {AddressType} from "../address-type.enum";

@Component({
  selector: 'pams-address-type-select',
  templateUrl: './address-type-select.component.html',
})
export class AddressTypeSelectComponent implements OnInit {

  private addressTypes: AddressType[] = <AddressType[]>[];
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor() {
    for (var n in AddressType) {
      if(typeof AddressType[n] === 'string')
        this.addressTypes.push(AddressType[n.toString()]);
    }
  }

  ngOnInit() {
  }

  selectChangeEvent(event: AddressType) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

