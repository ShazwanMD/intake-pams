import {LanguageCodeEditorDialog} from './dialog/language-code-editor.dialog';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {Store} from '@ngrx/store';
import {SetupActions} from '../setup.action';
import {SetupModuleState} from '../index';
import {Observable} from 'rxjs/Observable';
import {MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar} from '@angular/material';
import {LanguageCode} from '../../../shared/model/common/language-code.interface';

@Component({
  selector: 'pams-language-list-page',
  templateUrl: './language-code-list.page.html',
})
export class LanguageCodeListPage implements OnInit {

  private LANGUAGE_CODES: string[] = 'setupModuleState.languageCodes'.split('.');
  private languageCodes$: Observable<LanguageCode>;
  private creatorDialogRef: MdDialogRef<LanguageCodeEditorDialog>;
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
    this.languageCodes$ = this.store.select(...this.LANGUAGE_CODES);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findLanguageCodes());
    this.store.dispatch(this.actions.changeTitle('Language Codes'));
  }

  createDialog(): void {
    this.showDialog(null);
  }

  editDialog(code: LanguageCode): void {
    this.showDialog(code);
  }

  delete(code: LanguageCode): void {
    let snackBarRef = this.snackBar.open('Delete this language code?', 'Ok');
    snackBarRef.afterDismissed().subscribe(() => {
      this.store.dispatch(this.actions.removeLanguageCode(code));
    });
  }

  filter(): void {
  }

  private showDialog(code: LanguageCode): void {
    console.log('create');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(LanguageCodeEditorDialog, config);
    if (code) this.creatorDialogRef.componentInstance.languageCode = code; // set
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
    });
  }
}
