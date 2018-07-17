import {Component, ViewContainerRef, OnInit, AfterViewInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import { MdDialogRef, MdSnackBar } from '@angular/material';
import {SetupModuleState} from '../../index';
import {SetupActions} from '../../setup.action';
import {SupervisorOffering} from '../../../../shared/model/common/supervisor-offering.interface';
import { SupervisorCode } from '../../../../shared/model/common/supervisor-code.interface';
import { ProgramLevel } from '../../../../shared/model/policy/program-level.interface';

@Component({
  selector: 'pams-supervisor-offering-editor',
  templateUrl: './supervisor-offering-editor.dialog.html',
})

export class SupervisorOfferingEditorDialog implements OnInit {

  private editorForm: FormGroup;
  private edit: boolean = false;
  private _supervisorOffering: SupervisorOffering;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<SupervisorOfferingEditorDialog>,
              private store: Store<SetupModuleState>,
              private actions: SetupActions,
              private snackBar: MdSnackBar) {
  }

  set supervisorOffering(value: SupervisorOffering) {
    this._supervisorOffering = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group({
      id: null,
      supervisorCode: [<SupervisorCode>{}],
      programLevel: <ProgramLevel>{},
    });

    if (this.edit) this.editorForm.patchValue(this._supervisorOffering);
  }

  submit(offering: SupervisorOffering, isValid: boolean) {
    if (confirm('Confirm to update supervisor offering?')) {
    if (!offering.id) this.store.dispatch(this.actions.saveSupervisorOfferings(offering));
    else  this.store.dispatch(this.actions.updateSupervisorOfferings(offering));
    this.dialog.close();
    };
  }
}
