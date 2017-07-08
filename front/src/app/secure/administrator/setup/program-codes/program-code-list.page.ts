import {MdDialogConfig, MdDialogRef, MdSnackBar, MdDialog} from '@angular/material';
import {ProgramCodeCreatorDialog} from './dialog/program-code-creator.dialog';
import {Component, OnInit, ChangeDetectionStrategy, state, ViewContainerRef} from '@angular/core';
import {Store} from '@ngrx/store';
import {SetupActions} from '../setup.action';
import {SetupModuleState} from '../index';
import {Observable} from 'rxjs/Observable';
import {ProgramCode} from '../../../../shared/model/common/program-code.interface';

@Component({
  selector: 'pams-program-list-page',
  templateUrl: './program-code-list.page.html',
})
export class ProgramCodeListPage implements OnInit {

  private PROGRAM_CODES: string[] = 'setupModuleState.programCodes'.split('.');
  private creatorDialogRef: MdDialogRef<ProgramCodeCreatorDialog>;
  private programCodes$: Observable<ProgramCode>;
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
    this.programCodes$ = this.store.select(...this.PROGRAM_CODES);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findProgramCodes());
    this.store.dispatch(this.actions.changeTitle('Program Codes'));
  }

  createDialog(): void {
    this.showDialog(null);
  }

  editDialog(code: ProgramCode): void {
    this.showDialog(code);
  }

  delete(code: ProgramCode): void {
    let snackBarRef = this.snackBar.open('Delete this program code?', 'Ok');
    snackBarRef.afterDismissed().subscribe(() => {
      this.store.dispatch(this.actions.removeProgramCode(code));
    });
  }

  filter(): void {
  }

  private showDialog(code: ProgramCode): void {
    console.log('create');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(ProgramCodeCreatorDialog, config);
    if (code) this.creatorDialogRef.componentInstance.programCode = code; // set
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
    });
  }
}
