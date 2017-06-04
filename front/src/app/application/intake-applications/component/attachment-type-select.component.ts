import {Component, Input, OnInit} from '@angular/core';
import {FormControl} from "@angular/forms";
import {AttachmentType} from "../attachment-type.enum";

@Component({
  selector: 'pams-attachment-type-select',
  templateUrl: './attachment-type-select.component.html',
})
export class AttachmentTypeSelectComponent implements OnInit {

  private attachmentTypes: AttachmentType[] = <AttachmentType[]>[];
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor() {
    for (var n in AttachmentType) {
      if(typeof AttachmentType[n] === 'string')
        this.attachmentTypes.push(AttachmentType[n.toString()]);
    }
  }

  ngOnInit() {
  }

  selectChangeEvent(event: AttachmentType) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}
