import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {Store} from '@ngrx/store';
import {SetupActions} from '../setup.action';
import {SetupModuleState} from '../index';
import {Observable} from 'rxjs/Observable';
import {ReligionCodeCreatorDialog} from './dialog/religion-code-creator.dialog';
import {MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar} from '@angular/material';
import {ReligionCode} from '../../../../shared/model/common/religion-code.interface';

@Component({
  selector: 'pams-religion-list-page',
  templateUrl: './religion-code-list.page.html',
})
export class ReligionCodeListPage implements OnInit {

  private RELIGION_CODES: string[] = 'setupModuleState.religionCodes'.split('.');
  private religionCodes$: Observable<ReligionCode>;
  private creatorDialogRef: MdDialogRef<ReligionCodeCreatorDialog>;
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
    this.religionCodes$ = this.store.select(...this.RELIGION_CODES);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findReligionCodes());
    this.store.dispatch(this.actions.changeTitle('Religion Codes'));
  }

  createDialog(): void {
    this.showDialog(null);
  }

  editDialog(code: ReligionCode): void {
    this.showDialog(code);
  }

  delete(code: ReligionCode): void {
    let snackBarRef = this.snackBar.open('Delete this religion code?', 'Ok');
    snackBarRef.afterDismissed().subscribe(() => {
      this.store.dispatch(this.actions.removeReligionCode(code));
    });
  }

  filter(): void {
  }

  private showDialog(code: ReligionCode): void {
    console.log('create');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(ReligionCodeCreatorDialog, config);
    if (code) this.creatorDialogRef.componentInstance.religionCode = code; // set
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
    });
  }

}
