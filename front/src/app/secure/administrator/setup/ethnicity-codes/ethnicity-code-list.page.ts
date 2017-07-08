import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {Store} from '@ngrx/store';
import {SetupActions} from '../setup.action';
import {SetupModuleState} from '../index';
import {Observable} from 'rxjs/Observable';
import {EthnicityCodeCreatorDialog} from './dialog/ethnicity-code-creator.dialog';
import {MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar} from '@angular/material';
import {EthnicityCode} from '../../../../shared/model/common/ethnicity-code.interface';

@Component({
  selector: 'pams-ethnicity-list-page',
  templateUrl: './ethnicity-code-list.page.html',
})
export class EthnicityCodeListPage implements OnInit {

  private ETHNICITY_CODES: string[] = 'setupModuleState.ethnicityCodes'.split('.');
  private ethnicityCodes$: Observable<EthnicityCode>;
  private creatorDialogRef: MdDialogRef<EthnicityCodeCreatorDialog>;
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
    this.ethnicityCodes$ = this.store.select(...this.ETHNICITY_CODES);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findEthnicityCodes());
    this.store.dispatch(this.actions.changeTitle('Ethnicity Codes'));
  }

  createDialog(): void {
    this.showDialog(null);
  }

  editDialog(code: EthnicityCode): void {
    this.showDialog(code);
  }

  delete(code: EthnicityCode): void {
    let snackBarRef = this.snackBar.open('Delete this ethnicity code?', 'Ok');
    snackBarRef.afterDismissed().subscribe(() => {
      this.store.dispatch(this.actions.removeEthnicityCode(code));
    });
  }

  filter(): void {
  }

  private showDialog(code: EthnicityCode): void {
    console.log('create');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(EthnicityCodeCreatorDialog, config);
    if (code) this.creatorDialogRef.componentInstance.ethnicityCode = code; // set
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
    });
  }

}
