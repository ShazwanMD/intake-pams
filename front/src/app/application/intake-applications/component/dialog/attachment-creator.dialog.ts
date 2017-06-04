import {Attachment} from './../../attachment.interface';
import {Component, ViewContainerRef, OnInit, Input} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {ApplicationModuleState} from "../../../index";
import {MdDialogRef} from "@angular/material";
import {IntakeApplicationActions} from "../../intake-application.action";
import {IntakeApplication} from "../../intake-application.interface";
import { AttachmentType } from "../../attachment-type.enum";

@Component({
  selector: 'pams-attachment-creator',
  templateUrl: './attachment-creator.dialog.html',
})

export class AttachmentCreatorDialog implements OnInit {

  private _intakeApplication: IntakeApplication;
  private createForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<ApplicationModuleState>,
              private actions: IntakeApplicationActions,
              private dialog: MdDialogRef<AttachmentCreatorDialog>) {
  }


  set intakeApplication(value: IntakeApplication) {
    this._intakeApplication = value;
  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group(<Attachment>{
       attachmentType: AttachmentType.BACHELOR,
    });
  }

  upload(file: File, attachmentType: AttachmentType) {
    this.store.dispatch(this.actions.addAttachment(this._intakeApplication, file, attachmentType));
    this.dialog.close();
  }
}
