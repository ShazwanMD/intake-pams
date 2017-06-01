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

  private selectedRows: Address[];
  private creatorDialogRef: MdDialogRef<AddressCreatorDialog>;
  private columns: any[] = [
    {name: 'address1', label: 'Address1'},
    {name: 'address2', label: 'Address2'},
    {name: 'address2', label: 'Address2'},
    {name: 'postcode', label: 'PostCode'},
    {name: 'stateCode.descriptionMs', label: 'State'},
    {name: 'countryCode.descriptionMs', label: 'Country'},
    {name: 'addressType', label: 'Address Type'},
  ];

  constructor(private actions: IntakeApplicationActions,
              private vcf: ViewContainerRef,
              private store: Store<ApplicationModuleState>,
              private dialog: MdDialog) {}

  ngOnInit(): void {
    this.selectedRows = this.addresses.filter(value => value.selected);
  }

  edit(addresses:Address){
    // todo: use editor instead of creator
  }

  delete(address:Address): void {
    this.store.dispatch(this.actions.deleteAddress(this.intakeApplication, address));
  }

  filter(): void {
  }

  selectRow(address: Address): void {
  }

  selectAllRows(addresses: Address[]): void {
  }

  createDialog(): void {
    console.log("showDialog");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(AddressCreatorDialog, config);
    this.creatorDialogRef.componentInstance.intakeApplication = this.intakeApplication = this.intakeApplication;
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
      // load something here
    });
  }

}
