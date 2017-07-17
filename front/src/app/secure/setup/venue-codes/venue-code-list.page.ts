import { VenueCode } from './../../../shared/model/common/venue-code.interface';
import {VenueCodeEditorDialog} from './dialog/venue-code-editor.dialog';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {Store} from '@ngrx/store';
import {SetupActions} from '../setup.action';
import {SetupModuleState} from '../index';
import {Observable} from 'rxjs/Observable';
import {MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar} from '@angular/material';


@Component({
  selector: 'pams-venue-list-page',
  templateUrl: './venue-code-list.page.html',
})
export class VenueCodeListPage implements OnInit {

  private VENUE_CODES: string[] = 'setupModuleState.venueCodes'.split('.');
  private venueCodes$: Observable<VenueCode>;
  private creatorDialogRef: MdDialogRef<VenueCodeEditorDialog>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'descriptionMs', label: 'DescriptionMs'},
    {name: 'descriptionEn', label: 'DescriptionEn'},
    {name: 'action', label: ''},
  ];

  constructor(private actions: SetupActions,
              private store: Store<SetupModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private snackBar: MdSnackBar) {
    this.venueCodes$ = this.store.select(...this.VENUE_CODES);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findVenueCodes());
    this.store.dispatch(this.actions.changeTitle('Venue Codes'));
  }

  createDialog(): void {
    this.showDialog(null);
  }

  editDialog(code: VenueCode): void {
    this.showDialog(code);
  }

  delete(code: VenueCode): void {
    let snackBarRef = this.snackBar.open('Delete this venue code?', 'Ok');
    snackBarRef.afterDismissed().subscribe(() => {
      this.store.dispatch(this.actions.removeVenueCode(code));
    });
  }

  filter(): void {
  }

  private showDialog(code: VenueCode): void {
    console.log('create');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(VenueCodeEditorDialog, config);
    if (code) this.creatorDialogRef.componentInstance.venueCode = code; // set
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
    });
  }
}
