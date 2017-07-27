// import { AddressChangerDialog } from './../dialog/address-changer.dialog';
// import { ApplicationModuleState } from './../../application/index';
// import { IntakeApplication } from './../../../shared/model/application/intake-application.interface';
// import { Observable } from 'rxjs/Observable';
// import { Component, Input, ChangeDetectionStrategy, ViewContainerRef } from '@angular/core';
// import { EmailChangerDialog } from "../dialog/email-changer.dialog";
// import { MdDialogRef, MdDialog, MdDialogConfig } from "@angular/material";
// import { AccountActions } from "../account.action";
// import { AccountModuleState } from "../index";
// import { Store } from "@ngrx/store";


// @Component({
//   selector: 'pams-intake-application',
//   templateUrl: './intake-application.component.html',
//   changeDetection: ChangeDetectionStrategy.OnPush,
// })
// export class IntakeApplicationComponent {
//  @Input() intakeApplication: IntakeApplication;

//  private editorDialogRef: MdDialogRef<AddressChangerDialog>;

//   constructor(private actions: AccountActions,
//               private vcf: ViewContainerRef,
//               private store: Store<ApplicationModuleState>,
//               private dialog: MdDialog) {
//   }

//   editDialog(): void {
//     console.log('editDialog');
//     let config: MdDialogConfig = new MdDialogConfig();
//     config.viewContainerRef = this.vcf;
//     config.role = 'dialog';
//     config.width = '70%';
//     config.height = '65%';
//     config.position = {top: '0px'};
//     this.editorDialogRef = this.dialog.open(AddressChangerDialog, config);
//     this.editorDialogRef.componentInstance.intakeApplication = this.intakeApplication;
//     this.editorDialogRef.afterClosed().subscribe((res) => {
//       console.log('close dialog');
//       // load something here
//     });
//   }
// 
// // }
