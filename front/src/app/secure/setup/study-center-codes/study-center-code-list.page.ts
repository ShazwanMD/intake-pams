import {StudyCenterCodeEditorDialog} from './dialog/study-center-code-editor.dialog';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {Store} from '@ngrx/store';
import {SetupActions} from '../setup.action';
import {SetupModuleState} from '../index';
import {Observable} from 'rxjs/Observable';
import {MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar} from '@angular/material';
import {StudyCenterCode} from '../../../shared/model/common/study-center-code.interface';

@Component({
  selector: 'pams-study-center-list-page',
  templateUrl: './study-center-code-list.page.html',
})
export class StudyCenterCodeListPage implements OnInit {

  private STUDY_CENTER_CODES: string[] = 'setupModuleState.studyCenterCodes'.split('.');
  private studyCenterCodes$: Observable<StudyCenterCode>;
  private creatorDialogRef: MdDialogRef<StudyCenterCodeEditorDialog>;
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
    this.studyCenterCodes$ = this.store.select(...this.STUDY_CENTER_CODES);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findStudyCenterCodes());
    this.store.dispatch(this.actions.changeTitle('Study Center Codes'));
  }

  createDialog(): void {
    this.showDialog(null);
  }

  editDialog(code: StudyCenterCode): void {
    this.showDialog(code);
  }

  delete(code: StudyCenterCode): void {
    let snackBarRef = this.snackBar.open('Delete this study center code?', 'Ok');
    snackBarRef.afterDismissed().subscribe(() => {
      this.store.dispatch(this.actions.removeStudyCenterCode(code));
    });
  }

  filter(): void {
  }

  private showDialog(code: StudyCenterCode): void {
    console.log('create');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(StudyCenterCodeEditorDialog, config);
    if (code) this.creatorDialogRef.componentInstance.studyCenterCode = code; // set
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
    });
  }

}
