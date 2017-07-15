import {LanguageEditorDialog} from './dialog/language-editor.dialog';
import {Language} from '../../../../shared/model/application/language.interface';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, OnInit, ViewContainerRef} from '@angular/core';
import {IntakeApplicationActions} from '../intake-application.action';
import {Store} from '@ngrx/store';
import {ApplicationModuleState} from '../../index';
import {IntakeApplication} from '../../../../shared/model/application/intake-application.interface';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';

@Component({
  selector: 'pams-language-list',
  templateUrl: './language-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class LanguageListComponent implements OnInit {

  @Input() languages: Language[];
  @Input() intakeApplication: IntakeApplication;

  private selectedRows: Language[];
  private editorDialogRef: MdDialogRef<LanguageEditorDialog>;
  private columns: any[] = [
    {name: 'languageCode.descriptionMs', label: 'Language'},
    {name: 'oral', label: 'Oral Proficiency'},
    {name: 'written', label: 'Written Proficiency'},
  ];

  constructor(private actions: IntakeApplicationActions,
              private vcf: ViewContainerRef,
              private store: Store<ApplicationModuleState>,
              private dialog: MdDialog) {
  }

  ngOnInit(): void {
    this.selectedRows = this.languages.filter((value) => value.selected);
  }

  create(): void {
    this.showDialog(null);
  }

  edit(language: Language): void {
    this.showDialog(language);
  }

  delete(): void {
    console.log('length: ' + this.selectedRows.length);
    for (let i: number = 0; i < this.selectedRows.length; i++) {
      this.store.dispatch(this.actions.deleteLanguage(this.intakeApplication, this.selectedRows[i]));
    }
    this.selectedRows = [];
  }

  filter(): void {
  }

  selectRow(language: Language): void {
  }

  selectAllRows(languages: Language[]): void {
  }

  showDialog(language: Language): void {
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '60%';
    config.position = {top: '65px'};
    this.editorDialogRef = this.dialog.open(LanguageEditorDialog, config);
    this.editorDialogRef.componentInstance.intakeApplication = this.intakeApplication;
    if (language) this.editorDialogRef.componentInstance.language = language;
    this.editorDialogRef.afterClosed().subscribe((res) => {
      this.selectedRows = [];
    });
  }
}
