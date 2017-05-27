import { AddressCreatorDialog } from './dialog/address-creator.dialog';
import { Address } from './../address.interface';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, OnInit, ViewContainerRef} from '@angular/core';
import {IntakeApplicationActions} from "../intake-application.action";
import {Store} from "@ngrx/store";
import {ApplicationModuleState} from "../../index";
import {IntakeApplication} from "../intake-application.interface";
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";




@Component({
  selector: 'pams-address-list',
  templateUrl: './address-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class AddressListComponent implements OnInit {

  @Input() addresses: Address[];
  @Input() intakeApplication: IntakeApplication;

  private creatorDialogRef: MdDialogRef<AddressCreatorDialog>;
  private columns: any[] = [
    {name: 'address1', label: 'Address1'},
    {name: 'address2', label: 'Address2'},
    {name: 'address2', label: 'Address2'},
    {name: 'postcode', label: 'PostCode'},
  ];

  constructor(private actions: IntakeApplicationActions,
              private vcf: ViewContainerRef,
              private store: Store<ApplicationModuleState>,
              private dialog: MdDialog) {}

  ngOnInit(): void {
  }

  showDialog(): void {
    console.log("showDialog");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(AddressCreatorDialog, config);
    this.creatorDialogRef.componentInstance.intakeApplication = this.intakeApplication;
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
      // load something here
    });
  }

}
