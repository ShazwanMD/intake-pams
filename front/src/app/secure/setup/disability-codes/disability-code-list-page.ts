import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {Store} from '@ngrx/store';
import {SetupActions} from '../setup.action';
import {SetupModuleState} from '../index';
import {Observable} from 'rxjs/Observable';
import {DisabilityCodeEditorDialog} from './dialog/disability-code-editor.dialog';
import {MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar} from '@angular/material';
import {DisabilityCode} from '../../../shared/model/common/disability-code.interface';

@Component({
  selector: 'pams-disability-list-page',
  templateUrl: './disability-code-list.page.html',
})
export class DisabilityCodeListPage implements OnInit {

  private DISABILITY_CODES: string[] = 'setupModuleState.disabilityCodes'.split('.');
  private disabilityCodes$: Observable<DisabilityCode>;
  private creatorDialogRef: MdDialogRef<DisabilityCodeEditorDialog>;
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
    this.disabilityCodes$ = this.store.select(...this.DISABILITY_CODES);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findDisabilityCodes());
    this.store.dispatch(this.actions.changeTitle('Disability Codes'));
  }

  createDialog(): void {
    this.showDialog(null);
  }

  editDialog(code: DisabilityCode): void {
    this.showDialog(code);
  }

  delete(code: DisabilityCode): void {
    let snackBarRef = this.snackBar.open('Delete this disability code?', 'Ok');
    snackBarRef.afterDismissed().subscribe(() => {
      this.store.dispatch(this.actions.removeDisabilityCode(code));
    });
  }

  filter(): void {
  }

  private showDialog(code: DisabilityCode): void {
    console.log('create');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(DisabilityCodeEditorDialog, config);
    if (code) this.creatorDialogRef.componentInstance.disabilityCode = code; // set
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
    });
  }

}
