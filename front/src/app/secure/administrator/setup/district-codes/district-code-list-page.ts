import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {Store} from '@ngrx/store';
import {SetupActions} from '../setup.action';
import {SetupModuleState} from '../index';
import {Observable} from 'rxjs/Observable';
import {DistrictCodeEditorDialog} from './dialog/district-code-editor.dialog';
import {MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar} from '@angular/material';
import {DistrictCode} from '../../../../shared/model/common/district-code.interface';

@Component({
  selector: 'pams-district-list-page',
  templateUrl: './district-code-list.page.html',
})
export class DistrictCodeListPage implements OnInit {

  private DISTRICT_CODES: string[] = 'setupModuleState.districtCodes'.split('.');
  private districtCodes$: Observable<DistrictCode>;
  private creatorDialogRef: MdDialogRef<DistrictCodeEditorDialog>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'description', label: 'Description'},
    {name: 'action', label: ''},
  ];

  constructor(private actions: SetupActions,
              private store: Store<SetupModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private snackBar: MdSnackBar) {
    this.districtCodes$ = this.store.select(...this.DISTRICT_CODES);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findDistrictCodes());
    this.store.dispatch(this.actions.changeTitle('District Codes'));
  }

  createDialog(): void {
    this.showDialog(null);
  }

  editDialog(code: DistrictCode): void {
    this.showDialog(code);
  }

  delete(code: DistrictCode): void {
    let snackBarRef = this.snackBar.open('Delete this district code?', 'Ok');
    snackBarRef.afterDismissed().subscribe(() => {
      this.store.dispatch(this.actions.removeDistrictCode(code));
    });
  }

  filter(): void {
  }

  private showDialog(code: DistrictCode): void {
    console.log('create');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(DistrictCodeEditorDialog, config);
    if (code) this.creatorDialogRef.componentInstance.districtCode = code; // set
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
    });
  }

}
