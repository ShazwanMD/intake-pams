import {StudyModeCreatorDialog} from './dialog/study-mode-creator.dialog';
import {MdDialogConfig, MdDialogRef, MdDialog} from '@angular/material';
import {Component, OnInit, ChangeDetectionStrategy, state, ViewContainerRef} from '@angular/core';
import {Store} from '@ngrx/store';
import {SetupActions} from '../setup.action';
import {SetupModuleState} from '../index';
import {Observable} from 'rxjs/Observable';
import {StudyMode} from '../../../../shared/model/common/study-mode.interface';

@Component({
  selector: 'pams-study-list-page',
  templateUrl: './study-mode-list.page.html',
})
export class StudyModeListPage implements OnInit {

  private STUDY_MODES: string[] = 'setupModuleState.studyModes'.split('.');
  private creatorDialogRef: MdDialogRef<StudyModeCreatorDialog>;
  private studyModes$: Observable<StudyMode>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'descriptionMs', label: 'DescriptionMs'},
    {name: 'descriptionEn', label: 'DescriptionEn'},
    {name: 'prefix', label: 'Prefix'},
    {name: 'action', label: ''},
  ];

  constructor(private actions: SetupActions,
              private store: Store<SetupModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
    this.studyModes$ = this.store.select(...this.STUDY_MODES);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findStudyModes());
    this.store.dispatch(this.actions.changeTitle('Study Modes'));
  }

  createDialog(): void {
    this.showDialog(null);
  }

  editDialog(code: StudyMode): void {
    this.showDialog(code);
  }

  delete(code: StudyMode): void {
    this.store.dispatch(this.actions.removeStudyMode(code));
  }

  filter(): void {
  }

  private showDialog(code: StudyMode): void {
    console.log('create');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(StudyModeCreatorDialog, config);
    if (code) this.creatorDialogRef.componentInstance.studyMode = code; // set
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
    });
  }
}
