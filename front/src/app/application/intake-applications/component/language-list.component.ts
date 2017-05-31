import {Language} from './../language.interface';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, OnInit, ViewContainerRef} from '@angular/core';
import {IntakeApplicationActions} from "../intake-application.action";
import {Store} from "@ngrx/store";
import {ApplicationModuleState} from "../../index";
import {IntakeApplication} from "../intake-application.interface";
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";
import {LanguageCreatorDialog} from "./dialog/language-creator.dialog";

@Component({
  selector: 'pams-language-list',
  templateUrl: './language-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class LanguageListComponent implements OnInit {

  @Input() languages: Language[];
  @Input() intakeApplication: IntakeApplication;

  private creatorDialogRef: MdDialogRef<LanguageCreatorDialog>;
  private columns: any[] = [
    {name: 'languageCode.descriptionMs', label: 'Language'},
    {name: 'oral', label: 'Oral Proficiency'},
    {name: 'written', label: 'Written Proficiency'},
  ];

  constructor(private actions: IntakeApplicationActions,
              private vcf: ViewContainerRef,
              private store: Store<ApplicationModuleState>,
              private dialog: MdDialog) {}

  ngOnInit(): void {
  }

  showDialog(): void {
    console.log("showDialog");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(LanguageCreatorDialog, config);
    this.creatorDialogRef.componentInstance.intakeApplication = this.intakeApplication = this.intakeApplication;
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
      // load something here
    });
  }

}
