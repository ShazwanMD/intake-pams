import { AttachmentType } from './../../../../shared/model/application/attachment-type.enum';
import { AttachmentHelper } from './attachment-helper.interface';
import { IntakeApplication } from './../../../../shared/model/application/intake-application.interface';
import {Component, ViewContainerRef, OnInit, Input} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import {ApplicationModuleState} from '../../index';
import {MdDialogRef, MdSnackBar} from '@angular/material';
import {IntakeApplicationActions} from '../intake-application.action';
import {Employment} from '../../../../shared/model/application/employment.interface';
import {EmploymentType} from '../../../../shared/model/application/employment-type.enum';
import { Observable } from "rxjs/Rx";
import { Attachment } from '../../../../shared/model/application/attachment.interface';

@Component({
  selector: 'pams-research-proposal-uploader-editor',
  templateUrl: './research-proposal-uploader.dialog.html',
})

export class ResearchProposalUploaderDialog implements OnInit {

  
  private INTAKE_APPLICATIONS: string[] = 'accountModuleState.intakeApplications'.split('.');
 
 // private intakeApplications$: Observable<IntakeApplication[]>;
    
  private _intakeApplication: IntakeApplication;
  private rschProposalForm: FormGroup;
  private _attachment: Attachment;
  private edit: boolean = false;


  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<ApplicationModuleState>,
              private actions: IntakeApplicationActions,
              private snackBar: MdSnackBar,
              private dialog: MdDialogRef<ResearchProposalUploaderDialog>) {
                
  }


  set intakeApplications(value: IntakeApplication) {
      console.log("intakeApplication : "+value.referenceNo);
    this._intakeApplication= value;
  }

  set attachment(value: Attachment){
    this._attachment = value;
    this.edit = true;
  }

  set intakeApplication(value: IntakeApplication) {
    this._intakeApplication = value;
  }

  ngOnInit(): void {
    this.rschProposalForm = this.formBuilder.group(<AttachmentHelper>{
      attachmentType: AttachmentType.RESEARCH_PROPOSAL,
    });
  }

  upload(attachmentHelper: AttachmentHelper, file: File) {
    if(confirm('Please make sure that your file is not exceed 1 mb'))
    {
      if(file.type == 'application/pdf'){
      this.store.dispatch(this.actions.addAndCheckAttachment(this._intakeApplication, file, attachmentHelper.attachmentType));
      this.dialog.close();
     // window.location.reload();

    }else{
      console.log("not pdf");

      let snackBarRef = this.snackBar.open('File Upload Must In PDF Format','OK');
      snackBarRef.afterDismissed().subscribe(() => {
         //window.location.reload();
     });
    }
    }
   else {
 }
  }

}
