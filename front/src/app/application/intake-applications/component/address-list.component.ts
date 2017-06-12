import {AddressEditorDialog} from './dialog/address-editor.dialog';
import {Address} from '../address.interface';
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
  private editorDialogRef: MdDialogRef<AddressEditorDialog>;
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
              private dialog: MdDialog) {
  }

  ngOnInit(): void {
    this.selectedRows = this.addresses.filter(value => value.selected);
  }

  create(): void {
    this.showDialog(null);
  }

  edit(address: Address): void {
    this.showDialog(address);
  }

  delete(address: Address): void {
    this.store.dispatch(this.actions.deleteAddress(this.intakeApplication, address));
  }

  filter(): void {
  }

  selectRow(address: Address): void {
  }

  selectAllRows(addresses: Address[]): void {
  }

  showDialog(address: Address): void {
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '60%';
    config.position = {top: '65px'};
    this.editorDialogRef = this.dialog.open(AddressEditorDialog, config);
    this.editorDialogRef.componentInstance.intakeApplication = this.intakeApplication;
    if (address) this.editorDialogRef.componentInstance.address = address;
    this.editorDialogRef.afterClosed().subscribe(res => {
      this.selectedRows = [];
    });
  }
}
