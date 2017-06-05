import {GradeCode} from './../../common/grade-codes/grade-code.interface';
import {Component, OnInit, ViewContainerRef} from "@angular/core";
import {Store} from "@ngrx/store";
import {SetupActions} from "../setup.action";
import {SetupModuleState} from "../index";
import {Observable} from "rxjs/Observable";
import {GradeCodeEditorDialog} from "./dialog/grade-code-editor.dialog";
import { MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar } from "@angular/material";

@Component({
  selector: 'pams-grade-list-page',
  templateUrl: './grade-code-list.page.html',
})
export class GradeCodeListPage implements OnInit {

  private GRADE_CODES = "setupModuleState.gradeCodes".split(".");
  private gradeCodes$: Observable<GradeCode>;
  private creatorDialogRef: MdDialogRef<GradeCodeEditorDialog>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'description', label: 'Description'},
    {name: 'action', label: ''}
  ];

  constructor(private actions: SetupActions,
              private store: Store<SetupModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private snackBar: MdSnackBar) {
    this.gradeCodes$ = this.store.select(...this.GRADE_CODES);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findGradeCodes());
    this.store.dispatch(this.actions.changeTitle("Grade Codes"))
  }

  createDialog(): void {
    this.showDialog(null);
  }

  editDialog(code:GradeCode): void {
    this.showDialog(code);
  }

  delete(code: GradeCode): void {
    let snackBarRef = this.snackBar.open("Delete this grade code?", "Ok");
    snackBarRef.afterDismissed().subscribe(() => {
    this.store.dispatch(this.actions.removeGradeCode(code))
    });
  }

  filter(): void {
  }

  private showDialog(code:GradeCode): void {
    console.log("create");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(GradeCodeEditorDialog, config);
    if(code) this.creatorDialogRef.componentInstance.gradeCode = code; // set
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }

}
