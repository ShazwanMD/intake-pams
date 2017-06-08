import {SubjectCode} from './../../common/subject-codes/subject-code.interface';
import {Component, OnInit, ViewContainerRef} from "@angular/core";
import {Store} from "@ngrx/store";
import {SetupActions} from "../setup.action";
import {SetupModuleState} from "../index";
import {Observable} from "rxjs/Observable";
import {SubjectCodeEditorDialog} from "./dialog/subject-code-editor.dialog";
import { MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar } from "@angular/material";

@Component({
  selector: 'pams-subject-list-page',
  templateUrl: './subject-code-list.page.html',
})
export class SubjectCodeListPage implements OnInit {

  private SUBJECT_CODES = "setupModuleState.subjectCodes".split(".");
  private subjectCodes$: Observable<SubjectCode>;
  private creatorDialogRef: MdDialogRef<SubjectCodeEditorDialog>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'descriptionMs', label: 'DescriptionMs'},
    {name: 'descriptionEn', label: 'DescriptionEn'},
    {name: 'action', label: ''}
  ];

  constructor(private actions: SetupActions,
              private store: Store<SetupModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private snackBar: MdSnackBar) {
    this.subjectCodes$ = this.store.select(...this.SUBJECT_CODES);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findSubjectCodes());
    this.store.dispatch(this.actions.changeTitle("Subject Codes"))
  }

  createDialog(): void {
    this.showDialog(null);
  }

  editDialog(code:SubjectCode): void {
    this.showDialog(code);
  }

  delete(code: SubjectCode): void {
    let snackBarRef = this.snackBar.open("Delete this subject code?", "Ok");
    snackBarRef.afterDismissed().subscribe(() => {
    this.store.dispatch(this.actions.removeSubjectCode(code))
    });
  }
  filter(): void {
  }

  private showDialog(code:SubjectCode): void {
    console.log("create");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(SubjectCodeEditorDialog, config);
    if(code) this.creatorDialogRef.componentInstance.subjectCode = code; // set
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }

}
