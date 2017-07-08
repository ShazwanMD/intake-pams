import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import {SetupModuleState} from '../../index';
import {SetupActions} from '../../setup.action';
import {GraduateCenter} from '../../../../../shared/model/common/graduate-center.interface';

@Component({
  selector: 'pams-graduate-center-creator',
  templateUrl: './graduate-center-creator.dialog.html',
})

export class GraduateCenterCreatorDialog implements OnInit {

  private createForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<GraduateCenterCreatorDialog>,
              private store: Store<SetupModuleState>,
              private actions: SetupActions,
  ) {
  }

  ngOnInit(): void {

    this.createForm = this.formBuilder.group(<GraduateCenter>{
      id: null,
      code: '',
      descriptionMs: '',
      descriptionEn: '',
    });
  }

  save(code: GraduateCenter, isValid: boolean) {
    this.store.dispatch(this.actions.saveGraduateCenter(code));
    this.dialog.close();
  }
}
