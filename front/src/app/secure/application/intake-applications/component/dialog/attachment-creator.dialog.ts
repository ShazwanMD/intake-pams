import {Attachment} from '../../../../../shared/model/application/attachment.interface';
import {Component, ViewContainerRef, OnInit, Input} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {ApplicationModuleState} from "../../../index";
import {MdDialogRef} from "@angular/material";
import {IntakeApplicationActions} from "../../intake-application.action";
import {IntakeApplication} from "../../../../../shared/model/application/intake-application.interface";
import {AttachmentType} from "../../../../../shared/model/application/attachment-type.enum";
import {AttachmentHelper} from "./attachment-helper.interface";

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
    this.createForm = this.formBuilder.group(<AttachmentHelper>{
      attachmentType: AttachmentType.BACHELOR,
    })
    ;
  }

  upload(attachmentHelper: AttachmentHelper, file: File) {
    this.store.dispatch(this.actions.addAttachment(this._intakeApplication, file, attachmentHelper.attachmentType));
    this.dialog.close();
  }
}
