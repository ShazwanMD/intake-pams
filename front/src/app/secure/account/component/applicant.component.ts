import { Applicant } from './../../identity/applicant.interface';
import { Observable } from 'rxjs/Observable';
import { Component, Input, ChangeDetectionStrategy, ViewContainerRef } from '@angular/core';
import { EmailChangerDialog } from "../dialog/email-changer.dialog";
import { MdDialogRef, MdDialog, MdDialogConfig } from "@angular/material";
import { AccountActions } from "../account.action";
import { AccountModuleState } from "../index";
import { Store } from "@ngrx/store";


@Component({
  selector: 'pams-applicant',
  templateUrl: './applicant.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ApplicantComponent {
 @Input() applicant: Applicant;

 private editorDialogRef: MdDialogRef<EmailChangerDialog>;

  constructor(private actions: AccountActions,
              private vcf: ViewContainerRef,
              private store: Store<AccountModuleState>,
              private dialog: MdDialog) {
  }

  editDialog(): void {
    console.log('editDialog');
    let config: MdDialogConfig = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.editorDialogRef = this.dialog.open(EmailChangerDialog, config);
    this.editorDialogRef.componentInstance.applicant = this.applicant;
    this.editorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
      // load something here
    });
  }

}
